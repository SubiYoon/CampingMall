package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	String dir = "gallery/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"gallery");
		return "main";
	}
	
}
