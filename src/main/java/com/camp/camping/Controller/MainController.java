package com.camp.camping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.service.HomeService;

@Controller
public class MainController {
	
	@Autowired
	HomeService service;
	
	@RequestMapping("/")
	public String main(Model model) {
		
		HomeDTO homekko = null;
		HomeDTO homecont = null;
		
		try {
			homekko = service.lnglat(2);	//홈페이지코드
			model.addAttribute("kkomap", homekko);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MAP_FAIL");
		}
		
		try {
			homecont = service.homeCont(2);	//홈페이지코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}
		
		return "main";
	}
	
}
