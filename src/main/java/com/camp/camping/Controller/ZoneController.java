package com.camp.camping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.camping.DTO.ZoneDTO;
import com.camp.camping.service.ZoneService;

@Controller
@RequestMapping("/zone")
public class ZoneController {
	
	String dir = "zone/";
	
	@Autowired
	ZoneService zs;
	
	
	@RequestMapping("")
	public String main(Model model, ZoneDTO zoneDTO) {
		
		List<ZoneDTO> list = null;
		
		try {
			list=zs.selectZone(1);	//상호코드
			model.addAttribute("zlist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		model.addAttribute("center", dir+"zone");
		return "main";
	}
	
	
	@RequestMapping("/site")
	public String site(Model model) {
		
		model.addAttribute("center", dir+"site");
		return "main";
	}
	
}
