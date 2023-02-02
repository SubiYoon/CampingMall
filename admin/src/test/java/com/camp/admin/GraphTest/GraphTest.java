package com.camp.admin.GraphTest;

import com.camp.admin.service.BookService;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GraphTest {
    @Inject
    BookService bookService;
    @Test
    void YearSales(){
        try {
            System.out.println(bookService.YearSales("2023",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void MonthSales(){
        try {
            System.out.println(bookService.MonthSales("2023-02",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
