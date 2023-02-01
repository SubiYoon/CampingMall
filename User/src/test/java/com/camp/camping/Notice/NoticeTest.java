package com.camp.camping.Notice;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.camping.DTO.NoticeDTO;
import com.camp.camping.service.NoticeService;

@SpringBootTest
class NoticeTest {
	
	@Autowired
	NoticeService service;
	
	@Test
	void contextLoads() {
		
		List<NoticeDTO> test = null;
		
		try {
			test = service.noticeLv(1);
			for(int i=0; i<test.size(); i++) {
			}
	
			System.out.println("ok");
			System.out.println(test.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}
		
	}

}
