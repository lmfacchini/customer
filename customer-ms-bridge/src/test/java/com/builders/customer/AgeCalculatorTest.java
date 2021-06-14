package com.builders.customer;

import com.builders.customer.core.to.AgeTO;
import com.builders.customer.core.utils.AgeCalculator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AgeCalculatorTest {


    @Test
    public void calculateAge()   {
        BigDecimal bd = new BigDecimal(1000);
        bd = bd.multiply(new BigDecimal(60))
                .multiply(new BigDecimal(60))
                .multiply(new BigDecimal(24))
                .multiply(new BigDecimal(30))
                .multiply(new BigDecimal(14));

        Date date = new Date(System.currentTimeMillis() - bd.longValue());
        System.out.println(date);
        AgeTO age = AgeCalculator.calculateAge(date);
        assertNotNull(age);
        assertEquals(1, age.getYears());
    }
}
