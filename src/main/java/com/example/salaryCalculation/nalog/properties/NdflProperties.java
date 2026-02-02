package com.example.salaryCalculation.nalog.properties;

import com.example.salaryCalculation.nalog.TaxBand;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "tax.ndfl")
@Data
public class NdflProperties {
    private List<TaxBand> taxBands;
}
