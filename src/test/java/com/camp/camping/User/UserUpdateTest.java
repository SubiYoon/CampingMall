package com.camp.camping.User;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.camping.DTO.UserDTO;
import com.camp.camping.service.UserService;

@SpringBootTest
class UserUpdateTest {

	@Inject
	UserService service;

	@Test
	void contextLoads() {

		UserDTO user = new UserDTO(5, "user011", "비밀번호변경", "우하하", "123456", "010-9999-3333", "010", "4444", "9999");

		try {
			service.update(user);
			System.out.println("성공123");
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}
	}

}
