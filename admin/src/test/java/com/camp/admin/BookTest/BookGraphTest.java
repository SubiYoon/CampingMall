package com.camp.admin.BookTest;

import com.camp.admin.DTO.BookDTO;
import com.camp.admin.DTO.ReservationDTO;
import com.camp.admin.service.BookService;
import com.camp.admin.service.ReservationService;
import com.camp.admin.utility.MakeMonthGraph;
import java.text.ParseException;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookGraphTest {
    @Inject
    BookService bookService;
    @Inject
    ReservationService reservationService;

    @Test
    void Monthly() throws ParseException {
        List<BookDTO> bookList = bookService.selectByCompanyCodeAndYearMonth(1,"2023-02");
        List<BookDTO> bookList2 = bookService.selectByCompanyCodeAndWriteDate(1,"2023-02");
        List<ReservationDTO> reservationList = reservationService.selectByCompanyCodeAndYearMonth(1,"2023-02");
        MakeMonthGraph a = new MakeMonthGraph(bookList,reservationList,"2023-02",bookList2);
        System.out.println(a.MakeBookGraph());
        System.out.println(a.MakeRevenueGraph());
        System.out.println(a.MakeVisitorGraph());
    }

}
