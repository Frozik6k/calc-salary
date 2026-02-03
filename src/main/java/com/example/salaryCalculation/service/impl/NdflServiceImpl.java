package com.example.salaryCalculation.service.impl;

import com.example.salaryCalculation.nalog.TaxBand;
import com.example.salaryCalculation.nalog.properties.NdflProperties;
import com.example.salaryCalculation.service.NdflService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class NdflServiceImpl implements NdflService {

    private final NdflProperties ndflProperties;

    @Override
    public BigDecimal calculate(BigDecimal income) {
        return ndflProperties.getTaxBands()
                .stream()
                .map(taxBand -> {
                    BigDecimal upper = (taxBand.getTo() == null ? income : income.min(taxBand.getTo()));
                    BigDecimal part = upper.subtract(taxBand.getFrom()).max(BigDecimal.ZERO);
                    return part.multiply(taxBand.rateAsFraction());
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }
}
