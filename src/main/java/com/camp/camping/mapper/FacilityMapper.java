package com.camp.camping.mapper;

import com.camp.camping.DTO.FacilityDTO;
import com.camp.camping.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FacilityMapper extends MyMapper<Integer, FacilityDTO> {

}
