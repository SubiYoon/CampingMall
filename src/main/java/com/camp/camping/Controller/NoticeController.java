package com.camp.camping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.camping.DTO.NoticeDTO;
import com.camp.camping.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	String dir = "notice/";
	
	@Autowired
	NoticeService ns;
	
	@RequestMapping("")
	public String main(Model model) {
		List<NoticeDTO> list = null;
		try {
			list = ns.selectAll();
			model.addAttribute("plist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir+"notice");
		return "main";
	}
	
}
