package com.camp.camping.Controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.camp.camping.DTO.CompanyDTO;
import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.DTO.UserDTO;
import com.camp.camping.service.BookService;
import com.camp.camping.service.HomeService;
import com.camp.camping.service.UserService;
import com.camp.camping.utility.CryptoUtil;

@Controller
@RequestMapping("/user")
public class UserController {

	String dir = "user/";

	@Autowired
	UserService service;
	@Autowired
	BookService bookService;
	@Autowired
	HomeService serviceH;

	//지울거
	@RequestMapping("test")
	public String test(Model model){
		model.addAttribute("center", "test");
		return "test";
	}

	@RequestMapping("register")
	public String register(Model model, HttpSession session) {
		
		HomeDTO homecont = null;	//home테이블전체정보
		
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		
		//홈페이지소개content----------------------------------
		try {
			homecont = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}
		
		model.addAttribute("center", dir + "register");
		return "main";
	}

	@RequestMapping("registerOk")
	public String registerOk(Model model, UserDTO userDTO) {

		String user_tel = userDTO.getUser_tel1() + "-" + userDTO.getUser_tel2() + "-" + userDTO.getUser_tel3();
		String crypString = "";
		userDTO.setUser_tel(user_tel);

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
			userDTO.setUser_password(crypString);
			service.insert(userDTO);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}

		return "redirect:/main";
	}
	
	@RequestMapping("mypage")
	public String mypage(HttpSession session, Model model){
		HomeDTO homecont = null;	//홈페이지소개
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		System.out.println(company);
		//홈페이지소개content----------------------------------
		try {
				
			homecont = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}

		model.addAttribute("center", dir + "mypage");
			
		return "main";
	}

	//TODO: mypage안에 회원정보 수정 버튼 추가하여 이동하게 만들어야함.
	@RequestMapping("userInfo")
	public String userInfo(Model model, UserDTO userDTO, HttpSession session) {

		UserDTO login = (UserDTO)session.getAttribute("user");

		UserDTO user = null;

		HomeDTO homecont = null;	//홈페이지소개
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		System.out.println(company);
		//홈페이지소개content----------------------------------
		try {
				
			homecont = serviceH.select(company.getCompany_code());	//상호코드
			model.addAttribute("homecont", homecont);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CONTENT_FAIL");
		}

		try {
			user = service.select(login.getUser_id());
			
			if(user.getUser_tel()==null || user.getUser_tel().equals("")){
				
			}else {
				String[] telNum = user.getUser_tel().split("-");
				user.setUser_tel1(telNum[0]);
				user.setUser_tel2(telNum[1]);
				user.setUser_tel3(telNum[2]);
			}

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
		String crypString = "";
		String user_tel = userDTO.getUser_tel1() + "-" + userDTO.getUser_tel2() + "-" + userDTO.getUser_tel3();

		userDTO.setUser_tel(user_tel);

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
			userDTO.setUser_password(crypString);
			service.update(userDTO);
			model.addAttribute("center", dir + "mypage");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		}

		//TODO: 페이지 이동 수정필요
		return "redirect:/main";
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

		return "redirect:/main";
	}

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
		return "redirect:/main";
	}

	@RequestMapping("checkid")
	@ResponseBody
	public int checkid(String user_id){
		int result = 0;
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

	@RequestMapping("kakaoLogin")
	@ResponseBody
	public String kakaoLogin(Model model, UserDTO userDTO, HttpSession session){
		UserDTO user = null;
		String crypString = "";

		try {
			crypString = CryptoUtil.sha512("KakaoLogin");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		try {
			user = service.select(userDTO.getUser_id());
			if(user==null){
				userDTO.setUser_password(crypString);
				service.kakaoLoginInsert(userDTO);
				user = service.select(userDTO.getUser_id());
			}
			
			session.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "가능";
	}
}
