package com.camp.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.NoticeDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface NoticeMapper extends MyMapper<Integer, NoticeDTO> {

	public List<NoticeDTO> noticeLv(Integer companycode) throws Exception;

	public List<NoticeDTO> selectByCompanycode(Integer k) throws Exception;
}
