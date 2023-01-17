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
public class BookDTO {
    private int book_code;
    private int site_code;
    private int user_code;
    private String merchant_uid;
    private int book_member;
    private Date book_checkin;
    private Date book_checkout;
    private Date book_writedate;
    private int book_price;
    private String book_car_number;

    public BookDTO(int site_code, int user_code, String merchant_uid, int book_member, String book_checkin, String book_checkout, int book_price, String book_car_number) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.site_code = site_code;
        this.user_code = user_code;
        this.merchant_uid = merchant_uid;
        this.book_member = book_member;
        try {
            this.book_checkin = new Date(sdf.parse(book_checkin).getTime());
            this.book_checkout = new Date(sdf.parse(book_checkout).getTime());
        } catch (ParseException e) {
            System.out.println("버그터짐");
        }
        this.book_price = book_price;
        this.book_car_number =book_car_number;
    }
}
