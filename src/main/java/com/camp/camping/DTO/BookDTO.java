package com.camp.camping.DTO;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookDTO {
    private int book_code;
    private int site_code;
    private int user_code;
    private int payment_code;
    private int book_member;
    private Date book_date;
    private int book_price;
    private String book_car_number;
}
