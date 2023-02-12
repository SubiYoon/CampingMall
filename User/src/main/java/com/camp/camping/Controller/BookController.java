package com.camp.camping.Controller;

import com.camp.camping.utility.Utility;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.camp.camping.DTO.ImageDTO;
import com.camp.camping.service.BookService;
import com.camp.camping.service.HomeService;
import com.camp.camping.service.ImageService;
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
	@Autowired
	ImageService serviceI;

	@RequestMapping("")
	public String main(Model model, HttpSession session) {

		HomeDTO homecont = null;
		CompanyDTO company = (CompanyDTO) session.getAttribute("company");

		try {
			homecont = serviceH.select(company.getCompany_code());
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}

		try {
			JSONObject weatherjson = serviceW.getWeather(homecont.getHome_code());
			model.addAttribute("weatherjson", weatherjson);
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<Date> wdate = new ArrayList<>();
		for (int i = 3; i < 10; i++) {
			Date date;
			try {
				Date check_date=new Date(System.currentTimeMillis());
				if(!serviceW.checktime()) {
					check_date = new Date(System.currentTimeMillis()-(1000 * 24 * 60 * 60));
				}
				check_date.setDate(check_date.getDate() + i);
				wdate.add(check_date);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		model.addAttribute("wdate", wdate);
		model.addAttribute("center", dir + "book");
		return "main";
	}

	@RequestMapping("/bookdetail")
	public String book_detail(Model model, HttpSession session,
			@RequestParam("book_checkin") String book_checkin,
			@RequestParam("book_checkout") String book_checkout,
			@RequestParam("book_sitecode") int book_sitecode) {

		HomeDTO homecont = null;
		CompanyDTO company = (CompanyDTO) session.getAttribute("company");

		try {
			homecont = serviceH.select(company.getCompany_code());
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}

		BookDTO book = service.selectViewForm(book_checkin, book_checkout, book_sitecode);

		List<ImageDTO> img = serviceI.selectBySiteCode(book.getSite_code());

		book.setBook_site_image(img.get(0).getImage_file());

		try {
			book.setBook_price(book.getBook_price()	* Utility.StringDateDifference(book.getBook_checkout(), book.getBook_checkin()));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		model.addAttribute("book", book);

		model.addAttribute("center", dir + "bookdetail");

		return "main";
	}

}
