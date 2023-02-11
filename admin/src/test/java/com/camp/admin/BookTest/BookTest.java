package com.camp.admin.BookTest;

import com.camp.admin.DTO.BookDTO;
import com.camp.admin.service.BookService;
import java.time.LocalDate;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookTest {

    @Inject
    BookService bookService;


    @Test
    void asdf() {
        LocalDate now = LocalDate.now();
        String month = ("0" + now.getMonthValue());
        month = "012";
        month = month.substring(month.length() - 2);
        System.out.println(month);
    }

    @Test
    void YMcompna() {
        List<BookDTO> a = bookService.selectByCompanyCodeAndYearMonth(1, "2023-02");
        for (BookDTO x : a) {
            System.out.println(x);
        }
    }
}
