package com.camp.admin.mapper;

import com.camp.admin.DTO.ReviewDTO;
import com.camp.admin.frame.MyMapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReviewMapper extends MyMapper<Integer, ReviewDTO> {
	List<ReviewDTO> selectByCompanyCode(int company_code);

	List<Map<String, Object>> selectAllmain(int company_code);
}
