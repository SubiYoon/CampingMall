package com.camp.camping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.camping.DTO.ZoneDTO;
import com.camp.camping.frame.MyMapper;

@Repository
@Mapper
public interface ZoneMapper extends MyMapper<Integer, ZoneDTO>{
    
	public List<ZoneDTO> selectZone(Integer companycode) throws Exception;
}
