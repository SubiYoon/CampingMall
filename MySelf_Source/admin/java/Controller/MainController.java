package com.camp.admin.Controller;

import com.camp.admin.utility.MakeHeadGraph;
import com.camp.admin.utility.MakeMainGraph;
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
    public String main() {

        return "login";
    }

    @RequestMapping("/loginOk")
    public String loginOk(AdminDTO admin, HttpSession session) {
        String crypPwd = "";
        try {
            crypPwd = CryptoUtil.sha512(admin.getAdmin_password());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("암호화실패");
        }

        try {
            AdminDTO dbAdmin = serviceA.select(admin.getAdmin_id());
            if (crypPwd.equals(dbAdmin.getAdmin_password())) {
                CompanyDTO company = serviceC.select(dbAdmin.getCompany_code());
                session.setAttribute("company", company);
                session.setAttribute("admin", dbAdmin);
            } else {
                return "login";
            }
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("실패");
        }

        return "redirect:main";
    }

    @RequestMapping("/company")
    public String companyEdit(HttpSession session, Model model) {
        CompanyDTO company = (CompanyDTO) session.getAttribute("company");
        try {
            serviceC.select(company.getCompany_code());
            model.addAttribute("company", company);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("center", "/company");
        return "main";
    }

    @RequestMapping("/home")
    public String homeEdit(Model model, HttpSession session) {
        CompanyDTO company = (CompanyDTO) session.getAttribute("company");
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
    public String boardEdit(HttpSession session, HomeDTO home, MultipartFile mf) {
        try {
            if (!mf.isEmpty()) {
                home.setHome_image(logoEditFileSave(mf, home.getHome_image()));
            }
            serviceH.update(home);

            System.out.println("성공");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("실패");
        }

        return "redirect:/home";
    }

    @RequestMapping("logoEdit")
    public String logoEdit(HttpSession session, MultipartFile company_logo1,
            MultipartFile company_logo2, String company_name) {
        CompanyDTO company = (CompanyDTO) session.getAttribute("company");

        if (!company_logo1.isEmpty() && !company_logo2.isEmpty()) {
            try {
                company.setCompany_name(company_name);
                company.setCompany_logo1(logoEditFileSave(company_logo1, company.getCompany_logo1()));
                company.setCompany_logo2(logoEditFileSave(company_logo2, company.getCompany_logo2()));

                serviceC.update(company);

                session.invalidate();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (!company_logo1.isEmpty() && company_logo2.isEmpty()) {
            try {
                company.setCompany_name(company_name);
                company.setCompany_logo1(logoEditFileSave(company_logo1, company.getCompany_logo1()));

                serviceC.update(company);

                session.invalidate();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (company_logo1.isEmpty() && !company_logo2.isEmpty()) {
            try {
                company.setCompany_name(company_name);
                company.setCompany_logo2(logoEditFileSave(company_logo2, company.getCompany_logo2()));

                serviceC.update(company);

                session.invalidate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                company.setCompany_name(company_name);
                serviceC.update(company);

                session.invalidate();
            } catch (Exception e) {
                // e.printStackTrace();
                System.out.println("실패");
            }
        }

        return "redirect:/";
    }

    @RequestMapping("slideEdit")
    public String slideEdit(MultipartFile home_slide, int image_code) {
        ImageDTO image = null;
        try {
            image = serviceI.select(image_code);
            serviceI.update(home_slide, image);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("파일변경 실패");
        }

        return "redirect:/home";
    }

    @RequestMapping("slideDelete")
    public String slideDelete(int image_code) {

        try {
            serviceI.delete(image_code);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.print("실패");
        }

        return "redirect:/home";
    }

    @RequestMapping("slideAdd")
    public String slideAdd(HttpSession session, MultipartFile file, int home_code) {
        CompanyDTO company = (CompanyDTO) session.getAttribute("company");
        ImageDTO image = new ImageDTO();

        if (!file.isEmpty()) {
            image.setCompany_code(company.getCompany_code());
            image.setHome_code(home_code);

            try {
                serviceI.insert(file, image);
            } catch (Exception e) {
                // e.printStackTrace();
                System.out.print("실패");
            }
        }
        return "redirect:/home";
    }

    @RequestMapping("logOut")
    public String logOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    // 이미지 업로드 메서드(반환값은 업로드한 파일 이름)
    public String logoEditFileSave(MultipartFile mf, String imageName) throws Exception {
        String fileName = mf.getOriginalFilename();
        int fileCount = 1;
        List<ImageDTO> imgAll = serviceI.selectAll();

        SaveFile.deleteFile(imagesdir, imageName);
        for (int i = 0; i < imgAll.size(); i++) {
            if (imgAll.get(i).getImage_file().equals(fileName)) {
                String[] filearr = mf.getOriginalFilename().split("\\.");
                fileName = filearr[0] + "(" + fileCount + ")" + "." + filearr[1];
                fileCount++;
                i = 0;
            }
        }
        SaveFile.saveFile(mf, imagesdir, fileName);
        return fileName;
    }
}