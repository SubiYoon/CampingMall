package com.camp.camping.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ImageDTO {
    private int image_code;
    private int company_code;
    private int zone_code;
    private int site_code;
    private int home_code;
    private int facility_code;
    private String image_file;
}
