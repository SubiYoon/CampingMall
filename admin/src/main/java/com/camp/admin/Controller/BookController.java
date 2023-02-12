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

		HomeDTO homecont = null;
		CompanyDTO company = (CompanyDTO) session.getAttribute("company");

		try {
			homecont = serviceH.select(company.getCompany_code());
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}

		model.addAttribute("center", dir + "book");
		return "main";
	}

}
