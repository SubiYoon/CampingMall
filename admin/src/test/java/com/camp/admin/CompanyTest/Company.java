package com.camp.admin.CompanyTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.service.CompanyService;

@SpringBootTest
class Company {

	@Autowired
	CompanyService service;

	@Test
	void contextLoads() {
		CompanyDTO company = new CompanyDTO(1, "NoopCamping", "5.jpeg", "5.jpeg");
		try{
			service.update(company);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
