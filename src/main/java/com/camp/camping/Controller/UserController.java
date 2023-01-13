package com.camp.camping.Controller;

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
    public String register(Model model){
        model.addAttribute("center", dir+"register");
        return "main";
    }

    @RequestMapping("registerOk")
	public String registerOk(Model model, UserDTO userDTO){
		
		String user_phone_number = userDTO.getUser_tel1() + "-" + userDTO.getUser_tel2() + "-" +userDTO.getUser_tel3();

		userDTO.setUser_phone_number(user_phone_number);

		try {
			//service.insert(userDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(userDTO.toString());

		return "main";
	}
}
