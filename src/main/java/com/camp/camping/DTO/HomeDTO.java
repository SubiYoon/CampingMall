package com.camp.camping.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HomeDTO {
    private int home_code;
    private int company_code;
    private String home_content;
    private String home_img1;
    private String home_img2;
    private String home_img3;
    private String home_address;
    private String home_coordinate;
    private String home_https;
    private String company_phone_number;
}
