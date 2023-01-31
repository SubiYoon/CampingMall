package com.camp.camping.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FacilityDTO {
    private int facility_code;
    private int admin_code;
    private String facility_name;
    private String facility_content;

    private int image_code;
    private String image_file;

    public FacilityDTO(int facility_code, int admin_code, String facility_name, String facility_content){
        this.facility_code = facility_code;
        this.admin_code = admin_code;
        this.facility_name = facility_name;
        this.facility_content = facility_content;
    }
}
