package com.camp.camping.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HomeDTO {
    private int home_code;
    private int admin_code;
    private String home_owner;
    private String home_content;
    private String home_address;
    private double home_longitude;
    private double home_latitude;
    private String home_https;
    private String home_tell;

}

