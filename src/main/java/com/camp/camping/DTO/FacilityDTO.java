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
}
