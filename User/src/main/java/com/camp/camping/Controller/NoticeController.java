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
@RequestMapping("/notice")
public class NoticeController {

	String dir = "notice/";

	@Autowired
	NoticeService ns;
	
	@Autowired
	HomeService serviceH;

	//공지사항글목록	
	@RequestMapping("")
	public String main(Model model, HttpSession session) {
		
		List<NoticeDTO> list = null;
		HomeDTO homecont = null;	//home테이블전체정보
		
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		
		try {
			list = ns.selectByCompanycode(company.getCompany_code());
			model.addAttribute("plist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//홈페이지소개content----------------------------------
		try {
			homecont = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}
		
		
		model.addAttribute("center", dir + "notice");
		
		return "main";
	}

//공지사항글내용페이지
	@RequestMapping("/noticeview")
	public String noticeview(Model model, int notice_code, HttpSession session) {
		NoticeDTO noticeview = null;
		HomeDTO homecont = null;	//home테이블전체정보
		
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		
		try {
			noticeview = ns.select(notice_code);
			model.addAttribute("notice", noticeview);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//홈페이지소개content----------------------------------
		try {
			homecont = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}
		
		model.addAttribute("center", dir + "noticeview");
		return "main";
	}

	
}
