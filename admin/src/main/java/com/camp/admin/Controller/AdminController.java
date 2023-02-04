package com.camp.admin.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	String dir = "admin/";
	
	@RequestMapping("")
	public String main(Model model) {
		
		model.addAttribute("center", dir+"bookEdit");
		return "main";
	}
	
	
	
	
}
