package com.camp.camping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService{
    @Autowired
    SiteService siteService;
    
    public boolean importready(String stringDate1, String stringDate2, int site_code) {
    	try {
			return siteService.IsOkToReservation(site_code, stringDate1, stringDate2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; 
    }

    
    
    
    
    
    
    
}
