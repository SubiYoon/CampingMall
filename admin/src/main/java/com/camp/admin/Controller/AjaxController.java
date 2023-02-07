package com.camp.admin.Controller;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camp.admin.service.BookService;
import com.camp.admin.service.PaymentService;

@RestController
public class AjaxController {
	
	@Autowired
	PaymentService service;
	
	@Autowired
	BookService bookService;
	
	@RequestMapping("/refundBook")
	public List<Map<String, Object>> bookEdit(){
		List<Map<String, Object>> books=null;
        
		try {
			books = bookService.selectAllState(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return books;
	}
	
	@PostMapping("refund")
	public int refundOk(@RequestBody JSONObject jsonobject) {
		int result=0;
		
		int state=Integer.parseInt(jsonobject.get("state")+"");
		String merchant_uid=(String)jsonobject.get("merchant_uid");
		
		if(state==3) {
			String importToken=service.getImportToken();
			result=service.cancelPayment(importToken,merchant_uid);
			if(result==1) {
				result=bookService.updateBookState(merchant_uid,3);
			}
		}else if(state==4){
			result=bookService.updateBookState(merchant_uid,4);
		}
		return result;
	}
	
    
}
