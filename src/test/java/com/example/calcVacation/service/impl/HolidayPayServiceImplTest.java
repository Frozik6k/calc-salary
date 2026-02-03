package com.example.calcVacation.service.impl;

import com.example.salaryCalculation.Application;
import com.example.salaryCalculation.dto.HolidayPayRequest;
import com.example.salaryCalculation.service.HolidayPayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
class HolidayPayServiceImplTest {

    @Autowired
    private HolidayPayService holidayPayService;

    @Test
    void testGetHolidayPay() {
        HolidayPayRequest request = new HolidayPayRequest();
        request.setAvarageSalaryMonth12(new BigDecimal("950000.00"));
        request.setVacationDays(new BigDecimal("10"));

        assertThat(holidayPayService.getHolidayPay(request).getPay())
                .isEqualByComparingTo(new BigDecimal("27019.30"));
    }

}
