package com.camp.camping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.camping.DTO.ZoneDTO;
import com.camp.camping.frame.MyMapper;

@Repository
@Mapper
public interface ZoneMapper extends MyMapper<Integer, ZoneDTO>{
    
}
