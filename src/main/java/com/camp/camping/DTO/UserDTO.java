package com.camp.camping.DTO;

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
    private int grant;
    private String user_id;
    private String user_password;
    private String user_name;
    private int uswer_birthday;
    private String user_phone_number;
}
