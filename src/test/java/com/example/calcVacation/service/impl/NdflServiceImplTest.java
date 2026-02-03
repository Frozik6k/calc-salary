package com.example.calcVacation.service.impl;

import com.example.salaryCalculation.nalog.TaxBand;
import com.example.salaryCalculation.nalog.properties.NdflProperties;
import com.example.salaryCalculation.service.impl.NdflServiceImpl;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NdflServiceImplTest {

    @Test
    void calculateAppliesProgressiveBandsAndCapsAtIncome() {
        NdflServiceImpl service = new NdflServiceImpl(propertiesWithBands(
                taxBand("0", "100", "13"),
                taxBand("100", "200", "15"),
                taxBand("200", null, "20")
        ));
        BigDecimal tax = service.calculate(new BigDecimal("150"));
        assertThat(tax).isEqualByComparingTo("20.50");
    }

    @Test
    void calculateReturnsZeroForBandsAboveIncome() {
        NdflServiceImpl service = new NdflServiceImpl(propertiesWithBands(
                taxBand("100", "200", "13")
        ));

        BigDecimal tax = service.calculate(new BigDecimal("50"));

        assertThat(tax).isEqualByComparingTo("0");
    }

    private NdflProperties propertiesWithBands(TaxBand... bands) {
        NdflProperties properties = new NdflProperties();
        properties.setTaxBands(List.of(bands));
        return properties;
    }

    private TaxBand taxBand(String from, String to, String percent) {
        TaxBand band = new TaxBand();
        band.setFrom(new BigDecimal(from));
        band.setTo(to == null ? null : new BigDecimal(to));
        band.setPercent(new BigDecimal(percent));
        return band;
    }
}