package com.camp.camping.home;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.camping.frame.ChatBotUtil;

@SpringBootTest
class ChatBotTests {

	@Test
	void contextLoads() {
		
		String q = "퇴근시켜줘";
		String re = null;
		
		try {
			re = ChatBotUtil.chat(q);
			System.out.println(re);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
