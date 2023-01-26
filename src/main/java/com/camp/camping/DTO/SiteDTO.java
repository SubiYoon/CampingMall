package com.camp.camping.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SiteDTO {
    private int site_code;
    private int zone_code;
    private String site_name;
    private int site_price;
    private String site_content;
}
