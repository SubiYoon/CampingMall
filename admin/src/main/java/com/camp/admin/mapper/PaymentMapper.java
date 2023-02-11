package com.camp.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.PaymentDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface PaymentMapper extends MyMapper<String, PaymentDTO> {
	public int selectOk(String merchant_uid) throws Exception;
}
