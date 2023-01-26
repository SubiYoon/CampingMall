package com.camp.camping.Site;

import com.camp.camping.service.SiteService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;

@SpringBootTest
public class SiteSelectTest {
    @Inject
    SiteService service;

    @Test
    void SelectByCompanyTests(){
        System.out.println(service.selectByCompany(1));
    }
}
