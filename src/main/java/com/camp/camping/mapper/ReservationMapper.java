package com.camp.camping.mapper;

import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReservationMapper extends MyMapper<Integer, ReservationDTO> {
}
