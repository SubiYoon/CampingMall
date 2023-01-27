package com.camp.camping.Reservation;

import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.service.ReservationService;
import com.camp.camping.service.SiteService;
import org.junit.jupiter.api.Disabled;
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
    @Inject
    SiteService siteService;

    @Test
    @Disabled
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
    @Test
    void ReservationDateAndSiteTest(){
        ReservationDTO  reservation = service.selectDateAndSite(1,"2023-02-04");
        System.out.println(reservation.toString());
    }
    @Test
    void IsEmpty(){
        System.out.println(service.IsDateEmpty(1,"2023-02-04"));
        System.out.println(service.IsDateEmpty(1,"2023-02-09"));
        System.out.println(service.IsDateEmpty(1,"2023-03-01"));
        try {
            System.out.println(siteService.IsOkToReservation(15,"2023-02-05","2023-02-06"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
