package com.camp.camping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.camping.DTO.HomeDTO;
import com.camp.camping.frame.MyMapper;

@Repository
@Mapper
public interface HomeMapper extends MyMapper<String, HomeDTO>{
	public List<HomeDTO> lnglat(int adcode) throws Exception;
}
