package com.camp.camping.Site;

import com.camp.camping.service.SiteService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.inject.Inject;

@SpringBootTest
public class SiteSelectTest {
    @Inject
    SiteService service;

    @Test
    @Disabled
    void findAvailableSite(){
        try {
            System.out.println(service.AvailableSite(1,"2023-03-02","2023-03-03"));
        } catch (Exception e) {
            System.out.println("ㅈ버그터짐");
        }
    }
    @Test
    void findCompany(){
        System.out.println(service.findCompanyCode(10));
    }
    @Test
    @Disabled
    void SelectByCompanyTests(){
        System.out.println(service.selectByCompany(1));
    }
}
