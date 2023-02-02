package com.camp.camping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.camping.DTO.CompanyDTO;
import com.camp.camping.frame.MyMapper;

@Repository
@Mapper
public interface CompanyMapper extends MyMapper<Integer, CompanyDTO>{
}
