package com.example.salaryCalculation.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class LeavePayRequest {
    private BigDecimal avarageSalaryMonth12;
    private short vacationDays;
    private LocalDate vacationStart;
}
