package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    
    String dir = "user/";

    @RequestMapping("")
    public String main(){

        return dir+"main";
    }
}
