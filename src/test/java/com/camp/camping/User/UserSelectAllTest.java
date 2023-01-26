package com.camp.camping.User;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.camping.DTO.UserDTO;
import com.camp.camping.service.UserService;

@SpringBootTest
class UserSelectAllTest {

	@Inject
	UserService service;

	@Test
	void contextLoads() {

		List<UserDTO> user = null;

		try {
			user = service.selectAll();
			for(int i=0; i<user.size(); i++){
				String[] telNum = user.get(i).getUser_tel().split("-");
				user.get(i).setUser_tel1(telNum[0]);
				user.get(i).setUser_tel2(telNum[1]);
				user.get(i).setUser_tel3(telNum[2]);
			}
			System.out.println("성공123");
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("실패");
		}
	}

}
