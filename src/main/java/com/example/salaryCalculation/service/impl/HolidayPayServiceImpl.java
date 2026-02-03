package com.example.salaryCalculation.service.impl;

import com.example.salaryCalculation.dto.HolidayPayRequest;
import com.example.salaryCalculation.dto.HolidayPayResponse;
import com.example.salaryCalculation.service.HolidayPayService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class HolidayPayServiceImpl implements HolidayPayService {

    //29.3 - это среднее число календарных дней в месяце. Постановление №922. Коэффициент не менялся с 2007 года по текущий 2026 год
    private static final BigDecimal AVERAGE_CALENDAR_DAYS_PER_YEAR = new BigDecimal("351.6"); // 12 * 29.3 по ТК РФ

    @Override
    public HolidayPayResponse getHolidayPay(HolidayPayRequest request) {
        // Отпускные = (Средняя зарплата за 12 месяцев / (среднее число календарных дней в месяце * 12)) * Дней отпуска
        // Отпускные без вычета НДФЛ
        BigDecimal holidayPay = request.getAvarageSalaryMonth12()
                .divide(AVERAGE_CALENDAR_DAYS_PER_YEAR, 2,  RoundingMode.HALF_UP)
                .multiply(request.getVacationDays());
        return new HolidayPayResponse(holidayPay);
    }
}
