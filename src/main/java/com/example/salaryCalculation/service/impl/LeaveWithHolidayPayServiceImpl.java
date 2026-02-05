package com.example.salaryCalculation.service.impl;

import com.example.salaryCalculation.dto.LeavePayRequest;
import com.example.salaryCalculation.dto.LeavePayResponse;
import com.example.salaryCalculation.service.HolidayCalendarService;
import com.example.salaryCalculation.service.LeavePayServiceStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class LeaveWithHolidayPayServiceImpl implements LeavePayServiceStrategy {

    private final HolidayCalendarService holidayCalendarService;

    @Override
    public LeavePayResponse getLeavePay(LeavePayRequest request) {

        short holidays = holidayCalendarService.countHolidays(request.getVacationStart(), request.getVacationStart().plusDays(request.getVacationDays() - 1));

        // Отпускные = (Средняя зарплата за 12 месяцев / (среднее число календарных дней в месяце * 12)) * (Дней отпуска - праздничные дни)
        // Праздничные дни не входят в календарные дни, поэтому в расчет не берутся
        // Отпускные без вычета НДФЛ
        BigDecimal leavePay = request.getAvarageSalaryMonth12()
                .divide(AVERAGE_CALENDAR_DAYS_PER_YEAR, 2, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(request.getVacationDays() - holidays));
        return new LeavePayResponse(leavePay);
    }

    @Override
    public boolean support(LeavePayRequest request) {
        return request.getVacationStart() != null;
    }
}
