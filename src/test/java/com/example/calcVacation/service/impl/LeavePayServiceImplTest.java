package com.example.calcVacation.service.impl;

import com.example.salaryCalculation.Application;
import com.example.salaryCalculation.dto.LeavePayRequest;
import com.example.salaryCalculation.service.LeavePayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
class LeavePayServiceImplTest {

    @Autowired
    private LeavePayService leavePayService;

    @Test
    void testGetHolidayPay() {
        LeavePayRequest request = new LeavePayRequest();
        request.setAvarageSalaryMonth12(new BigDecimal("950000.00"));
        request.setVacationDays((short) 10);

        assertThat(leavePayService.getHolidayPay(request).getPay())
                .isEqualByComparingTo(new BigDecimal("27019.30"));
    }

}
