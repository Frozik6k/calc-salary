package com.example.salaryCalculation.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HolidayPayRequest {
    private BigDecimal avarageSalaryMonth12;
    private short vacationDays;
}
