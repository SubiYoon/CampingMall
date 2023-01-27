package com.camp.camping.DTO;

import java.util.Date;

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
public class BookDTO {
    private int book_code;
    private int site_code;
    private int user_code;
    private String merchant_uid;
    private int book_member;
    private String book_checkin;
    private String book_checkout;
    private Date book_writedate;
    private int book_price;
    private String book_car_number;
    private int book_state;

    public BookDTO(int site_code, int user_code, String merchant_uid, int book_member, String book_checkin, String book_checkout, int book_price, String book_car_number) {
        this.site_code=site_code;
        this.user_code =user_code;
        this.merchant_uid = merchant_uid;
        this.book_member=book_member;
        this.book_checkin=book_checkin;
        this.book_checkout=book_checkout;
        this.book_price=book_price;
        this.book_car_number=book_car_number;
    }
}
