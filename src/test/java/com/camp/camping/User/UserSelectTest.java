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
			user = service.select("user1");
			String[] telNum = user.getUser_tell().split("-");
			user.setUser_tel1(telNum[0]);
			user.setUser_tel2(telNum[1]);
			user.setUser_tel3(telNum[2]);
			System.out.println("성공123");
			System.out.println(user.toString());
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("실패");
		}
	}

}
