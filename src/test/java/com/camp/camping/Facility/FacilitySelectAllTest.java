package com.camp.camping.Facility;

import com.camp.camping.service.FacilityService;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FacilitySelectAllTest {
    @Inject
    FacilityService service;
    @Test
    void selectAll(){
        try {
            System.out.println(service.selectAll());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void select(){
        try {
            System.out.println(service.select(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
