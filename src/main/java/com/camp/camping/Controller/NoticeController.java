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
	
// 공지사항 메인 (목록)	
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
	
//	공지 글쓰기 화면
	@RequestMapping("/nowrite")
	public String nowrite(Model model) {
		model.addAttribute("center", dir+"nowrite");
		return "main";
	}
	
//	공지 쓴 글 등록
	@RequestMapping("/noticedo")
	public String noticedo(Model model, NoticeDTO noticeDto) {
		try {
			ns.insert(noticeDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:notice";
	}
	
//	글 조회 화면
	@RequestMapping("/noticeview")
	public String noticeview(Model model, int notice_code) {
		NoticeDTO noti = null;
		try {
			noti = ns.select(notice_code);
			model.addAttribute("noti", noti);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("center", dir+"noticeview");
		return "main";
	}
	
//	글 삭제
	@RequestMapping("/noticedelete")
	public String noticedelete(Model model, int notice_code) {
		try {
			ns.delete(notice_code);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:notice";
	}
	
//	글 수정
	@RequestMapping("/noticeupdate")
	public String noticeupdate(Model model, NoticeDTO notdto) {
		try {
				ns.update(notdto);
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "redirect:get?notice_code="+notdto.getNotice_code();
	}
}

