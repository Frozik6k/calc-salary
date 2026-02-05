package com.example.salaryCalculation.service;

import com.example.salaryCalculation.dto.LeavePayRequest;
import com.example.salaryCalculation.dto.LeavePayResponse;

import java.math.BigDecimal;

public interface LeavePayService {
    //29.3 - это среднее число календарных дней в месяце. Постановление №922. Коэффициент не менялся с 2007 года по текущий 2026 год
    static final BigDecimal AVERAGE_CALENDAR_DAYS_PER_YEAR = new BigDecimal("351.6"); // 12 * 29.3 по ТК РФ

    // Производится расчет отпускных выплат
    LeavePayResponse getLeavePay(LeavePayRequest request);
}
