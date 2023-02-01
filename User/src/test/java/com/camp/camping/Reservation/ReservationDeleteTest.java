package com.camp.camping.Reservation;

import com.camp.camping.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;

@SpringBootTest
public class ReservationDeleteTest {
    @Inject
    ReservationService service;

    @Test
    void ReservationDeleteTests1(){
        try {
            service.deleteByBook(10);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ㅈ버그터짐");
        }
    }
}
