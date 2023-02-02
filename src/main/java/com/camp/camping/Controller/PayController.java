package com.camp.camping.Controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paya")
public class PayController {
    
    @RequestMapping("/import")
    public String import_api(Model model){
        return "/import";
    }
    
    
}