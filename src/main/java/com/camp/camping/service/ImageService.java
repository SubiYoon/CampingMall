package com.camp.camping.service;

import com.camp.camping.DTO.ImageDTO;
import com.camp.camping.frame.MyService;
import com.camp.camping.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements MyService<Integer, ImageDTO> {
    @Autowired
    ImageMapper mapper;

    @Override
    public void insert(ImageDTO imageDTO) throws Exception {
        mapper.insert(imageDTO);
    }

    @Override
    public void delete(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    @Override
    public void update(ImageDTO imageDTO) throws Exception {
        mapper.update(imageDTO);
    }

    @Override
    public ImageDTO select(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    @Override
    public List<ImageDTO> selectAll() throws Exception {
        return mapper.selectAll();
    }

    public List<ImageDTO> selectByCompanyCode(int company_code) {
        return mapper.selectByCompanyCode(company_code);
    }

    public List<ImageDTO> selectByZoneCode(int zone_code) {
        return mapper.selectByZoneCode(zone_code);
    }

    public List<ImageDTO> selectBySiteCode(int site_code) {
        return mapper.selectBySiteCode(site_code);
    }

    public List<ImageDTO> selectByHomeCode(int home_code) {
        return mapper.selectByHomeCode(home_code);
    }

    public List<ImageDTO> selectByFacilityCode(int facility_code){
        return mapper.selectByFacilityCode(facility_code);
    }
}
