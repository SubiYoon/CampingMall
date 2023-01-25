package com.camp.camping.Book;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;

@SpringBootTest
public class BookSelectTest {
    @Inject
    BookService service;

    @Test
    void BookMerchantSelectTests(){
        BookDTO book;
        try {
            book = service.selectMerchant("2");
            System.out.println("성공");
            System.out.println(book.toString());
        } catch (Exception e) {
            System.out.println("버그터짐");
        }
    }
}
