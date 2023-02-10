package com.camp.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.camp.admin.DTO.ImageDTO;
import com.camp.admin.mapper.ImageMapper;
import com.camp.admin.utility.SaveFile;

@Service
public class ImageService{
    @Value("${imagesdir}")
    String imagesdir;

    @Autowired
    ImageMapper mapper;

    public void insert(MultipartFile mf, ImageDTO imageDTO) throws Exception {
        String fileName =mf.getOriginalFilename();
        int fileCount = 1;
        List<ImageDTO> imgAll = mapper.selectAll();

        for(int i=0; i<imgAll.size(); i++){
            if(imgAll.get(i).getImage_file().equals(fileName)){
                String[] filearr = mf.getOriginalFilename().split("\\.");
                fileName = filearr[0] + "(" + fileCount +")" + "." + filearr[1];
                fileCount++;
                i = 0;
            }
        }
        imageDTO.setImage_file(fileName);
        SaveFile.saveFile(mf, imagesdir, fileName) ;
        
        mapper.insert(imageDTO);
    }

    
    public void delete(Integer integer) throws Exception {
        mapper.delete(integer);
    }

    
    public ImageDTO select(Integer integer) throws Exception {
        return mapper.select(integer);
    }

    
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
    
    public void update(MultipartFile mf, ImageDTO imageDTO) throws Exception {
        String fileName =mf.getOriginalFilename();
        int fileCount = 1;
        List<ImageDTO> imgAll = mapper.selectAll();
        
        SaveFile.deleteFile(imagesdir, imageDTO.getImage_file());
        for(int i=0; i<imgAll.size(); i++){
            if(imgAll.get(i).getImage_file().equals(fileName)){
                String[] filearr = mf.getOriginalFilename().split("\\.");
                fileName = filearr[0] + "(" + fileCount + ")" + "." + filearr[1];
                fileCount++;
                i = 0;
            }
        }
        imageDTO.setImage_file(fileName);
        SaveFile.saveFile(mf, imagesdir, fileName) ;
        mapper.update(imageDTO);
    }

}
