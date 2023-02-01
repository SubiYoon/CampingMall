package com.camp.camping.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.camping.DTO.CompanyDTO;
import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.service.HomeService;

@Controller
@RequestMapping("/waymap")
public class WaymapController {
	
	String dir = "waymap/";
	
	@Autowired
	HomeService serviceH;
	
	@RequestMapping("")
	public String main(HttpSession session, Model model) {
		
		HomeDTO home = null;
		HomeDTO homecont = null;	//home테이블전체정보
		
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		
		try {
			home = serviceH.select(company.getCompany_code());	//홈페이지코드
			model.addAttribute("kkomap", home);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("FAIL");
		}
		
		//홈페이지소개content----------------------------------
		try {
			homecont = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}
		
		model.addAttribute("center", dir+"waymap");
		return "main";
	}
	
	
}
