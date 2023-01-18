package com.camp.camping.home;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.DTO.UserDTO;
import com.camp.camping.service.HomeService;

@SpringBootTest
class HomeLnglatTest {
	
	@Autowired
	HomeService service;
	
	@Test
	void contextLoads() {
		
		
		HomeDTO home = null;
		
		try {
			home = service.lnglat(2);
			System.out.println("ok");
			System.out.println(home);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		
	}

}
