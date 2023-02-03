package com.camp.admin.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.FacilityDTO;
import com.camp.admin.service.FacilityService;

@Controller
@RequestMapping("/facility")
public class FacilityController {
	
	String dir = "facility/";
	
	@Autowired
	FacilityService service;

	@RequestMapping("")
	public String main(Model model, HttpSession session) {
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		List<FacilityDTO> list = null;
		
		try {
			list = service.selectByCompany(company.getCompany_code());
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}

		model.addAttribute("facilities", list);
		model.addAttribute("center", dir+"facility");
		return "main";
	}
	
}
