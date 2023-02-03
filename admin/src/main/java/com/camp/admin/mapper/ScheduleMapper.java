package com.camp.admin.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.ScheduleDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface ScheduleMapper extends MyMapper<Integer, ScheduleDTO> {
    ScheduleDTO selectDate(@Param("schedule_date") Date schedule_date, @Param("company_code") int company_code);
}
