package com.camp.camping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.frame.MyMapper;

@Repository
@Mapper
public interface BookMapper extends MyMapper<Integer, BookDTO> {
    BookDTO selectMerchant(String merchant_uid);
    
    List<BookDTO> selectUserAll(int user_code);

    List<BookDTO> selectUserSiteBook(int site_code, int user_code);

    List<BookDTO> selectUserSiteReview(int site_code, int user_code);

    int updateBookState(@Param("merchant_uid") String merchant_uid, @Param("state") int state);

    void insert2(BookDTO bookDTO);

}
