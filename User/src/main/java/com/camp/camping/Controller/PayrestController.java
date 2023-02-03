package com.camp.camping.Controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.DTO.PaymentDTO;
import com.camp.camping.DTO.UserDTO;
import com.camp.camping.service.BookService;
import com.camp.camping.service.PaymentService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/pay")
public class PayrestController {
    
	@Autowired
	PaymentService service;
	
	@Autowired
	BookService bookService;
	
    @RequestMapping("/importready")
    public boolean importready(@RequestParam("stringDate1")String stringDate1,
    						   @RequestParam("stringDate2")String stringDate2,
    						   @RequestParam("site_code")int site_code){
    	
        return service.importready(stringDate1,stringDate2,site_code);
    }
    
    //웹훅 : 데이터 동기화 및 브라우저 에러시 저장
    @PostMapping("/paywebhook")
    public void paywebhook(@RequestBody JSONObject jsonobject){
    	service.verifyImport_payment(jsonobject);
    }
    
    //DB
    @RequestMapping("/paybook")
    public BookDTO paybook(@RequestBody JSONObject jsonobject1){
    	
    	String buyer_name=(String) jsonobject1.get("buyer_name");
    	String buyer_tel=(String) jsonobject1.get("buyer_tel");
    	jsonobject1.remove("buyer_name");
    	jsonobject1.remove("buyer_tel");
    	Gson gson=new Gson();
    	BookDTO book=gson.fromJson(jsonobject1.toString(),BookDTO.class);
    	jsonobject1.remove("site_code");
    	jsonobject1.remove("book_member");
    	jsonobject1.remove("book_checkin");
    	jsonobject1.remove("book_checkout");
    	jsonobject1.remove("book_price");
    	jsonobject1.remove("book_car_number");
    	service.verifyImport_payment(jsonobject1);
    	
    	try {
			UserDTO user=service.user_select(buyer_name, buyer_tel);
			int user_code=user.getUser_code();
			book.setUser_code(user_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	service.paybook(book);
    	
    	return book;
    }
    
    //결제검증
    @RequestMapping("/verifyImport")
    public String verifyImport(@RequestParam("merchant_uid")String merchant_uid) {
    	String result="fail";
    	
    	String get_token=service.getImportToken();
    	String payment_amount=service.getAmount(get_token, merchant_uid);
    	service.setHackCheck(payment_amount, merchant_uid, get_token);
    	
    	BookDTO book=bookService.selectMerchant(merchant_uid);
    	if(book.getBook_price()==Integer.parseInt(payment_amount)) {
    		result="success";
    	}
    	return result;
    }
    
}
