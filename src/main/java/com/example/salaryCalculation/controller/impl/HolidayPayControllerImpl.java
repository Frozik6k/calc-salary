package com.example.salaryCalculation.controller.impl;

import com.example.salaryCalculation.controller.HolidayPayController;
import com.example.salaryCalculation.dto.HolidayPayRequest;
import com.example.salaryCalculation.dto.HolidayPayResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/salary/holiday-pay")
public class HolidayPayControllerImpl implements HolidayPayController {
    @Override
    public HolidayPayResponse getHolidayPayDto(HolidayPayRequest request) {
        return null;
    }
}
