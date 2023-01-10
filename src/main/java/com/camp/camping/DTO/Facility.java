package com.camp.camping.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Facility {
    private int facility_code;
    private String facility_name;
    private String facility_content;
    private String facility_img1;
    private String facility_img2;
    private String facility_img3;
}