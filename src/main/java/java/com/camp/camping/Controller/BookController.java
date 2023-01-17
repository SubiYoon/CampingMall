package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
	
	String dir = "book/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"book");
		return "main";
	}
	
}
