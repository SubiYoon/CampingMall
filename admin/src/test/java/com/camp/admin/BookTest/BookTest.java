package com.camp.admin.BookTest;

import com.camp.admin.service.BookService;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {
    @Inject
    BookService bookService;
    @Test
    void DailyRate(){
        try {
            System.out.println(bookService.DailySales("2023-02-02",1));
            System.out.println(bookService.DailySales("2023-02-03",1));

            System.out.println(bookService.DailySalesRate("2023-02-03",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void Rate(){
        try {
            System.out.println(bookService.MonthlySalesRate("2023-02",1));
            System.out.println(bookService.MonthlySalesRate("2023-03",1));
            System.out.println(bookService.YearlySalesRate("2023",1));
            System.out.println(bookService.YearlySalesRate("2024",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void count(){
        try {
            System.out.println(bookService.DailyUser("2023-02-02",1));
            System.out.println(bookService.DailyUser("2023-02-03",1));
            System.out.println(bookService.DailyUser("2023-02-04",1));
            System.out.println(bookService.MonthlyUser("2023-02",1));
            System.out.println(bookService.YearlyUser("2023",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    void UserRate(){
        try {
            System.out.println(bookService.DailyUser("2023-02-02",1));
            System.out.println(bookService.DailyUser("2023-02-03",1));
            System.out.println(bookService.DailyUser("2023-02-04",1));
            System.out.println(bookService.DailyUserRate("2023-02-03",1));
            System.out.println(bookService.DailyUserRate("2023-02-04",1));
            System.out.println(bookService.MonthlyUserRate("2023-02",1));
            System.out.println(bookService.YearlyUserRate("2023",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
