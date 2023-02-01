package com.camp.admin.DTO;

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
public class ZoneDTO {
    private int zone_code;
    private int admin_code;
    private String zone_name;
    private String zone_content;
}
