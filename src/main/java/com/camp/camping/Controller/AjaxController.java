package com.camp.camping.Controller;

import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
    
    @RequestMapping("selectDate")
    public Object selectDate(String selectDate1, String selectDate2){
        String change = null;
        JSONObject json = new JSONObject();

        Date date1 = new Date(Integer.parseInt(selectDate1.split("-")[0]),Integer.parseInt(selectDate1.split("-")[1]),Integer.parseInt(selectDate1.split("-")[2]));
        Date date2 = new Date(Integer.parseInt(selectDate2.split("-")[0]),Integer.parseInt(selectDate2.split("-")[1]),Integer.parseInt(selectDate2.split("-")[2]));

        if(date1.after(date2)){
            change = selectDate1;
            selectDate1 = selectDate2;
            selectDate2 = change;
        }

        json.put("book_checkin", selectDate1);
        json.put("book_checkout", selectDate2);
        
        return json;
    }
}
