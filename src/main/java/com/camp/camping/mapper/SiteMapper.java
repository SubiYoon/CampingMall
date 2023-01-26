package com.camp.camping.mapper;

import com.camp.camping.DTO.SiteDTO;
import com.camp.camping.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SiteMapper extends MyMapper<Integer, SiteDTO> {
    List<Integer> selectByCompany(@Param("company_code")int company_code);
}
