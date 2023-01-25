package com.camp.camping.Reservation;

import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ReservationSelectDateTest {
    @Inject
    ReservationService service;

    @Test
    void ReservationSelectDateTests(){
        List<ReservationDTO> reservation;
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d = new Date(sdf.parse("2023-02-03").getTime());
        } catch (ParseException e) {
            System.out.println("날짜 버그터짐");
        }
        try{
            reservation = service.selectDate(d);
            System.out.println("성공");
            System.out.println(reservation.toString());
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("버그터짐");
        }
    }
}
