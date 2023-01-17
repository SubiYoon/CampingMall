package com.camp.camping.Controller;

import com.camp.camping.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
	
	String dir = "book/";
	@Autowired
	BookService service;
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"book");
		return "main";
	}
	
}
