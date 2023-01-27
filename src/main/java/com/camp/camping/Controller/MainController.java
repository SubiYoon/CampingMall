package com.camp.camping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.DTO.NoticeDTO;
import com.camp.camping.service.HomeService;
import com.camp.camping.service.NoticeService;

@Controller
public class MainController {
	
	@Autowired
	HomeService service;
	
	@Autowired
	NoticeService serviceN;
	
	@RequestMapping("/")
	public String main(Model model) {
		
		HomeDTO homekko = null;		//카카오맵
		HomeDTO homecont = null;	//홈페이지소개
		List<NoticeDTO> nolist = null;	//주요공지
		
		
		//카카오맵경도위도-------------------------------------
		try {
			homekko = service.lnglat(2);	//홈페이지코드
			model.addAttribute("kkomap", homekko);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MAP_FAIL");
		}
		
		//홈페이지소개content----------------------------------
		try {
			homecont = service.homeCont(2);	//홈페이지코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}
		
		//주요공지----------------------------------
		
		try {
			nolist = serviceN.noticeLv();
			model.addAttribute("noticeLv", nolist);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("NoticeLv_FAIL");
		}
		
		return "main";
	}
	
}
