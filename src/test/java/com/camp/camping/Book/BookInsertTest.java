package com.camp.camping.Book;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.service.BookService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;


@SpringBootTest
public class BookInsertTest {
    @Inject
    BookService service;

    @Test
    @Disabled
    void BookInsertTests() {

        BookDTO book = new BookDTO(1, 1, "1", 1, "2022-09-01", "2022-09-02", 30000, "18공7001");

        try {
            service.insert(book);
            System.out.println("성공");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("실패");
        }
    }
        @Test
    void BookInsertTests2() {
        BookDTO book = new BookDTO(1, 1, "5", 1, "2022-09-01", "2022-09-05", 30000, "18공7001");
        try {
            service.insertBookAndReservation(book);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("실패");
        }
    }
}



