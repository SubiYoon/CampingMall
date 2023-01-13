package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	String dir = "notice/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"notice");
		return "main";
	}
	
}
