package com.example.salaryCalculation.controller.impl;

import com.example.salaryCalculation.controller.LeavePayController;
import com.example.salaryCalculation.dto.LeavePayRequest;
import com.example.salaryCalculation.dto.LeavePayResponse;
import com.example.salaryCalculation.service.LeavePayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/salary/leave-pay")
public class LeavePayControllerImpl implements LeavePayController {

    private final LeavePayService leavePayService;

    @Override
    @GetMapping("/calculacte")
    public LeavePayResponse getLeavePay(@RequestBody LeavePayRequest request) {
        return leavePayService.getLeavePay(request);
    }
}
