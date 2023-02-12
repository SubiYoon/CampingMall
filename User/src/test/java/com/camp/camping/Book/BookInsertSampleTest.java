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
        int end_site_code = 40;

        //시작번호를 쓸 merchant_uid
        int start_merchant_uid = 4000;

        //샘플 갯수
        int sample_count = 500;

        //현재 기준 몇 일 전 까지 체크인으로 가능인지
        int min_check_in_days = 300;

        //현재 기준 몇 일 후 까지 체크인으로 가능인지
        int max_check_in_days = 30;

        //몇 % 확률로 추가사항을 추가하는지(0~100)
        int rate_of_book_details = 25;

        //유저 코드 시작 번호
        int start_user_code = 1;
        //유저 코드 끝 번호
        int end_user_code = 9;

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
        int bookState = 5;
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

            siteCode =
                start_site_code + (int) (Math.random() * (1 - start_site_code + end_site_code));

            userCode =
                start_user_code + (int) (Math.random() * (1 - start_user_code + end_user_code));

            int x = (int) (max_check_in_days - Math.random() * (max_check_in_days
                + min_check_in_days));
            calendar.add(Calendar.DATE, x);
            bookCheckin = Utility.DateToString(calendar.getTime());
            if (calendar.getTime().after(Calendar.getInstance().getTime())) {
                bookState = 1;
            }
            int y = (int) (Math.random() * 5 + Math.random() * 4 + Math.random() * 4 + 1);
            calendar.add(Calendar.DATE, -y);
            int counts = 1;
            //
            while (!calendar.before(Calendar.getInstance())) {
                calendar.add(Calendar.DATE, -y);
                counts++;
            }

            bookWritedate = calendar.getTime();
            calendar.add(Calendar.DATE, y * counts);
            y = (int) (Math.random() * 1.2 + Math.random() * 1.4 + Math.random() * 1.7
                + Math.random() * 2 + 1);
            calendar.add(Calendar.DATE, y);
            bookCheckout = Utility.DateToString(calendar.getTime());
            calendar.add(Calendar.DATE, -(x + y));
            bookMember = (int) (Math.random() * 2 + Math.random() * 2 + 2);
            bookPrice = (int) (Math.random() * 4 + (bookMember * 2) + 4) * 5000;
            if (Math.random() * 10 > 1.5) {
                bookCarNumber = "" + (int) (Math.random() * 99) + (int) (Math.random() * 10)
                    + center[(int) (Math.random() * 7)] + (int) (Math.random() * 10)
                    + (int) (Math.random() * 10) + (int) (Math.random() * 10)
                    + (int) (Math.random() * 10);
            } else {
                bookCarNumber = "차량없음";
            }

            bookCarNumber += "," + (int) ((Math.random() * (100 + rate_of_book_details)) / 100)
                + "," + (int) ((Math.random() * (100 + rate_of_book_details)) / 100)
                + "," + (int) ((Math.random() * (100 + rate_of_book_details)) / 100);
            BookDTO bookDTO = new BookDTO(1, siteCode, userCode, merchantUid, bookMember,
                bookCheckin, bookCheckout, bookWritedate, bookPrice, bookCarNumber, bookState, "",
                "");
            try {
                int count = 0;
                while (count < 10) {
                    if (siteService.IsOkToReservation(siteCode, bookCheckin, bookCheckout)) {
                        bookDTO.setSite_code(siteCode);
                        bookService.insertBookAndReservationForSample(bookDTO);
                        break;
                    }
                    siteCode = start_site_code + (int) (Math.random() * (1 - start_site_code
                        + end_site_code));
                    count++;
                }
            } catch (Exception e) {
                System.out.println("버그");
                System.out.println(bookDTO);
                e.printStackTrace();
            }
        }

    }
}
