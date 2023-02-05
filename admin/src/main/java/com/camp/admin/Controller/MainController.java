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

import com.camp.admin.DTO.AdminDTO;
import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.HomeDTO;
import com.camp.admin.DTO.ImageDTO;
import com.camp.admin.DTO.ZoneDTO;
import com.camp.admin.service.AdminService;
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

	@Autowired
	AdminService serviceA;

	@RequestMapping("/")
	public String main(){
		
		return "login";
	}

	@RequestMapping("/loginOk")
	public String loginOk(AdminDTO admin, HttpSession session){
		
		try{
			AdminDTO dbAdmin = serviceA.select(admin.getAdmin_id());
			if(admin.getAdmin_password().equals(dbAdmin.getAdmin_password())){
				CompanyDTO company = serviceC.select(dbAdmin.getCompany_code());
				session.setAttribute("company", company);
				session.setAttribute("admin", dbAdmin);
			}else {
				System.out.println(dbAdmin);
				return "login";
			}
		} catch(Exception e){
			//e.printStackTrace();
			System.out.println("실패");
		}

		return "redirect:main";
	}

	@RequestMapping("/main")
	public String main(Model model, HttpSession session, CompanyDTO companyDTO, ZoneDTO zoneDTO) {
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		List<ZoneDTO> listZ = null;
		
		try {
			listZ=serviceZ.selectZone(company.getCompany_code());	//상호코드
		} catch (Exception e) {
			e.printStackTrace();
		}	
		session.setAttribute("zlist", listZ);
		
		return "main";
	}
	
	@RequestMapping("/mainEdit")
	public String mainedit(Model model) {
		
		model.addAttribute("center", "/mainEdit");
		return "main";
	}
	
	@RequestMapping("/userEdit")
	public String useredit(Model model) {
		
		model.addAttribute("center", "/userEdit");
		return "main";
	}
	
	@RequestMapping("/bookEdit")
	public String bookedit(Model model) {
		
		model.addAttribute("center", "/bookEdit");
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

	@RequestMapping("logOut")
	public String logOut(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}