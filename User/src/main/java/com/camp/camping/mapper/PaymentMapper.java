package com.camp.camping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.camping.DTO.PaymentDTO;
import com.camp.camping.frame.MyMapper;

@Repository
@Mapper
public interface PaymentMapper extends MyMapper<String, PaymentDTO>{
	public int selectOk(String merchant_uid) throws Exception;
}
