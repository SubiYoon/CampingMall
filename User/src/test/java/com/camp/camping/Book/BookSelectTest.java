package com.camp.camping.Book;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.service.BookService;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
    @Test
    void Refund(){
        try {
            System.out.println(service.IsAvailableRequestRefund(5));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
