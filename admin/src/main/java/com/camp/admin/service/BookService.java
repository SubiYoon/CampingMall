package com.camp.admin.service;

import com.camp.admin.DTO.GraphDTO;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.admin.DTO.BookDTO;
import com.camp.admin.DTO.ReservationDTO;
import com.camp.admin.frame.MyService;
import com.camp.admin.mapper.BookMapper;
import com.camp.admin.utility.Utility;

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

    //stringYearAndMonth = "2023-02"
    public List<String> DailyList(String stringYearAndMonth, int company_code)
        throws Exception {
        List<String> sales = new ArrayList<>();
        String stringDate = stringYearAndMonth + "-01";
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(Utility.StringToDate(stringDate));
        for (int i = 0; i < Utility.LastDayOfMonth(stringDate); i++) {
            sales.add(""+(int)DailySales(Utility.DateToString(calendar.getTime()), company_code));
            calendar.add(Calendar.DATE,+1);
        }
        return sales;
    }

    //해당 년월의 일별 매출을 GraphDTO 형식으로 담는다.
    public GraphDTO MonthSales(String stringYearAndMonth, int company_code) throws Exception {
        List<String> labelsList = new ArrayList<>();
        for (int i = 1; i <= Utility.LastDayOfMonth(stringYearAndMonth + "-01"); i++) {
            labelsList.add("" + i);
        }
        return new GraphDTO(labelsList, stringYearAndMonth,
            DailyList(stringYearAndMonth, company_code));
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

    //년간 월별 매출
    //stringYear = "2022"
    public List<String> MonthlyList(String stringYear, int company_code) throws Exception {
        List<String> sales = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String stringDate;
            if (i / 10 == 0) {
                stringDate = "-0" + i + "-01";
            } else {
                stringDate = "-" + i + "-01";
            }
            stringDate = stringYear + stringDate;
            sales.add("" + (int) MonthlySales(stringDate, company_code));
        }
        return sales;
    }

    //해당 년도의 월간 매출을 GraphDTO 형식으로 담는다.
    public GraphDTO YearSales(String stringYear, int company_code) throws Exception {
        List<String> labelsList = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            String stringDate;
            if (i / 10 == 0) {
                stringDate = stringYear + "/0" + i;
            } else {
                stringDate = stringYear + "/" + i;
            }
            labelsList.add(stringDate);
        }
        return new GraphDTO(labelsList, stringYear, MonthlyList(stringYear, company_code));
    }

    public List<BookDTO> selectUserAll(int user_code) {
        return mapper.selectUserAll(user_code);
    }
}
