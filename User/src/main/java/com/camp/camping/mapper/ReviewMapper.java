package com.camp.camping.mapper;

import com.camp.camping.DTO.ReviewDTO;
import com.camp.camping.frame.MyMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface ReviewMapper extends MyMapper<Integer, ReviewDTO> {
	    List<ReviewDTO> selectByCompanyCode(int company_code);
}
