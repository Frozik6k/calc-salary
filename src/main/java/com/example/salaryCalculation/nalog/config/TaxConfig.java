package com.example.salaryCalculation.nalog.config;

import com.example.salaryCalculation.nalog.properties.NdflProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(NdflProperties.class)
public class TaxConfig {
}
