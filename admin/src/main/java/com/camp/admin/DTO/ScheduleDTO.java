package com.camp.admin.DTO;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ScheduleDTO {
    private int schedule_code;
    private int admin_code;
    private Date schedule_date;
    private String schedule_name;
}
