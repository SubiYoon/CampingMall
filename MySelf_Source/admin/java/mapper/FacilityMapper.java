package com.camp.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.FacilityDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface FacilityMapper extends MyMapper<Integer, FacilityDTO> {
    public List<FacilityDTO> selectByCompany(int company_code);
}
