package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	String dir = "blog/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"blog");
		return "main";
	}
	
}
