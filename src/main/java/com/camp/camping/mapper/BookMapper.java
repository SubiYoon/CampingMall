package com.camp.camping.mapper;

import com.camp.camping.DTO.BookDTO;
import com.camp.camping.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BookMapper extends MyMapper<Integer, BookDTO> {
    BookDTO selectMerchant(String merchant_uid);
}
