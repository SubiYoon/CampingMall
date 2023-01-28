package com.camp.camping.Book;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.service.BookService;

@SpringBootTest
public class BookSelectUserTest {
    @Inject
    BookService service;

    @Test
    void Test(){
        List<BookDTO> books = service.selectUserAll(4);

        System.out.println(books);
    }
    
}
