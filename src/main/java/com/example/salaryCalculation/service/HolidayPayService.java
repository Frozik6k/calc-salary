package com.example.salaryCalculation.service;

import com.example.salaryCalculation.dto.HolidayPayRequest;
import com.example.salaryCalculation.dto.HolidayPayResponse;

public interface HolidayPayService {
    // Производится расчет отпускных выплат
    HolidayPayResponse getHolidayPay(HolidayPayRequest request);
}
