package com.camp.camping.mapper;

import com.camp.camping.DTO.ScheduleDTO;
import com.camp.camping.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@Mapper
public interface ScheduleMapper extends MyMapper<Integer, ScheduleDTO> {
    ScheduleDTO selectDate(@Param("schedule_date") Date schedule_date, @Param("company_code") int company_code);
}
