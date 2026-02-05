package com.example.salaryCalculation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class LeavePayResponse {
    private BigDecimal pay;
}
