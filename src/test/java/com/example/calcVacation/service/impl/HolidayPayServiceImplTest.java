package com.example.calcVacation.service.impl;

import com.example.salaryCalculation.dto.HolidayPayRequest;
import com.example.salaryCalculation.service.NdflService;
import com.example.salaryCalculation.service.impl.HolidayPayServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HolidayPayServiceImplTest {

    @Mock
    private NdflService ndflService;

    @InjectMocks
    private HolidayPayServiceImpl holidayPayService;

    @Test
    void returnsIncomeWhenTaxIsHigherThanIncome() {
        HolidayPayRequest request = new HolidayPayRequest();
        request.setAvarageSalaryMonth12(new BigDecimal("36530"));
        request.setVacationDays((short) 10);

        when(ndflService.calculate(any(BigDecimal.class))).thenReturn(new BigDecimal("130.00"));

        assertThat(holidayPayService.getHolidayPay(request).getPay())
                .isEqualByComparingTo(new BigDecimal("870.00"));
    }

}
