package com.usecases;

import domain.src.java.com.model.Holiday;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

@Component
public class HolidayDateCalculator {

    public LocalDate calculateDate(Holiday holiday, int year) {
        // Validación básica opcional (por si quieres asegurarte de no romper nada)
        if (holiday.getMonth() < 1 || holiday.getMonth() > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }

        LocalDate baseDate;

        switch (holiday.getIdType()) {
            case 1:
                baseDate = LocalDate.of(year, holiday.getMonth(), holiday.getDay());
                break;

            case 2:
                baseDate = moveToNextMonday(LocalDate.of(year, holiday.getMonth(), holiday.getDay()));
                break;

            case 3:
                baseDate = calculateEasterSunday(year).plusDays(holiday.getEasterDays());
                break;

            case 4:
                baseDate = moveToNextMonday(calculateEasterSunday(year).plusDays(holiday.getEasterDays()));
                break;

            default:
                throw new IllegalArgumentException("Unknown holiday type: " + holiday.getIdType());
        }

        return baseDate;
    }

    private LocalDate calculateEasterSunday(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        int totalDays = d + e + 7;

        return LocalDate.of(year, 3, 15).plusDays(totalDays);
    }

    private LocalDate moveToNextMonday(LocalDate date) {
        return date.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
    }
}
