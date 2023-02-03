package com.camp.admin.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.HomeDTO;
import com.camp.admin.service.HomeService;

@Controller
@RequestMapping("/waymap")
public class WaymapController {
	
	String dir = "waymap/";
	
	@Autowired
	HomeService service;
	
	@RequestMapping("")
	public String main(HttpSession session, Model model) {
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		HomeDTO home = null;
		
		try {
			home = service.select(company.getCompany_code());	//홈페이지코드
			model.addAttribute("kkomap", home);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FAIL");
		}
		
		
		
		model.addAttribute("center", dir+"waymap");
		return "main";
	}
	
	
}
