package com.camp.admin.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.camp.admin.DTO.AdminDTO;
import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.FacilityDTO;
import com.camp.admin.DTO.ImageDTO;
import com.camp.admin.service.FacilityService;
import com.camp.admin.service.ImageService;
import com.camp.admin.utility.SaveFile;

@Controller
@RequestMapping("/facility")
public class FacilityController {

	@Value("${imagesdir}")
	String imagesdir;

	String dir = "facility/";

	@Autowired
	FacilityService service;
	@Autowired
	ImageService serviceI;

	@RequestMapping("")
	public String main(Model model, HttpSession session) {
		CompanyDTO company = (CompanyDTO) session.getAttribute("company");
		List<FacilityDTO> list = null;

		try {
			list = service.selectByCompany(company.getCompany_code());
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("실패");
		}

		model.addAttribute("facilities", list);
		model.addAttribute("center", dir + "facility");
		return "/main";
	}

	@RequestMapping("edit")
	public String edit(Model model, int facility_code) {

		try {
			FacilityDTO fac = service.select(facility_code);
			model.addAttribute("boardEdit", fac);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("center", dir + "boardEditer");

		return "/main";
	}

	@RequestMapping("boardEditOk")
	public String boardEditOk(Model model, FacilityDTO facilityDTO, MultipartFile mf) {

		try {
			FacilityDTO fac = service.select(facilityDTO.getFacility_code());

			fac.setFacility_content(facilityDTO.getFacility_content());
			fac.setFacility_name(facilityDTO.getFacility_name());

			service.update(fac);

			if (!mf.isEmpty()) {
				ImageDTO img = serviceI.select(fac.getImage_code());
				serviceI.update(mf, img);

				SaveFile.saveFile(mf, imagesdir, mf.getOriginalFilename());
			}

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("실패");
		}
		return "redirect:/facility";
	}

	@RequestMapping("delete")
	public String boardDelete(int facility_code) {

		try {
			FacilityDTO fac = service.select(facility_code);
			serviceI.delete(fac.getImage_code());
			service.delete(facility_code);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("실패");
		}

		return "redirect:/facility";
	}

	@RequestMapping("insert")
	public String boradInsert(Model model) {

		model.addAttribute("center", dir + "boardInsert");

		return "main";
	}

	@RequestMapping("insertOk")
	public String boradInsertOk(String board_name, String board_content, HttpSession session, MultipartFile mf) {
		AdminDTO admin = (AdminDTO) session.getAttribute("admin");
		CompanyDTO company = (CompanyDTO) session.getAttribute("company");

		FacilityDTO fac = new FacilityDTO();
		fac.setFacility_name(board_name);
		fac.setFacility_content(board_content);
		fac.setAdmin_code(admin.getAdmin_code());

		if (!mf.isEmpty()) {
			try {
				service.insert(fac);

				List<FacilityDTO> facList = service.selectAll();

				ImageDTO img = new ImageDTO();
				img.setCompany_code(company.getCompany_code());
				img.setFacility_code(facList.get(facList.size() - 1).getFacility_code());
				serviceI.insert(mf, img);

				SaveFile.saveFile(mf, imagesdir, mf.getOriginalFilename());

			} catch (Exception e) {
				// e.printStackTrace();
				System.out.println("실패");
			}
		}

		return "redirect:/facility";
	}
}
