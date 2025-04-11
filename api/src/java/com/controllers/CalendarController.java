package api.src.java.com.controllers;

import domain.src.java.com.model.Holiday;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calendars")
public class CalendarController {

    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping("/{countryId}")
    public ResponseEntity<Holiday> createCalendar(@PathVariable Long countryId, @RequestBody Holiday holiday) {
        Holiday createdHoliday = calendarService.createCalendar(countryId, holiday);

        if (createdHoliday != null) {
            return ResponseEntity.status(201).body(createdHoliday);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{countryId}")
    public ResponseEntity<List<Holiday>> getHolidaysByCountry(@PathVariable Long countryId) {
        List<Holiday> holidays = calendarService.getHolidaysByCountry(countryId);

        if (holidays != null && !holidays.isEmpty()) {
            return ResponseEntity.ok(holidays);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
