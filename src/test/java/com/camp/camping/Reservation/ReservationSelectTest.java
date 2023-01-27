package com.camp.camping.Reservation;

import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;

@SpringBootTest
public class ReservationSelectTest {
    @Inject
    ReservationService service;

    @Test
    void ReservationSelectTests(){
        ReservationDTO reservation;
        try{
            reservation = service.select(1);
            System.out.println("성공");
            System.out.println(reservation.toString());
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("버그터짐");
        }
    }

}
