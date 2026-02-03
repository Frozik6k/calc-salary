package com.example.calcVacation.nalog.properties;

import com.example.salaryCalculation.Application;
import com.example.salaryCalculation.nalog.TaxBand;
import com.example.salaryCalculation.nalog.properties.NdflProperties;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest(classes = Application.class)
public class NdflPropertiesTest {

    @Autowired
    private NdflProperties ndflProperties;

    @Test
    void taxBandsShouldBeContinuousAndNonOverlapping() {
        List<TaxBand> taxBands = ndflProperties.getTaxBands();
        Assertions.assertThat(taxBands)
                .as("Tax bands должны быть определены")
                .isNotNull()
                .isNotEmpty();

        for (int i = 0; i < taxBands.size(); i++) {
            TaxBand band = taxBands.get(i);
            Assertions.assertThat(band.getFrom())
                    .as("Tax band from должен быть задан")
                    .isNotNull();

            if (band.getTo() != null) {
                Assertions.assertThat(band.getTo())
                        .as("Tax band to должен быть больше from")
                        .isGreaterThan(band.getFrom());
            }

            if (i > 0) {
                TaxBand previous = taxBands.get(i - 1);
                Assertions.assertThat(previous.getTo())
                        .as("Последний диапазон не может иметь to кроме последнего")
                        .isNotNull();

                Assertions.assertThat(previous.getTo().compareTo(band.getFrom()))
                        .as("Диапазоны должны идти подряд без перекрытий и пробелов")
                        .isEqualTo(0);
            }
        }

        TaxBand lastBand = taxBands.get(taxBands.size() - 1);
        Assertions.assertThat(lastBand.getTo())
                .as("Последний диапазон должен быть открыт, чтобы не было не охваченных сумм")
                .isNull();

        Assertions.assertThat(taxBands.get(0).getFrom())
                .as("Первый диапазон должен начинаться с 0")
                .isEqualTo(BigDecimal.ZERO);
    }
}
