package com.camp.camping.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.camping.DTO.UserDTO;
import com.camp.camping.service.UserService;

@SpringBootTest
class UserInsertTest {

	@Autowired
	UserService service;

	@Test
	void contextLoads() {

		UserDTO user = new UserDTO(0, "우하하123", "pwd001", "우하하", "123456", "010-1234-4567", "010", "1234", "5678");

		try {
			service.insert(user);
			System.out.println("성공123");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		}
	}

}
