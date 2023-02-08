package com.camp.camping.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
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
import com.camp.camping.service.WeatherService;

@Controller
@RequestMapping("/book")
public class BookController {
	
	String dir = "book/";
	@Autowired
	BookService service;
	@Autowired
	HomeService serviceH;
	@Autowired
	WeatherService serviceW;
	
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
		
		try {
			JSONObject weatherjson=serviceW.getWeather();
			model.addAttribute("weatherjson", weatherjson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Date> wdate=new ArrayList<>();
		for(int i=3;i<10;i++) {
			Date date=new Date();
			date.setDate(date.getDate()+i);
			wdate.add(date);
		}
		
		
		model.addAttribute("wdate", wdate);
		
		
		
		
		
		
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
		
		BookDTO book=service.selectViewForm(book_checkin,book_checkout,book_sitecode);
		
		model.addAttribute("book", book);

		model.addAttribute("center", dir+"bookdetail");
		
		return "main";
	}
	
}
