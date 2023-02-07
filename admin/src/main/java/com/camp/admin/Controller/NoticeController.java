package com.camp.admin.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.admin.DTO.NoticeDTO;
import com.camp.admin.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	String dir = "notice/";

	@Autowired
	NoticeService ns;

//공지사항글목록	
	@RequestMapping("")
	public String main(Model model) {
		List<NoticeDTO> list = null;
		try {
			list = ns.selectAll();
			model.addAttribute("plist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir + "notice");
		return "main";
	}

//공지사항글작성페이지
	@RequestMapping("/nowrite")
	public String nowrite(Model model, HttpSession session) {
		model.addAttribute("center", dir + "nowrite");
		return "main";
	}
	

//공지사항글내용페이지
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

//공지사항글수정페이지
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

//공지사항작성기능
	@RequestMapping("/noticedo")
	public String noticedo(NoticeDTO noticeDto, HttpSession session) {
		
		try {
			ns.insert(noticeDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/notice";
	}

//공지사항수정기능

	 @RequestMapping("/noticeupdate") public String noticeupdate(Model model, NoticeDTO notdto) {
		 try {
			 ns.update(notdto);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } 
		 return "redirect:/notice";
	}

	
//공지사항삭제기능
	 @RequestMapping("/nodel") public String nodel(Integer notice_code){
		 try {
			ns.delete(notice_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "redirect:/notice"; 
	 }
	
}
