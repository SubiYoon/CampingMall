package com.camp.admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.BookDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface BookMapper extends MyMapper<Integer, BookDTO> {
    BookDTO selectMerchant(String merchant_uid);

    List<Map<String, Object>> selectAllState(int book_state);

    int updateBookState(@Param("merchant_uid") String merchant_uid, @Param("state") int state);

    List<BookDTO> selectUserBook(int company_code, String user_id);


    List<Map<String, Object>> selectAllmain(int company_code);

    List<BookDTO> selectByCompanyCodeAndYearMonth(int company_code, String stringYearMonth);

    List<BookDTO> selectByCompanyCodeAndWriteDate(int company_code, String stringYearMonth);
}
