package com.camp.camping.Schedule;

import com.camp.camping.DTO.ScheduleDTO;
import com.camp.camping.service.ReservationService;
import com.camp.camping.service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class ScheduleSelectTest {
    @Inject
    ScheduleService service;
    @Inject
    ReservationService reservationService;
    @Test
    void ScheduleDateSelectTest(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date schedule_date = null;
        try {
            schedule_date =  new Date(sdf.parse("2023-03-01").getTime());
        } catch (ParseException e) {
            System.out.println("날짜 버그 터짐");
        }
        try {
            ScheduleDTO schedule = service.selectDate(schedule_date);
            System.out.println(schedule.toString());
        } catch (Exception e) {
            System.out.println("버그 터짐");
        }
    }
    @Test
    void IsEmptyTest(){
        try {
            System.out.println(service.IsDateEmpty("2023-03-02"));
        } catch (Exception e) {
            System.out.println("ㅈ버그터짐");
        }
    }

    @Test
    void IsDateEmptyTest(){
        int site_code =1;
        String date="2023-03-02";
        try {
            System.out.println(service.IsDateEmpty(date) && reservationService.IsDateEmpty(site_code,date));
        } catch (Exception e) {
            System.out.println("ㅈ버그 터짐");
        }
    }
}
