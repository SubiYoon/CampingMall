package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.camping.DTO.ZoneDTO;

@Controller
@RequestMapping("/zone")
public class ZoneController {
	
	String dir = "zone/";
	
	@RequestMapping("")
	public String main(Model model, ZoneDTO zoneDTO) {
		
		ZoneDTO zonecont = null;	//구역소개
		
		model.addAttribute("center", dir+"zone");
		return "main";
	}
	
}
