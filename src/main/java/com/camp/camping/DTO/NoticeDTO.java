package com.camp.camping.DTO;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NoticeDTO {
    private int notice_code;
    private int company_code;
    private int notice_level;
    private String notice_title;
    private String notice_writer;
    private Date notice_writedate;
    private String notice_content;

}
