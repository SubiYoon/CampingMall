package com.camp.admin.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.camp.admin.DTO.AdminDTO;
import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.HomeDTO;
import com.camp.admin.DTO.ImageDTO;
import com.camp.admin.DTO.ZoneDTO;
import com.camp.admin.service.AdminService;
import com.camp.admin.service.BookService;
import com.camp.admin.service.CompanyService;
import com.camp.admin.service.FacilityService;
import com.camp.admin.service.HomeService;
import com.camp.admin.service.ImageService;
import com.camp.admin.service.NoticeService;
import com.camp.admin.service.ReviewService;
import com.camp.admin.service.ZoneService;
import com.camp.admin.utility.CryptoUtil;
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
	
	@Autowired
	BookService serviceB;
	
	@Autowired
	ReviewService serviceR;

	@RequestMapping("/")
	public String main(){

		return "login";
	}

	@RequestMapping("/loginOk")
	public String loginOk(AdminDTO admin, HttpSession session){
		String crypPwd ="";
		try{
			crypPwd = CryptoUtil.sha512(admin.getAdmin_password());
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("암호화실패");
		}

		try{
			AdminDTO dbAdmin = serviceA.select(admin.getAdmin_id());
			if(crypPwd.equals(dbAdmin.getAdmin_password())){
				CompanyDTO company = serviceC.select(dbAdmin.getCompany_code());
				session.setAttribute("company", company);
				session.setAttribute("admin", dbAdmin);
			}else {
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
        CompanyDTO company = (CompanyDTO) session.getAttribute("company");
        List<ZoneDTO> listZ = null;

        LocalDate now = LocalDate.now();
        String month = ("0" + now.getMonthValue());
        month = month.substring(month.length() - 2);
        int companyCode = company.getCompany_code();
        String stringYearAndMonth = "" + now.getYear() + "-" + month;
		String stringDate = stringYearAndMonth+"-01";
        List<String> charts = new ArrayList<>();
        try {
            charts.add("" + Math.round(serviceB.MonthlySales(stringDate, companyCode)));
            charts.add(serviceB.MonthlySalesRate(stringYearAndMonth, companyCode));
            charts.add("" + serviceB.MonthlyBookCount(stringDate, companyCode));
            charts.add(serviceB.MonthlyBookRate(stringYearAndMonth, companyCode));
            charts.add("" + serviceB.MonthlyUser(stringYearAndMonth, companyCode));
            charts.add(serviceB.MonthlyUserRate(stringYearAndMonth, companyCode));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
		model.addAttribute("MonthList",charts);
        try {
            listZ = serviceZ.selectZone(company.getCompany_code());    //상호코드
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.setAttribute("zlist", listZ);
        
        
        try {
			List<Map<String,Object>> books=serviceB.selectAllmain();
			model.addAttribute("books",books);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		try {
			List<Map<String, Object>> reviews = serviceR.selectAllmain();
			model.addAttribute("reviews",reviews);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

        return "main";
    }


	//CompanyEdit
	@RequestMapping("/company")
	public String companyEdit(HttpSession session, Model model) {
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		try{
			serviceC.select(company.getCompany_code());
			model.addAttribute("company", company);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("center", "/company");
		return "main";
	}

	//CompanyEdit
	@RequestMapping("/home")
	public String homeEdit(Model model, HttpSession session) {
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		try {
			HomeDTO home = serviceH.select(company.getCompany_code());
			model.addAttribute("home", home);

			List<ImageDTO> img = serviceI.selectByHomeCode(home.getHome_code());
			model.addAttribute("slideImgs", img);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("center", "/home");
		return "main";
	}
	
	@RequestMapping("/bookEdit")
	public String bookedit(Model model) {
		
		model.addAttribute("center", "/bookEdit");
		return "main";
	}

	@RequestMapping("homeEdit")
	public String boardEdit(HttpSession session ,HomeDTO home){
			try{
				serviceH.update(home);
				System.out.println("성공");
			}catch(Exception e){
				//e.printStackTrace();
				System.out.println("실패");
			}

		return "redirect:/home";
	}
	
	@RequestMapping("logoEdit")
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

				session.invalidate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(!company_logo1.isEmpty() && company_logo2.isEmpty()){
			try {
				company = serviceC.select(company_code);
				company.setCompany_logo1(company_logo1.getOriginalFilename());
				SaveFile.saveFile(company_logo1, imagesdir);
				serviceC.update(company);

				session.invalidate();
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
		}else return "redirect:/company";
		
		

		return "redirect:/";
	}
	
	@RequestMapping("slideEdit")
	public String slideEdit(MultipartFile home_slide, int image_code){
		ImageDTO image = null;
		try{
		image = serviceI.select(image_code);
			image.setImage_file(home_slide.getOriginalFilename());
			serviceI.update(image);
			SaveFile.saveFile(home_slide, imagesdir);
		}catch(Exception e){
			//e.printStackTrace();
			System.out.println("파일변경 실패");
		}
		
		return "redirect:/home";
	}

	@RequestMapping("slideDelete")
	public String slideDelete(int image_code){
		
		try {
			serviceI.delete(image_code);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.print("실패");
		}
		
		return "redirect:/home";
	}

	@RequestMapping("slideAdd")
	public String slideAdd(HttpSession session, MultipartFile file, int home_code){
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		ImageDTO image = new ImageDTO();
		
		if(!file.isEmpty()){
			image.setCompany_code(company.getCompany_code());
			image.setHome_code(home_code);
			image.setImage_file(file.getOriginalFilename());
			
			try {
				serviceI.insert(image);
				SaveFile.saveFile(file, imagesdir);
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.print("실패");
			}
		}
		return "redirect:/home";
	}

	@RequestMapping("logOut")
	public String logOut(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}