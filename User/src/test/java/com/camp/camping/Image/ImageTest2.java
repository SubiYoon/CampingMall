package com.camp.camping.Image;

import com.camp.camping.DTO.ImageDTO;
import com.camp.camping.service.ImageService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;

@SpringBootTest
public class ImageTest2 {
    @Inject
    ImageService service;

    @Test
    void insertTest() {
        try {
            service.insert(new ImageDTO(1, 1, 1, 0, 0, 0, "imageTest"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void deleteTest() {
        try {
            service.delete(7);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateTest() {
        try {
            service.update(new ImageDTO(8, 1, 1, 0, 0, 0, "imageTest.img"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
