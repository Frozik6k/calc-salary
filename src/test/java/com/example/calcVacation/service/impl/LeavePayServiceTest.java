package com.example.calcVacation.service.impl;

import com.example.salaryCalculation.Application;
import com.example.salaryCalculation.dto.LeavePayRequest;
import com.example.salaryCalculation.service.HolidayCalendarService;
import com.example.salaryCalculation.service.LeavePayService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = Application.class)
class LeavePayServiceTest {

    @Autowired
    private LeavePayService leavePayService;

    @MockBean
    private HolidayCalendarService holidayCalendarService;

    @Test
    void thenLeavePayServiceImplGetLeavePay() {
        LeavePayRequest request = new LeavePayRequest();
        request.setAvarageSalaryMonth12(new BigDecimal("950000.00"));
        request.setVacationDays((short) 10);

        assertThat(leavePayService.getLeavePay(request).getPay())
                .isEqualByComparingTo(new BigDecimal("27019.30"));
    }

    @Test
    void thenLeaveWithHolidayPayServiceImplGetLeavePay() {
        LeavePayRequest request = new LeavePayRequest();
        request.setAvarageSalaryMonth12(new BigDecimal("950000.00"));
        request.setVacationDays((short) 12);
        request.setVacationStart(LocalDate.of(2026, 5, 10));

        Mockito.when(holidayCalendarService.countHolidays(
                        LocalDate.of(2026, 5, 10), LocalDate.of(2026, 5, 21)
                ))
                .thenReturn((short) 2);

        assertThat(leavePayService.getLeavePay(request).getPay())
                .isEqualByComparingTo(new BigDecimal("27019.30"));


    }

}
