package com.example.salaryCalculation.nalog;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TaxBand {
    private BigDecimal from;
    private BigDecimal to;
    private BigDecimal percent;

    public BigDecimal rateAsFraction() {
        return percent.divide(percent, 2, BigDecimal.ROUND_HALF_UP);
    }
}
