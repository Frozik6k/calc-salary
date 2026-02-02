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
        BigDecimal tax = BigDecimal.ZERO;

        for (TaxBand taxBand : ndflProperties.getTaxBands()) {
            //TODO посчитать ндфл
        }
        return null;
    }
}
