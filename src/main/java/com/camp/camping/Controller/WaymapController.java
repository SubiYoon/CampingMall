package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/waymap")
public class WaymapController {
	
	String dir = "waymap/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"waymap");
		return "main";
	}
	
}
