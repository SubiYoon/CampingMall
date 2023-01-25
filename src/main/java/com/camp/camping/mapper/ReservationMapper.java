package com.camp.camping.mapper;

import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface ReservationMapper extends MyMapper<Integer, ReservationDTO> {
    List<ReservationDTO> selectDate(Date d);

    void deleteByBook(Integer k);
}
