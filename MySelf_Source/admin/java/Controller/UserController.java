package com.camp.admin.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camp.admin.DTO.BookDTO;
import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.DTO.UserDTO;
import com.camp.admin.service.BookService;
import com.camp.admin.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	String dir = "user/";

	@Autowired
	UserService service;
	@Autowired
	BookService bookService;

	@RequestMapping("/userEdit")
	public String useredit(HttpSession session, Model model) {
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");
		List<UserDTO> userList = null;
		List<BookDTO> bookList = null;
		List<UserDTO> userAllList = new ArrayList<UserDTO>();
		UserDTO user = new UserDTO();
		try{
			userList = service.selectUsersInfo(company.getCompany_code());
			for(int i=0; i<userList.size(); i++){
				bookList = bookService.selectUserBook(company.getCompany_code(), userList.get(i).getUser_id());
				
				if(bookList.get(0).getBook_checkin()==null || bookList.get(0).getBook_checkin()==""){
					user = userList.get(i);
					user.setBookCount(bookList.size());
					user.setBook_checkin("");
					user.setBook_checkout("");
					if(user.getUser_id().substring(0, 8).equals("(DELETE)")){
						user.setUser_tel1("탈퇴");
					}else {
						user.setUser_tel1("이용중");
					}
				}else {
					user = userList.get(i);
					user.setBookCount(bookList.size());
					user.setBook_checkin(bookList.get(0).getBook_checkin());
					user.setBook_checkout(bookList.get(0).getBook_checkout());
					if(user.getUser_id().substring(0, 8).equals("(DELETE)")){
						user.setUser_tel1("탈퇴");
					}else {
						user.setUser_tel1("이용중");
					}
				}
				
				userAllList.add(user);

			}
			model.addAttribute("userList", userAllList);
			
		} catch(Exception e){
			e.printStackTrace();

		}

		model.addAttribute("center", "/userEdit");
		return "main";
	}

	@RequestMapping("userDetail")
	public String userDetail(HttpSession session, Model model, String user_id){
		CompanyDTO company = (CompanyDTO)session.getAttribute("company");

		List<BookDTO> userBooks = null;
		UserDTO user = null;
		try{
			userBooks = bookService.selectUserBook(company.getCompany_code(), user_id);
			user = service.select(user_id);
			System.out.println(user);
			model.addAttribute("user", user);
			model.addAttribute("userBookDetail", userBooks);
		} catch(Exception e){
			e.printStackTrace();
		}

		model.addAttribute("center", "userBookDetail");
		return "main";
	}
}
