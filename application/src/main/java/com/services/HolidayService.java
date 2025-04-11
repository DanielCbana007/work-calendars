package application.src.main.java.com.services;

import application.src.main.java.com.usecases.HolidayDateCalculator;
import domain.src.java.com.model.Holiday;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HolidayService {

    private final HolidayDateCalculator holidayDateCalculator;

    public HolidayService(HolidayDateCalculator holidayDateCalculator) {
        this.holidayDateCalculator = holidayDateCalculator;
    }

    public LocalDate getHolidayDate(Holiday holiday, int year) {
        return holidayDateCalculator.calculateDate(holiday, year);
    }
}
