package com.camp.admin.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AdminDTO {
    private int admin_code;
    private String company_code;
    private String admin_id;
    private String admin_password;
}
