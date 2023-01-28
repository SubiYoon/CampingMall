package com.camp.camping.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.camping.DTO.CompanyDTO;
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
	public String select(){
		
		return "redirect:/main";
	}

	@RequestMapping("/main")
	public String main(Model model, HttpSession session, CompanyDTO companyDTO) {
		
		HomeDTO homekko = null;		//카카오맵
		HomeDTO homecont = null;	//홈페이지소개
		List<NoticeDTO> nolist = null;	//주요공지
		
		
		//상호 세션 생성-----------------------------
		//TODO:차후 캠핑장 선택 페이지 생성시 수정 필요
		companyDTO = new CompanyDTO(1, "NoobCamping");
		
		session.setAttribute("company", companyDTO);

		//카카오맵경도위도-------------------------------------
		try {
			homekko = service.lnglat(companyDTO.getCompany_code());	//상호코드
			model.addAttribute("kkomap", homekko);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MAP_FAIL");
		}
		
		//홈페이지소개content----------------------------------
		try {
			homecont = service.homeCont(companyDTO.getCompany_code());	//상호코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}
		
		//주요공지----------------------------------
		
		try {
			nolist = serviceN.noticeLv(companyDTO.getCompany_code());	//상호코드
			model.addAttribute("noticeLv", nolist);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("NoticeLv_FAIL");
		}
		


		return "main";
	}
	
}
