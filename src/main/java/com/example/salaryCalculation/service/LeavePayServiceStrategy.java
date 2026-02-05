package com.example.salaryCalculation.service;

import com.example.salaryCalculation.dto.LeavePayRequest;

public interface LeavePayServiceStrategy extends LeavePayService {
    boolean support(LeavePayRequest request);
}
