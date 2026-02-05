package com.example.salaryCalculation.service.impl;

import com.example.salaryCalculation.service.HolidayCalendarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.stream.Stream;

@Service
@Slf4j
public class HolidayCalendar2026ServiceImpl implements HolidayCalendarService {

    private static final Set<LocalDate> RU_2026 = Set.of(
            // Новогодние каникулы (1,2,3,4,5,6,8 января) + Рождество (7 января)
            LocalDate.of(2026, 1, 1),
            LocalDate.of(2026, 1, 2),
            LocalDate.of(2026, 1, 3),
            LocalDate.of(2026, 1, 4),
            LocalDate.of(2026, 1, 5),
            LocalDate.of(2026, 1, 6),
            LocalDate.of(2026, 1, 7),
            LocalDate.of(2026, 1, 8),

            // День защитника Отечества
            LocalDate.of(2026, 2, 23),

            // Международный женский день
            LocalDate.of(2026, 3, 8),

            // Праздник Весны и Труда
            LocalDate.of(2026, 5, 1),

            // День Победы
            LocalDate.of(2026, 5, 9),

            // День России
            LocalDate.of(2026, 6, 12),

            // День народного единства
            LocalDate.of(2026, 11, 4)
    );

    @Override
    public short countHolidays(LocalDate startDate, LocalDate endDate) {
        if (startDate.getYear() != 2026) {
            log.warn("Выбран не верный праздничный календарь за 2026. В параметрах указан год " + startDate.getDayOfYear());
            throw new IllegalArgumentException("Выбран не актульный календарь");
        }
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return (short) Stream.iterate(startDate, d -> d.plusDays(1))
                .limit(days)
                .filter(RU_2026::contains)
                .count();
    }
}
