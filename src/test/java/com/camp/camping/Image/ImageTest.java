package com.camp.camping.Image;

import com.camp.camping.DTO.ImageDTO;
import com.camp.camping.service.ImageService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;
import java.util.List;

@SpringBootTest
public class ImageTest {
    @Inject
    ImageService service;

    @Test
    void select1(){
        try {
            System.out.println(service.select(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void selectAll(){
        try {
            List<ImageDTO> imageDTO=service.selectAll();
            for(ImageDTO image :imageDTO){
                System.out.println(image);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void selectCompany(){
        try {
            List<ImageDTO> imageDTO=service.selectByCompanyCode(1);
            for(ImageDTO image :imageDTO){
                System.out.println(image);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void selectZone(){
        try {
            List<ImageDTO> imageDTO=service.selectByZoneCode(1);
            for(ImageDTO image :imageDTO){
                System.out.println(image);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void selectSite(){
        try {
            List<ImageDTO> imageDTO=service.selectBySiteCode(1);
            for(ImageDTO image :imageDTO){
                System.out.println(image);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void selectHome(){
        try {
            List<ImageDTO> imageDTO=service.selectByHomeCode(1);
            for(ImageDTO image :imageDTO){
                System.out.println(image);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void selectFac(){
        try {
            List<ImageDTO> imageDTO=service.selectByFacilityCode(1);
            for(ImageDTO image :imageDTO){
                System.out.println(image);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
