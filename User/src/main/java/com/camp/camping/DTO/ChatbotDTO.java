package com.camp.camping.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ChatbotDTO {
	private String sendid;		//내id
	private String receiveid;	//받는id(모두/나에게일경우 null)
	private String content1;	//보내는 메세지
	private String content2;
}