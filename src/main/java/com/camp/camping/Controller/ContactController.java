package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	String dir = "contact/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"contact");
		return "main";
	}
	
}
