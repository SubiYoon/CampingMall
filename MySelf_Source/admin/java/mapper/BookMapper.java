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
    List<BookDTO> selectUserBook(int company_code, String user_id);
}
