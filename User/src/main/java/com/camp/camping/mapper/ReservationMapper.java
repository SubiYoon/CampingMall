package com.camp.camping.mapper;

import com.camp.camping.DTO.ReservationDTO;
import com.camp.camping.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface ReservationMapper extends MyMapper<Integer, ReservationDTO> {
    List<ReservationDTO> selectDate(Date d);

    List<ReservationDTO> selectByDateAndCompanyCode(@Param("reservation_date") Date reservation_Date,
            @Param("company_code") int company_code);

    void deleteByBook(Integer k);

    ReservationDTO selectDateAndSite(@Param("site_code") int site_code,
            @Param("reservation_date") Date reservation_date);

    int findSiteCode(@Param("reservation_code") int reservation_code);
}
