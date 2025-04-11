package com.services;
import com.usecases.HolidayDateCalculator;
import domain.src.java.com.model.Holiday;
import org.springframework.stereotype.Service;
import src.java.com.repositories.HolidayRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;
    private final HolidayDateCalculator holidayDateCalculator;

    public HolidayService(HolidayRepository holidayRepository,
                          HolidayDateCalculator holidayDateCalculator) {
        this.holidayRepository = holidayRepository;
        this.holidayDateCalculator = holidayDateCalculator;
    }

    public Holiday createHoliday(Holiday holiday) {
        // Aquí podrías validar existencia u otras reglas de negocio
        if (holidayRepository.existsByName(holiday.getName())) {
            throw new IllegalArgumentException("Holiday with this name already exists");
        }
        return holidayRepository.save(holiday);
    }

    public Optional<Holiday> getHoliday(Long id) {
        return holidayRepository.findById(id);
    }

    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    public Holiday updateHoliday(Holiday holiday) {
        if (!holidayRepository.findById(holiday.getId()).isPresent()) {
            throw new IllegalArgumentException("Holiday not found");
        }
        return holidayRepository.update(holiday);
    }

    public void deleteHoliday(Long id) {
        holidayRepository.deleteById(id);
    }

    public LocalDate getHolidayDate(Holiday holiday, int year) {
        return holidayDateCalculator.calculateDate(holiday, year);
    }
}

