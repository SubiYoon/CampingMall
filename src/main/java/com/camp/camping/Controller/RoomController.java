package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	String dir = "room/";
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"room");
		return "main";
	}
	
}
