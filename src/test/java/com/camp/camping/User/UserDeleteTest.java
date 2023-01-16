package com.camp.camping.User;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.camping.service.UserService;

@SpringBootTest
class UserDeleteTest {

	@Inject
	UserService service;

	@Test
	void contextLoads() {

		try {
			service.delete(8);
			System.out.println("성공123");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}
	}

}
