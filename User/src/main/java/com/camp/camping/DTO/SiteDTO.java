package com.camp.camping.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    private int image_code;
    private String image_file;

    public SiteDTO(int site_code, int zone_code, String site_name, int site_price, String site_content) {
        this.site_code = site_code;
        this.zone_code = zone_code;
        this.site_name = site_name;
        this.site_price = site_price;
        this.site_content = site_content;
    }
}
