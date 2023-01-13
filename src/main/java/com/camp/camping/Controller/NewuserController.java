package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newuser")
public class NewuserController {
	
	String dir = "newuser/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"newuser");
		return "main";
	}
	
}
