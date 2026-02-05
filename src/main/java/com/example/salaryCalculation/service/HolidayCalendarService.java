package com.example.salaryCalculation.service;

import java.time.LocalDate;

public interface HolidayCalendarService {
    short countHolidays(LocalDate startDate, LocalDate endDate);
}
