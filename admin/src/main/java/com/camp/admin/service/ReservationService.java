package com.camp.admin.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camp.admin.DTO.BookDTO;
import com.camp.admin.DTO.ReservationDTO;
import com.camp.admin.frame.MyService;
import com.camp.admin.mapper.ReservationMapper;
import com.camp.admin.utility.Utility;

@Service
public class ReservationService implements MyService<Integer, ReservationDTO> {

    @Autowired
    ReservationMapper mapper;

    @Override
    public void insert(ReservationDTO v) throws Exception {
        mapper.insert(v);
    }

    @Override
    public void delete(Integer k) throws Exception {
        mapper.delete(k);
    }

    @Override
    public void update(ReservationDTO v) throws Exception {
        mapper.update(v);
    }

    @Override
    public ReservationDTO select(Integer k) throws Exception {
        return mapper.select(k);
    }

    @Override
    public List<ReservationDTO> selectAll() throws Exception {
        return mapper.selectAll();
    }


    public void deleteByBook(Integer k) {
        mapper.deleteByBook(k);
    }


    public void insertReservationByBook(BookDTO book) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date reservationDate = Utility.StringToDate(book.getBook_checkout());

        Calendar cal = Calendar.getInstance();
        cal.setTime(reservationDate);

        for (int i = BookDays(book); i > 0; i--) {
            cal.add(Calendar.DATE, -1);
            ReservationDTO reservation = new ReservationDTO(book.getBook_code(),
                    "" + sdf.format(cal.getTime()));
            mapper.insert(reservation);
        }
    }

    private int BookDays(BookDTO book) {
        long diff;
        try {
            diff = (Utility.StringToDate(book.getBook_checkout()).getTime() - Utility.StringToDate(
                    book.getBook_checkin()).getTime()) / 1000;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long difDays = diff / (24 * 60 * 60);
        return (int) difDays;
    }

    public ReservationDTO selectDateAndSite(int site_code, String reservation_Date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        ReservationDTO reservation;
        try {
            reservation = mapper.selectDateAndSite(site_code,
                    new Date(sdf.parse(reservation_Date).getTime()));
        } catch (ParseException e) {
            System.out.println("날짜 버그 터짐");
            throw new RuntimeException(e);
        }
        return reservation;
    }

    public Boolean IsDateEmpty(int site_code, String reservation_Date) {
        ReservationDTO reservation = selectDateAndSite(site_code, reservation_Date);
        try {
            return reservation == null
                    || reservation.getReservation_date() == null;
        } catch (Exception e) {
            return true;
        }
    }

    public List<ReservationDTO> selectByCompanyCodeAndYearMonth(int company_code, String stringYearAndMonth) {
        return mapper.selectByCompanyCodeAndYearMonth(company_code, stringYearAndMonth + "%");
    }
}
