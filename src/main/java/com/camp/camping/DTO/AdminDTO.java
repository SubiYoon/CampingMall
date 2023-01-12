package com.camp.camping.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AdminDTO {
    private int admin_code;
    private String admin_id;
    private String admin_password;
    private String admin_name;
}
