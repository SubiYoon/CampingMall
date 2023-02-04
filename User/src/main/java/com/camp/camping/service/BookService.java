package com.camp.camping.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.DTO.SiteDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.BookMapper;
import com.camp.camping.utility.Utility;

@Service
public class BookService implements MyService<Integer, BookDTO> {

    @Autowired
    BookMapper mapper;
    @Autowired
    ReservationService reservationService;
    @Autowired
    SiteService siteService;

    @Override
    public void insert(BookDTO v) throws Exception {
        mapper.insert(v);
    }

    @Override
    public void delete(Integer k) throws Exception {
        mapper.delete(k);
    }

    @Override
    public void update(BookDTO v) throws Exception {
        mapper.update(v);
    }

    @Override
    public BookDTO select(Integer k) throws Exception {
        return mapper.select(k);
    }

    @Override
    public List<BookDTO> selectAll() throws Exception {
        return mapper.selectAll();
    }

    public BookDTO selectMerchant(String merchant_uid) {
        return mapper.selectMerchant(merchant_uid);
    }

    public void insertBookAndReservation(BookDTO v) throws Exception {
        this.insert(v);

        BookDTO book = this.selectMerchant(v.getMerchant_uid());
        reservationService.insertReservationByBook(book);
    }

    public void deleteBookAndReservation(Integer k) throws Exception {
        reservationService.deleteByBook(k);
        BookDTO book = this.select(k);
        book.setBook_state(0);
        this.update(book);
    }

    public BookDTO SelectByReservationCode(int reservation_code) {
        return mapper.selectByReservationCode(reservation_code);
    }

    //예약 조회 기능
    public List<BookDTO> SelectByDateAndCompanyCode(String stringDate, int company_code)
        throws ParseException {
        List<BookDTO> books = new ArrayList<>();
        List<ReservationDTO> reservations = reservationService.SelectByDateAndCompanyCode(
            stringDate, company_code);
        for (ReservationDTO reservation : reservations) {
            books.add(SelectByReservationCode(reservation.getReservation_code()));
        }
        return books;
    }

    //일매출
    public double DailySales(String reservation_Date, int company_code) throws Exception {
        List<ReservationDTO> reservations = reservationService.SelectByDateAndCompanyCode(
            reservation_Date, company_code);
        double dailySales = 0;
        for (ReservationDTO reservation : reservations) {
            BookDTO book = select(reservation.getBook_code());
            double bookDays = Utility.StringDateDifference(book.getBook_checkout(),
                book.getBook_checkin());
            dailySales += (double) book.getBook_price() / bookDays;
        }
        return dailySales;
    }

    //월매출(date는 year랑 month만 정상적으로 담겨있으면 됨)
    public double MonthlySales(String stringDate, int company_code) throws Exception {
        double monthlySales = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        calendar = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
            1);
        int daysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < daysOfMonth; i++) {
            monthlySales += DailySales(Utility.DateToString(calendar.getTime()), company_code);
            calendar.add(Calendar.DATE, 1);
        }
        return monthlySales;
    }

    public List<BookDTO> selectUserAll(int user_code) {
        return mapper.selectUserAll(user_code);
    }


    public BookDTO selectViewForm(String book_checkin, String book_checkout, int book_sitecode) {

        BookDTO book = new BookDTO();
        try {
            SiteDTO site = siteService.select(book_sitecode);
            book.setSite_name(site.getSite_name());
            book.setBook_price(site.getSite_price());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        Calendar cal = Calendar.getInstance();
        Random random = new Random();
        book.setMerchant_uid(dateFormat.format(cal.getTime()) + random.nextInt(100000));
        book.setBook_checkin(book_checkin);
        book.setBook_checkout(book_checkout);
        book.setSite_code(book_sitecode);

        return book;
    }

    public boolean availableUserWriteReview(int site_code, int user_code) {
        List<BookDTO> bookList1 = mapper.selectUserSiteBook(site_code, user_code);
        List<BookDTO> bookList2 = mapper.selectUserSiteReview(site_code, user_code);
        return bookList1.size() > bookList2.size();
    }

    public List<BookDTO> getReviewAvailableCode(int site_code, int user_code) {
        List<BookDTO> result = new ArrayList<>();
        List<BookDTO> bookList1 = mapper.selectUserSiteBook(site_code, user_code);
        List<BookDTO> bookList2 = mapper.selectUserSiteReview(site_code, user_code);

        first:
        for (BookDTO bookDTO : bookList1) {
            for (BookDTO dto : bookList2) {
                if (bookDTO.getBook_code() == dto.getBook_code()) {
                    continue first;
                }
            }
            result.add(bookDTO);
        }

        return result;
    }

    //날짜(stringDate : "2023-02-01")를 입력받으면 체크인 날짜와 비교한다.
    //환불 요청 가능이면 1 아니면 0을 반환
    //환불 요청 가능 여부 판단 메소드
    public int IsAvailableRequestRefund(int book_code) throws Exception {
        BookDTO book = select(book_code);
        Date checkin = Utility.StringToDate(book.getBook_checkin());
        LocalDate now = LocalDate.now();
        Date nowDate= Utility.StringToDate(now.toString());
        if(checkin.after(nowDate)){
            return 1;
        }
        return 0;
    }
}
