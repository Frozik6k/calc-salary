package com.example.salaryCalculation.service.impl;

import com.example.salaryCalculation.dto.HolidayPayRequest;
import com.example.salaryCalculation.dto.HolidayPayResponse;
import com.example.salaryCalculation.service.HolidayPayService;
import com.example.salaryCalculation.service.NdflService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class HolidayPayServiceImpl implements HolidayPayService {

    // Среднее число календарных дней в месяце. Постановление №922. Коэффициент не менялся с 2007 года по текущий 2026 год
    private static final BigDecimal AVERAGE_CALENDAR_DAYS_PER_YEAR = BigDecimal.valueOf(365.3);

    private final NdflService ndflService;

    @Override
    public HolidayPayResponse getHolidayPay(HolidayPayRequest request) {
        // Отпускные = (Средняя зарплата за 12 месяцев / среднее число календарных дней в месяце) * Дней отпуска
        BigDecimal pay = request.getAvarageSalaryMonth12()
                .divide(AVERAGE_CALENDAR_DAYS_PER_YEAR, 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(request.getVacationDays()));
        BigDecimal tax = ndflService.calculate(request.getAvarageSalaryMonth12());
        return new HolidayPayResponse(income.subtract(tax));
    }
}
