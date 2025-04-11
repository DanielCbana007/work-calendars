package application.src.main.java.com.usecases;

import domain.src.java.com.model.Holiday;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

@Component
public class HolidayDateCalculator {

    public LocalDate calculateDate(Holiday holiday, int year) {
        return switch (holiday.getIdType()) {
            case 1 -> LocalDate.of(
                    year,
                    Month.valueOf(holiday.getMonth().toUpperCase()),
                    holiday.getDay()
            );
            case 2 -> moveToNextMonday(LocalDate.of(
                    year,
                    Month.valueOf(holiday.getMonth().toUpperCase()),
                    holiday.getDay()
            ));
            case 3 -> calculateEasterSunday(year).plusDays((long) holiday.getEasterDays());
            case 4 -> moveToNextMonday(calculateEasterSunday(year).plusDays((long) holiday.getEasterDays()));
            default -> throw new IllegalArgumentException("Unknown holiday type: " + holiday.getIdType());
        };
    }

    private LocalDate calculateEasterSunday(int year) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        int totalDays = d + e + 7;

        return LocalDate.of(year, Month.MARCH, 15).plusDays(totalDays);
    }

    private LocalDate moveToNextMonday(LocalDate date) {
        return date.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
    }
}
