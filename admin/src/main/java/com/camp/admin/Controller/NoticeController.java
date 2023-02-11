package com.camp.admin.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.NoticeDTO;
import com.camp.admin.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	String dir = "notice/";

	@Autowired
	NoticeService ns;

	@RequestMapping("")
	public String main(Model model, HttpSession session) {
		List<NoticeDTO> list = null;

		CompanyDTO company = (CompanyDTO) session.getAttribute("company");

		try {
			list = ns.selectByCompanycode(company.getCompany_code());
			model.addAttribute("plist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "notice");
		return "main";
	}

	@RequestMapping("/nowrite")
	public String nowrite(Model model, HttpSession session) {
		model.addAttribute("center", dir + "nowrite");
		return "main";
	}

	@RequestMapping("/noticeview")
	public String noticeview(Model model, int notice_code) {
		NoticeDTO noticeview = null;
		try {
			noticeview = ns.select(notice_code);
			model.addAttribute("notice", noticeview);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "noticeview");
		return "main";
	}

	@RequestMapping("/noedit")
	public String noedit(Model model, int notice_code) {
		NoticeDTO notice = null;

		try {
			notice = ns.select(notice_code);
			model.addAttribute("notice", notice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "noedit");
		return "main";
	}

	@RequestMapping("/noticedo")
	public String noticedo(NoticeDTO noticeDto, HttpSession session) {

		try {
			ns.insert(noticeDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/notice";
	}

	@RequestMapping("/noticeupdate")
	public String noticeupdate(Model model, NoticeDTO notdto) {
		try {
			ns.update(notdto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/notice";
	}

	@RequestMapping("/nodel")
	public String nodel(Integer notice_code) {
		try {
			ns.delete(notice_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/notice";
	}

}
