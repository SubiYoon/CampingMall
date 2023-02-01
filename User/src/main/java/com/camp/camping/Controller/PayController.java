package com.camp.camping.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.camp.camping.DTO.PaymentDTO;

@Controller
@RequestMapping("/pay")
public class PayController {
    
    @RequestMapping("/import")
    public String import_api(Model model){
        return "/import";
    }
    
    @PostMapping("/paymentOK")
    @ResponseBody
    public String paymentOK(Model model,@RequestBody PaymentDTO pay){
    	
    	System.out.println("imp_uid"+pay.getImp_uid());
    	System.out.println("merchant_uid"+pay.getMerchant_uid());
    	
        return "/import";
    }
    
  
    
    
    
    
    
    
}
