package com.camp.camping.Book;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.DTO.PaymentDTO;
import com.camp.camping.service.BookService;
import com.camp.camping.service.PaymentService;
import com.camp.camping.service.SiteService;
import com.camp.camping.utility.Utility;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookInsertSampleTest {

    @Inject
    BookService bookService;
    @Inject
    PaymentService paymentService;
    @Inject
    SiteService siteService;

    @Test
    void insert() {

        //사이트 코드 부분
        int start_site_code = 1;
        int end_site_code = 20;
        int start_merchant_uid = 10;
        int sample_count = 190;

        String[] center = {"가", "나", "다", "라", "마", "바", "사"};
        int siteCode;
        int userCode;
        String merchantUid;
        String bookCheckin;
        String bookCheckout;
        int bookMember;
        Date bookWritedate;
        int bookPrice;
        String bookCarNumber;
        for (int i = start_merchant_uid; i < start_merchant_uid + sample_count; i++) {
            merchantUid = "" + i;
            String impUID = "imp_" + (int) (Math.random() * 10);
            for (int j = 0; j < 10; j++) {
                impUID += (int) (Math.random() * 10);
            }
            try {
                paymentService.insert(new PaymentDTO(impUID, merchantUid, "1"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Calendar calendar = Calendar.getInstance();

            siteCode = start_site_code + (int) (Math.random() * end_site_code);

            userCode = 1 + (int) (Math.random() * 9);

            int x = (int) (30 - Math.random() * 330);
            calendar.add(Calendar.DATE, x);
            bookCheckin = Utility.DateToString(calendar.getTime());
            int y = (int) (Math.random() * 5 + Math.random() * 4 + 1);
            calendar.add(Calendar.DATE, -y);
            bookWritedate = calendar.getTime();
            calendar.add(Calendar.DATE, y);
            y = (int) (Math.random() * 2 + Math.random() * 2 + 1);
            calendar.add(Calendar.DATE, y);
            bookCheckout = Utility.DateToString(calendar.getTime());
            calendar.add(Calendar.DATE, -(x + y));
            bookMember = (int) (Math.random() * 2 + Math.random() * 3 + 1);
            bookPrice = (int) (Math.random() * 6 + 1) * 10000;
            bookCarNumber =
                "" + (int) (Math.random() * 99) + (int) (Math.random() * 10)
                    + center[(int) (Math.random() * 7)] + (int) (Math.random() * 10)
                    + (int) (Math.random() * 10) + (int) (Math.random() * 10)
                    + (int) (Math.random() * 10)
                    + "," + (int) ((Math.random() * 120) / 100)
                    + "," + (int) ((Math.random() * 120) / 100)
                    + "," + (int) ((Math.random() * 120) / 100);
            BookDTO bookDTO = new BookDTO(1, siteCode, userCode, merchantUid, bookMember,
                bookCheckin, bookCheckout, bookWritedate, bookPrice, bookCarNumber, 1, "", "");
            try {
                int count = 0;
                while (count < 20) {
                    if (siteService.IsOkToReservation(siteCode, bookCheckin, bookCheckout)) {
                        bookService.insertBookAndReservationForSample(bookDTO);
                        break;
                    }
                    siteCode = 1 + (int) (Math.random() * 20);
                    count++;
                }
            } catch (Exception e) {
                System.out.println("버그");
            }
        }

    }
}
