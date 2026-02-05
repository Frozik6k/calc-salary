package com.example.salaryCalculation.service.impl;

import com.example.salaryCalculation.dto.LeavePayRequest;
import com.example.salaryCalculation.dto.LeavePayResponse;
import com.example.salaryCalculation.service.LeavePayService;
import com.example.salaryCalculation.service.LeavePayServiceStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class LeavePayServiceRouter implements LeavePayService {

    private final List<LeavePayServiceStrategy> strategies;

    @Override
    public LeavePayResponse getLeavePay(LeavePayRequest request) {
        return strategies.stream()
                .filter(strategy -> strategy.support(request))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Нет подходящей стратегии для LeavePayRequest"))
                .getLeavePay(request);
    }
}
