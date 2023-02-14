package com.camp.camping.service;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.DTO.SiteDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.BookMapper;
import com.camp.camping.utility.Utility;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        int list1Size = 0;
        for(BookDTO book : bookList1){
            try {
                Date checkOut = Utility.StringToDate(book.getBook_checkout());
                Date today = Calendar.getInstance().getTime();
                if(book.getBook_state() == 3){
                    continue;
                }
                if(checkOut.before(today)){
                    list1Size++;
                }
            } catch (Exception e) {
                System.out.println("버그");
            }
        }
        return list1Size > bookList2.size();
    }

    public List<BookDTO> getReviewAvailableCode(int site_code, int user_code) {
        List<BookDTO> result = new ArrayList<BookDTO>();
        List<BookDTO> bookList1 = mapper.selectUserSiteBook(site_code, user_code);
        List<BookDTO> bookList2 = mapper.selectUserSiteReview(site_code, user_code);

        first: for (int i = 0; i < bookList1.size(); i++) {
            for (int j = 0; j < bookList2.size(); j++) {
                if (bookList1.get(i).getBook_code() == bookList2.get(j).getBook_code()) {
                    continue first;
                }
            }
            result.add(bookList1.get(i));
        }

        return result;
    }

    public int IsAvailableRequestRefund(int book_code) throws Exception {
        BookDTO book = select(book_code);
        Date checkin = Utility.StringToDate(book.getBook_checkin());
        LocalDate now = LocalDate.now();
        Date nowDate = Utility.StringToDate(now.toString());
        if (checkin.after(nowDate)) {
            return 1;
        }
        return 0;
    }

    public int updateBookState(String merchant_uid, int state) {
        return mapper.updateBookState(merchant_uid, state);
    }

    public void insertForSample(BookDTO v) throws Exception {
        mapper.insert2(v);
    }

    public void insertBookAndReservationForSample(BookDTO v) throws Exception {
        this.insertForSample(v);

        BookDTO book = this.selectMerchant(v.getMerchant_uid());
        reservationService.insertReservationByBook(book);
    }
}
