package com.camp.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.HomeDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface HomeMapper extends MyMapper<Integer, HomeDTO>{
	
	public HomeDTO lnglat(Integer companycode) throws Exception;
	
	public HomeDTO homeCont(Integer companycode) throws Exception;
}
