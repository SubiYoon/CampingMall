package com.camp.admin.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.ReservationDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface ReservationMapper extends MyMapper<Integer, ReservationDTO> {

    void deleteByBook(Integer k);

    ReservationDTO selectDateAndSite(@Param("site_code") int site_code,
        @Param("reservation_date") Date reservation_date);


    List<ReservationDTO> selectByCompanyCodeAndYearMonth(int company_code,
        String stringYearAndMonth);
}
