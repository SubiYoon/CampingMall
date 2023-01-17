package com.camp.camping.DTO;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ReservationDTO {
    private int reservation_code;
    private int book_code;
    private Date reservation_date;
    private int reservation_detail;

}
