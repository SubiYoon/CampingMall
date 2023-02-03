package com.camp.admin.DTO;

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
}
