package com.camp.camping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.camping.DTO.NoticeDTO;
import com.camp.camping.frame.MyMapper;

@Repository
@Mapper
public interface NoticeMapper extends MyMapper<Integer, NoticeDTO>{
	
	public List<NoticeDTO> noticeLv(Integer companycode) throws Exception;
}
