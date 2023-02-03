package com.camp.admin.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.FacilityDTO;
import com.camp.admin.DTO.HomeDTO;
import com.camp.admin.DTO.ImageDTO;
import com.camp.admin.DTO.NoticeDTO;
import com.camp.admin.DTO.ZoneDTO;
import com.camp.admin.service.CompanyService;
import com.camp.admin.service.FacilityService;
import com.camp.admin.service.HomeService;
import com.camp.admin.service.ImageService;
import com.camp.admin.service.NoticeService;
import com.camp.admin.service.ZoneService;
import com.camp.admin.utility.SaveFile;

@Controller
public class MainController {
	
	@Value("${imagesdir}")
	String imagesdir;

	@Autowired
	CompanyService serviceC;

	@Autowired
	HomeService serviceH;
	
	@Autowired
	NoticeService serviceN;

	@Autowired
	FacilityService serviceF;
	
	@Autowired
	ZoneService serviceZ;
	
	@Autowired
	ImageService serviceI;

	@RequestMapping("/")
	public String select(){
		
		return "redirect:/main";
	}

	@RequestMapping("/main")
	public String main(Model model, HttpSession session, CompanyDTO companyDTO, ZoneDTO zoneDTO, ImageDTO imageDTO) {
		
		HomeDTO homekko = null;		//카카오맵
		HomeDTO homecont = null;	//홈페이지소개
		CompanyDTO company = null;
		List<NoticeDTO> nolist = null;	//주요공지
		List<ZoneDTO> listZ = null;	//구역소개
		List<FacilityDTO> list = null;	//편의시설
		List<ImageDTO> listI = null;
		
		
		//상호 세션 생성-----------------------------
		//TODO:차후 캠핑장 선택 페이지 생성시 수정 필요
		try{
			company = serviceC.select(1);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("실패123");
		}
			session.setAttribute("company", company);
		//카카오맵경도위도-------------------------------------
		try {
			homekko = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("kkomap", homekko);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MAP_FAIL");
		}
		
		//홈페이지소개content----------------------------------
		try {
			homecont = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}
		
		//주요공지----------------------------------
		
		try {
			nolist = serviceN.noticeLv(company.getCompany_code());	//상호코드
			model.addAttribute("noticeLv", nolist);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("NoticeLv_FAIL");
		}
		
		//구역소개----------------------------------
		
		try {
			listZ=serviceZ.selectZone(company.getCompany_code());	//상호코드
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		model.addAttribute("zlist", listZ);
		
		//편의시설----------------------------------
		
		try {
			list = serviceF.selectByCompany(company.getCompany_code());	//상호코드
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}
		model.addAttribute("facilities", list);
		
		//이미지------------------------------------

		listI=serviceI.selectByCompanyCode(company.getCompany_code());	//상호코드
		model.addAttribute("ilist", listI);

		//슬라이드 이미지
		listI=serviceI.selectByHomeCode(homecont.getHome_code());
		model.addAttribute("slide", listI);

		return "main";
	}

	@RequestMapping("board/edit")
	public String boardEdit(HttpSession session ,String whatDTO, String title, String content, int board_code){
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");

		if(whatDTO.equals("homeDTO")){
			HomeDTO homeDTO = new HomeDTO();
			homeDTO.setHome_code(board_code);
			homeDTO.setHome_content(content);

			try{
				serviceH.update(homeDTO);
				System.out.println("성공");
			}catch(Exception e){
				//e.printStackTrace();
				System.out.println("실패");
			}
		}

		return "redirect:/";
	}
	
	@RequestMapping("logo/edit")
	public String logoEdit(HttpSession session, MultipartFile company_logo1, MultipartFile company_logo2){
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		int company_code = company.getCompany_code();
		if(!company_logo1.isEmpty() && !company_logo2.isEmpty()){
			try {
				company.setCompany_logo1(company_logo1.getOriginalFilename());
				company.setCompany_logo2(company_logo2.getOriginalFilename());
				serviceC.update(company);
				SaveFile.saveFile(company_logo1, imagesdir);
				SaveFile.saveFile(company_logo2, imagesdir);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}else if(!company_logo1.isEmpty() && company_logo2.isEmpty()){
			try {
				company = serviceC.select(company_code);
				company.setCompany_logo1(company_logo1.getOriginalFilename());
				SaveFile.saveFile(company_logo1, imagesdir);
				serviceC.update(company);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(company_logo1.isEmpty() && !company_logo2.isEmpty()){
			try {
				company = serviceC.select(company_code);
				company.setCompany_logo2(company_logo2.getOriginalFilename());
				SaveFile.saveFile(company_logo2, imagesdir);
				serviceC.update(company);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else return "redirect:/main";
		
		return "redirect:/main";
	}
	
	@RequestMapping("slide/edit")
	public String slideEdit(HttpSession session, List<MultipartFile> home_slide, @RequestParam List<Integer> image_code, int home_code){
		ImageDTO image = null;
		
		for(int i=0; i<home_slide.size(); i++){
			if(!home_slide.get(i).isEmpty()){
				try{
					image = serviceI.select(image_code.get(i));
					image.setImage_file(home_slide.get(i).getOriginalFilename());
					image.setHome_code(home_code);
					serviceI.update(image);
					SaveFile.saveFile(home_slide.get(i), imagesdir);
				}catch(Exception e){
					//e.printStackTrace();
					System.out.println("파일변경 실패");
				}
			}
		}

		return "redirect:/main";
	}

	@RequestMapping("slide/delete")
	public String slideDelete(int image_code){
		
		try {
			serviceI.delete(image_code);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.print("실패");
		}
		
		return "redirect:/main";
	}

	@RequestMapping("slide/add")
	public String slideAdd(HttpSession session, MultipartFile file, int home_code){
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		ImageDTO image = new ImageDTO();
		
		if(!file.isEmpty()){
			image.setCompany_code(company.getCompany_code());
			image.setHome_code(home_code);
			image.setImage_file(file.getOriginalFilename());
			
			try {
				serviceI.insert(image);
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.print("실패");
			}
		}
		return "redirect:/main";
	}
}