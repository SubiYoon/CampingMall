package com.camp.camping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.frame.MyMapper;

@Repository
@Mapper
public interface HomeMapper extends MyMapper<Integer, HomeDTO>{
	
	public HomeDTO lnglat(Integer companycode) throws Exception;
	
	public HomeDTO homeCont(Integer companycode) throws Exception;
}
