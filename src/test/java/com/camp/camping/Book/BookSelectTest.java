package com.camp.camping.Book;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.service.BookService;
import java.text.ParseException;
import java.util.List;
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
    @Test
    void BookSelectDateCompanyTest(){
        List<BookDTO> books;
        try {
            books = service.SelectByDateAndCompanyCode("2023-02-03",1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        for(BookDTO book : books){
            System.out.println(book);
        }
    }
    @Test
    void money(){
        try {
            System.out.println(service.DailySales("2023-02-03",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void MonthMoney(){
        try {
            System.out.println(service.MonthlySales("2023-02-03",1));
        } catch (Exception e) {
            System.out.println("ㅈ버그");
        }
    }


}
