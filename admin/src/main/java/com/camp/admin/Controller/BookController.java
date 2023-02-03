package com.camp.admin.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.camp.admin.DTO.BookDTO;
import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.HomeDTO;
import com.camp.admin.service.BookService;
import com.camp.admin.service.HomeService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	String dir = "book/";
	@Autowired
	BookService service;
	@Autowired
	HomeService serviceH;
	
	@RequestMapping("")
	public String main(Model model, HttpSession session) {
		
		HomeDTO homecont = null;	//home테이블전체정보
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		
		//홈페이지소개content----------------------------------
		try {
			homecont = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}
		
		model.addAttribute("center", dir+"book");
		return "main";
	}
	
	
	@RequestMapping("/bookdetail")
	public String book_detail(Model model, HttpSession session,
						      @RequestParam("book_checkin")String book_checkin,
						      @RequestParam("book_checkout")String book_checkout,
						      @RequestParam("book_sitecode")int book_sitecode) {

		HomeDTO homecont = null;	//home테이블전체정보
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");

		//홈페이지소개content----------------------------------
		try {
			homecont = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}
		
		BookDTO book=service.selectViewForm(book_checkin, book_checkout, book_sitecode);
		
		model.addAttribute("book", book);

		model.addAttribute("center", dir+"bookdetail");
		
		return "main";
	}
	
}
