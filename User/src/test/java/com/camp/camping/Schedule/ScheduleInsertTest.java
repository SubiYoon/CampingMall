package com.camp.camping.Schedule;

import com.camp.camping.DTO.ScheduleDTO;
import com.camp.camping.service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class ScheduleInsertTest {
    @Inject
    ScheduleService service;

    @Test
    void ScheduleInsertTests(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date schedule_date = null;
        try {
            schedule_date =  new Date(sdf.parse("2023-03-01").getTime());
        } catch (ParseException e) {
            System.out.println("날짜 버그 터짐");
        }
        ScheduleDTO schedule = new ScheduleDTO(0,1,schedule_date,"방역");
        try {
            service.insert(schedule);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("버그터짐");
        }
    }
}
