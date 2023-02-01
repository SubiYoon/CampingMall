package com.camp.camping.Reservation;


import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.service.ReservationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;

@SpringBootTest
public class ReservationInsertTest {
    @Inject
    ReservationService service;

    @Test
    void ReservationInsertTests() {
        ReservationDTO reservation = new ReservationDTO(1, "2023-02-03");
        try {
            service.insert(reservation);
            System.out.println("성공");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("버그터짐");
        }
    }

}
