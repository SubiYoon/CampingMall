package com.camp.camping.service;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    public BookDTO selectMerchant(String merchant_uid) throws Exception {
        return mapper.selectMerchant(merchant_uid);
    }

    public void insertBookAndReservation(BookDTO v) throws Exception {
        BookDTO book = v;
        this.insert(book);
        long diff = (book.getBook_checkout().getTime() - book.getBook_checkin().getTime()) / 1000;
        long difDays = diff / (24 * 60 * 60);
        book = this.selectMerchant(book.getMerchant_uid());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date reservationDate = book.getBook_checkout();
        Calendar cal = Calendar.getInstance();
        cal.setTime(reservationDate);
        for (int i = (int) difDays; i > 0; i--) {
            cal.add(Calendar.DATE, -1);
            ReservationDTO reservation = new ReservationDTO(book.getBook_code(), "" + sdf.format(cal.getTime()));
            reservationService.insert(reservation);
        }
    }
}
