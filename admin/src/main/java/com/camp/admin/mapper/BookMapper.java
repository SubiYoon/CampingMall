package com.camp.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.BookDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface BookMapper extends MyMapper<Integer, BookDTO> {
    BookDTO selectMerchant(String merchant_uid);
    BookDTO selectByReservationCode(int reservation_code);
    List<BookDTO> selectUserAll(int user_code);
    List<BookDTO> selectByWriteDateAndCompanyCode(int company_code, String book_writedate);
}
