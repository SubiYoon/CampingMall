package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facility")
public class FacilityController {
	
	String dir = "facility/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"facility");
		return "main";
	}
	
}
