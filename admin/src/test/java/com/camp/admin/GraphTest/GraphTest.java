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
            System.out.println(bookService.YearSalesGraph("2023",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void MonthSales(){
        try {
            System.out.println(bookService.MonthSalesGraph("2023-02",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void usersNumberTest(){
        try {
            System.out.println(bookService.DailySiteUserMap("2023-02-01",1));
            System.out.println(bookService.MonthlySiteUserMap("2023-02",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void MonthUsersNumberGraph(){
        try {
            System.out.println(bookService.MonthlySiteUserGraph("2023-02",1));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void YearUserNumbersGraph(){
        try {
            System.out.println(bookService.YearlySiteUserGraph("2023",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void MonthZoneSales(){
        try {
            System.out.println(bookService.MonthlyZoneSalesGraph("2023-02",1));
            System.out.println(bookService.YearlyZoneSalesGraph("2023",1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
