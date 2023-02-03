package com.camp.admin.Controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.camp.admin.DTO.UserDTO;
import com.camp.admin.service.BookService;
import com.camp.admin.service.UserService;
import com.camp.admin.utility.CryptoUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	String dir = "user/";

	@Autowired
	UserService service;
	@Autowired
	BookService bookService;

	//TODO: 관리자 로그인 수정필요
	@RequestMapping("loginOk")
	public String loginOk(Model model, UserDTO userDTO, HttpSession session){
		UserDTO user = null;
		String crypString = "";
		String result_page = "user/loginFail";
		
		try {
			crypString = CryptoUtil.sha512(userDTO.getUser_password());
		} catch (NoSuchAlgorithmException e) {
			//e.printStackTrace();
			System.out.println("알고리즘 예외");
		} catch (UnsupportedEncodingException e) {
			//e.printStackTrace();
			System.out.println("인코딩예외");
		}

		try {
			user=service.select(userDTO.getUser_id());
			if(user.getUser_id().equals(userDTO.getUser_id()) && user.getUser_password().equals(crypString)){
				session.setAttribute("user", user);
				result_page="redirect:/main";
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}
		return result_page;
	}

	@RequestMapping("logout")
	public String logOut(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
