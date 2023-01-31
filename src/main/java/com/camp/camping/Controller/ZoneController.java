package com.camp.camping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.camping.DTO.SiteDTO;
import com.camp.camping.DTO.ZoneDTO;
import com.camp.camping.service.SiteService;

@Controller
@RequestMapping("/zone")
public class ZoneController {
	
	@Autowired
	SiteService serviceS;

	String dir = "zone/";
	
	@RequestMapping("")
	public String main(Model model, ZoneDTO zoneDTO) {
		
		ZoneDTO zonecont = null;	//구역소개
		
		model.addAttribute("center", dir+"zone");
		return "main";
	}
	
	@RequestMapping("/site")
	public String site(Model model, int site_code) {
		
		try {
			SiteDTO site = serviceS.select(site_code);
			model.addAttribute("site", site);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("center", dir+"site");
		return "main";
	}
	
}
