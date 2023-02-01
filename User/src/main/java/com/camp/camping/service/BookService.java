package com.camp.camping.service;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.BookMapper;
import com.camp.camping.utility.Utility;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements MyService<Integer, BookDTO> {

    @Autowired
    BookMapper mapper;
    @Autowired
    ReservationService reservationService;

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

    public List<BookDTO> selectUserAll(int user_code){
        return mapper.selectUserAll(user_code);
    }
}