package com.camp.camping.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.DTO.CompanyDTO;
import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.service.BookService;
import com.camp.camping.service.HomeService;

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
						      @RequestParam("book_sitecode")String book_sitecode) {

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
		
		model.addAttribute("center", dir+"bookdetail");
		
		
		BookDTO book=new BookDTO();
		
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		Calendar cal = Calendar.getInstance();
		Random random = new Random();
		book.setMerchant_uid(dateFormat.format(cal.getTime())+""+random.nextInt(100000));
		book.setSite_code(Integer.parseInt(book_sitecode));
		
		return "main";
	}
	
	
	
	
	
	
}
