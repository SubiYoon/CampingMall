package com.camp.camping.Controller;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.service.BookService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {
	
	String dir = "book/";
	@Autowired
	BookService service;
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("center", dir+"book");
		return "main";
	}
	
	
	@RequestMapping("/bookdetail")
	public String book_detail(Model model,
						      @RequestParam("book_checkin")String book_checkin,
						      @RequestParam("book_checkout")String book_checkout,
						      @RequestParam("book_sitecode")String book_sitecode) {
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
