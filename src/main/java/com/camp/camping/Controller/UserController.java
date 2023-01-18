package com.camp.camping.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

		String user_tell = userDTO.getUser_tel1() + "-" + userDTO.getUser_tel2() + "-" + userDTO.getUser_tel3();

		userDTO.setUser_tell(user_tell);

		try {
			service.insert(userDTO);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패다");
		}

		return "main";
	}
	@RequestMapping("mypage")
		public String mypage(Model model, HttpSession session){
			model.addAttribute("center", dir + "mypage");

			return "main";
		}

	//TODO: mypage안에 회원정보 수정 버튼 추가하여 이동하게 만들어야함.
	@RequestMapping("userInfo")
	public String userInfo(Model model, UserDTO userDTO, HttpSession session) {

		UserDTO login = (UserDTO)session.getAttribute("user");

		UserDTO user = null;

		try {
			user = service.select(login.getUser_id());
			
			String[] telNum = user.getUser_tell().split("-");
			user.setUser_tel1(telNum[0]);
			user.setUser_tel2(telNum[1]);
			user.setUser_tel3(telNum[2]);

			model.addAttribute("selectUser", user);
			model.addAttribute("center", dir + "userInfo");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		}

		return "main";
	}

	@RequestMapping("update")
	public String update(Model model, UserDTO userDTO) {

		String user_tell = userDTO.getUser_tel1() + "-" + userDTO.getUser_tel2() + "-" + userDTO.getUser_tel3();

		userDTO.setUser_tell(user_tell);

		try {
			service.update(userDTO);
			model.addAttribute("center", dir + "mypage");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}

		return "main";
	}

	@RequestMapping("delete")
	public String delete(String user_id, HttpSession session){

		try {
			service.delete(user_id);
			session.invalidate();
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}

		return "main";
	}

	@RequestMapping("loginOk")
	public String loginOk(Model model, UserDTO userDTO, HttpSession session){
		UserDTO user=null;
		String result_page="user/loginFail";
		try {
			user=service.select(userDTO.getUser_id());
			if(user.getUser_id().equals(userDTO.getUser_id())){
				session.setAttribute("user", user);
				result_page="main";
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
		return "main";
	}

	@RequestMapping("checkid")
	@ResponseBody
	public int checkid(String user_id){
		int result = 0;
		System.out.println(user_id);
		UserDTO user = null;

		try {
			user = service.select(user_id);
			if(user!=null){
				result = 1;
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return result;
	}
}
