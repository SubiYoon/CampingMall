package com.camp.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.SiteDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface SiteMapper extends MyMapper<Integer, SiteDTO> {	
    List<Integer> selectByCompany(@Param("company_code")int company_code);
    int findCompanyCode(@Param("site_code")int site_code);
    
    List<SiteDTO> selectSet(Integer company_code) throws Exception;
    public SiteDTO selectView(int site_code);
}
