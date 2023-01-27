package com.camp.camping.Book;

import com.camp.camping.service.BookService;
import com.camp.camping.service.ReservationService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;

@SpringBootTest
public class BookDeleteTest {
    @Inject
    BookService service;



    @Test
    @Disabled
    void BookDeleteTests(){
        try {
            service.delete(13);
            System.out.println("삭제 성공");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("버그터짐");
        }
    }
    @Inject
    ReservationService reservationService;

    @Test
    @Disabled
    void BookDeleteTests2(){
        int book_code=15;
        try {
            reservationService.deleteByBook(book_code);
            System.out.println("Reservation 삭제 성공");
            service.delete(book_code);
            System.out.println("book 삭제 성공");
        } catch (Exception e) {
            System.out.println("버그터짐");
        }
    }

    @Test
    void BookDeleteTest3(){
        int book_code=16;
        try {
            service.deleteBookAndReservation(book_code);
            System.out.println("삭제 성공");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("버그터짐3");
            throw new RuntimeException(e);
        }
    }
}
