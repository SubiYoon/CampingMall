package com.camp.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.CompanyDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface CompanyMapper extends MyMapper<Integer, CompanyDTO> {
}
