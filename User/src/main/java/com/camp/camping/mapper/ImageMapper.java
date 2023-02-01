package com.camp.camping.mapper;

import com.camp.camping.DTO.ImageDTO;
import com.camp.camping.frame.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ImageMapper extends MyMapper<Integer, ImageDTO> {
    List<ImageDTO> selectByCompanyCode(int company_code);
    List<ImageDTO> selectByZoneCode(int zone_code);
    List<ImageDTO> selectBySiteCode(int site_code);
    List<ImageDTO> selectByHomeCode(int home_code);
    List<ImageDTO> selectByFacilityCode(int facility_code);
}
