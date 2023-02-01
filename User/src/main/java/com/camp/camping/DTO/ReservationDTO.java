package com.camp.camping.DTO;

import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public ReservationDTO(int book_code, String reservation_date){
        this.book_code = book_code;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.reservation_date = new Date(sdf.parse(reservation_date).getTime());
        } catch (ParseException e) {
            System.out.println("날짜 버그터짐");
        }
    }
}
