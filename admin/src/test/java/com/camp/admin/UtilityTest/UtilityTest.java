package com.camp.admin.UtilityTest;

import com.camp.admin.utility.Utility;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilityTest {
    @Test
    void Rate(){
        System.out.println(Utility.RateOfIncrease(100,500));
        System.out.println(Utility.RateOfIncrease(0,500));
        System.out.println(Utility.RateOfIncrease(0,0));
        System.out.println(Utility.RateOfIncrease(500,0));
        System.out.println(Utility.RateOfIncrease(100000,1));
    }

}
