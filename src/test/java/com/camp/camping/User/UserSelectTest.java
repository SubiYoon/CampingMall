package com.camp.camping.User;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.camping.DTO.UserDTO;
import com.camp.camping.service.UserService;

@SpringBootTest
class UserSelectTest {

	@Inject
	UserService service;

	@Test
	void contextLoads() {

		UserDTO user =null;

		try {
			user = service.select("user01");
			System.out.println("성공123");
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		}
	}

}
