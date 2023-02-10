package com.camp.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.camp.admin.DTO.ImageDTO;
import com.camp.admin.frame.MyService;
import com.camp.admin.mapper.ImageMapper;
import com.camp.admin.utility.SaveFile;

@Service
public class ImageService implements MyService<Integer, ImageDTO> {
    @Value("${imagesdir}")
    String imagesdir;

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

    public void updateimage(ImageDTO imageDTO, String first_image_file) throws Exception {
        imageDTO = checkName(imageDTO);
        int result = mapper.updateimage(imageDTO);
        if (result == 1) {
            result = mapper.selectFile(first_image_file);
            if (result == 0) {
                SaveFile.deleteFile(imagesdir, first_image_file);
            }
        }
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

    public List<ImageDTO> selectByFacilityCode(int facility_code) {
        return mapper.selectByFacilityCode(facility_code);
    }

    public ImageDTO selecOnetByHomeCode(int home_code) {
        return mapper.selecOnetByHomeCode(home_code);
    }

    public void zoneUpdate(ImageDTO imageDTO) throws Exception {
        mapper.zoneUpdate(imageDTO);
    }

    public void selectFile(String image_file) throws Exception {
        mapper.selectFile(image_file);
    }

    public ImageDTO checkName(ImageDTO imageDTO) throws Exception {
        int result = mapper.selectFile(imageDTO.getImage_file());
        if (result > 0) {
            String image_file = imageDTO.getImage_file();
            String arr[] = image_file.split("\\.");
            imageDTO.setImage_file(arr[0] + result + "." + arr[1]);

        }
        return imageDTO;
    }

    @Override
    public void update(ImageDTO v) throws Exception {
        mapper.update(v);
    }

}
