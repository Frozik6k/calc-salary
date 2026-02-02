package com.example.salaryCalculation.controller.impl;

import com.example.salaryCalculation.controller.HolidayPayController;
import com.example.salaryCalculation.dto.HolidayPayRequest;
import com.example.salaryCalculation.dto.HolidayPayResponse;
import com.example.salaryCalculation.service.HolidayPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/salary/holiday-pay")
public class HolidayPayControllerImpl implements HolidayPayController {

    private final HolidayPayService holidayPayService;

    @Override
    @GetMapping("/calculacte")
    public HolidayPayResponse getHolidayPay(HolidayPayRequest request) {
        return holidayPayService.getHolidayPay(request);
    }
}
