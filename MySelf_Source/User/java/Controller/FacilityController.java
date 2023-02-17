package com.camp.camping.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.camping.DTO.CompanyDTO;
import com.camp.camping.DTO.FacilityDTO;
import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.service.FacilityService;
import com.camp.camping.service.HomeService;

@Controller
@RequestMapping("/facility")
public class FacilityController {

	String dir = "facility/";

	@Autowired
	FacilityService service;

	@Autowired
	HomeService serviceH;

	@RequestMapping("")
	public String main(Model model, HttpSession session) {
		List<FacilityDTO> list = null;
		HomeDTO homecont = null;

		CompanyDTO company = (CompanyDTO) session.getAttribute("company");

		try {
			list = service.selectByCompany(company.getCompany_code());
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("실패");
		}
		model.addAttribute("facilities", list);

		try {
			homecont = serviceH.select(company.getCompany_code());
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}

		model.addAttribute("center", dir + "facility");

		return "main";
	}
}
