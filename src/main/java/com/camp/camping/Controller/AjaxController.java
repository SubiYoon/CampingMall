package com.camp.camping.Controller;

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camp.camping.DTO.SiteDTO;
import com.camp.camping.DTO.ZoneDTO;
import com.camp.camping.service.SiteService;
import com.camp.camping.service.ZoneService;

@RestController
public class AjaxController {
    
    @Autowired
    SiteService sService;
    @Autowired
    ZoneService zService;

    @RequestMapping("selectDate")
    public Object selectDate(String selectDate1, String selectDate2, String company_code){
        String change = null;
        List<SiteDTO> sites = null;
        List<ZoneDTO> zones =null;
        JSONObject json = new JSONObject();

        Date date1 = new Date(Integer.parseInt(selectDate1.split("-")[0]),Integer.parseInt(selectDate1.split("-")[1]),Integer.parseInt(selectDate1.split("-")[2]));
        Date date2 = new Date(Integer.parseInt(selectDate2.split("-")[0]),Integer.parseInt(selectDate2.split("-")[1]),Integer.parseInt(selectDate2.split("-")[2]));

        if(date1.after(date2)){
            change = selectDate1;
            selectDate1 = selectDate2;
            selectDate2 = change;
        }

        try {
            sites = sService.AvailableSite(Integer.parseInt(company_code), selectDate1, selectDate2);
            zones = zService.selectAll();
            json.put("availableSite", sites);
            json.put("zoneList", zones);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("실패");
        }

        json.put("book_checkin", selectDate1);
        json.put("book_checkout", selectDate2);
        
        return json;
    }
}
