package com.camp.camping.Controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camp.camping.service.PaymentService;

@RestController
@RequestMapping("/pay")
public class PayrestController {
    
	@Autowired
	PaymentService service;
	
    @RequestMapping("/importready")
    public boolean importready(@RequestParam("stringDate1")String stringDate1,
    						   @RequestParam("stringDate2")String stringDate2,
    						   @RequestParam("site_code")int site_code){
    	
        return service.importready(stringDate1,stringDate2,site_code);
    }
     
    
    @PostMapping("/paywebhook")
    public void importready(@RequestBody JSONObject jsonobject){
    	
    	//서버단에 결제내용 insert
//    	imp_uid: 결제번호
//    	merchant_uid: 주문번호
//    	status: 결제 결과
    	System.out.println("jsonObject"+jsonobject);
    	
    }
    
    @PostMapping("/verifyImport")
    public void verifyImport(@RequestParam("merchant_uid")String merchant_uid) {
    	//결제검증
    	String get_token=service.getImportToken();
    	String payment_amount=service.getAmount(get_token, merchant_uid);
    	String amountToBePaid=service.setHackCheck(payment_amount, merchant_uid, get_token);
    	if(payment_amount.equals(amountToBePaid)) {
    		//db에 결제정보저장
    		
    	}
    	
    	
    }
  
    
    
    
    
    
    
}
