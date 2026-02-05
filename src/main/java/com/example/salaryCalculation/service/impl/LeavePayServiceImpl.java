package com.example.salaryCalculation.service.impl;

import com.example.salaryCalculation.dto.LeavePayRequest;
import com.example.salaryCalculation.dto.LeavePayResponse;
import com.example.salaryCalculation.service.LeavePayServiceStrategy;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class LeavePayServiceImpl implements LeavePayServiceStrategy {

    @Override
    public LeavePayResponse getLeavePay(LeavePayRequest request) {
        // Отпускные = (Средняя зарплата за 12 месяцев / (среднее число календарных дней в месяце * 12)) * Дней отпуска
        // Отпускные без вычета НДФЛ
        BigDecimal leavePay = request.getAvarageSalaryMonth12()
                .divide(AVERAGE_CALENDAR_DAYS_PER_YEAR, 2, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(request.getVacationDays()));
        return new LeavePayResponse(leavePay);
    }

    @Override
    public boolean support(LeavePayRequest request) {
        return request.getVacationStart() == null;
    }
}
