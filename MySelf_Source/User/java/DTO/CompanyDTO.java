package com.camp.camping.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CompanyDTO {
    private int company_code;
    private String company_name;
    private String company_logo1;
    private String company_logo2;

    private String home_owner;
    private String home_tell;
    private String home_address;
}
