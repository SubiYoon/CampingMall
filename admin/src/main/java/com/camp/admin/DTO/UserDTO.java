package com.camp.admin.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private int user_code;
    private String user_id;
    private String user_password;
    private String user_name;
    private String user_birthday;
    private String user_tel;

    private String user_tel1;
    private String user_tel2;
    private String user_tel3;
}
