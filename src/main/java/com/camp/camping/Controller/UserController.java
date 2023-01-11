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

    @RequestMapping("")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return dir+"main";
    }

    @RequestMapping("register")
    public String register(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"userRegister");
        return dir+"main";
    }

    @RequestMapping("registerOk")
    public String registerOk(Model model, UserDTO userDTO){
        try {
            service.insert(userDTO);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("실패");
        }
        return dir+"main";
    }
}
