package com.camp.camping.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CompanyDTO {
    private int company_code;
    private int admin_code;
    private String company_name;
}
