package com.camp.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.camp.admin.DTO.ImageDTO;
import com.camp.admin.frame.MyMapper;

@Repository
@Mapper
public interface ImageMapper extends MyMapper<Integer, ImageDTO> {
    List<ImageDTO> selectByCompanyCode(int company_code);
    List<ImageDTO> selectByZoneCode(int zone_code);
    List<ImageDTO> selectBySiteCode(int site_code);
    List<ImageDTO> selectByHomeCode(int home_code);
    List<ImageDTO> selectByFacilityCode(int facility_code);
    ImageDTO selecOnetByHomeCode(int home_code);
	public ImageDTO zoneUpdate(ImageDTO imageDTO);
}
