package com.camp.camping.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.camping.DTO.UserDTO;
import com.camp.camping.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	String dir = "user/";

	@Autowired
	UserService service;

	@RequestMapping("register")
	public String register(Model model) {
		model.addAttribute("center", dir + "register");
		return "main";
	}

	@RequestMapping("registerOk")
	public String registerOk(Model model, UserDTO userDTO) {

		String user_phone_number = userDTO.getUser_tel1() + "-" + userDTO.getUser_tel2() + "-" + userDTO.getUser_tel3();

		userDTO.setUser_phone_number(user_phone_number);

		try {
			service.insert(userDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}

	@RequestMapping("mypage")
	public String myPage(Model model, UserDTO userDTO, HttpSession session) {

		UserDTO user = null;

		try {
			user = service.select(userDTO.getUser_code());
			
			String[] telNum = user.getUser_phone_number().split("-");
			user.setUser_tel1(telNum[0]);
			user.setUser_tel2(telNum[1]);
			user.setUser_tel3(telNum[2]);

			model.addAttribute("selectUser", user);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}
}
