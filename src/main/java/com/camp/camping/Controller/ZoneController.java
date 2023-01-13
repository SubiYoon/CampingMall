package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/zone")
public class ZoneController {
	
	String dir = "zone/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"zone");
		return "main";
	}
	
}
