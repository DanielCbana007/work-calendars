package application.src.main.java.com.services;

import domain.src.java.com.model.Holiday;
import infrastructure.src.main.java.com.entities.HolidayEntity;
import infrastructure.src.main.java.com.repositories.HolidayEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CalendarService {

    private HolidayEntityRepository holidayEntityRepository;

    public Holiday createCalendar(Long countryId, Holiday holiday) {

        HolidayEntity holidayEntity = mapToEntity(holiday);
        holidayEntity.setCountryId(countryId);
        holidayEntity = holidayEntityRepository.save(holidayEntity);
        return mapToModel(holidayEntity);
    }

    public List<Holiday> getHolidaysByCountry(Long countryId) {
        List<HolidayEntity> holidayEntities = holidayEntityRepository.findByCountryId(countryId);
        return holidayEntities.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    private Holiday mapToModel(HolidayEntity holidayEntity) {
        return new Holiday(
                holidayEntity.getId(),
                holidayEntity.getCountryId(),
                holidayEntity.getName(),
                holidayEntity.getDay(),
                holidayEntity.getMonth(),
                holidayEntity.getEasterOffsetDays(),
                holidayEntity.getTypeId(),
                holidayEntity.getDate()
        );
    }

    private HolidayEntity mapToEntity(Holiday holiday) {
        return new HolidayEntity(
                holiday.getId(),
                holiday.getCountryId(),
                holiday.getName(),
                holiday.getDay(),
                holiday.getMonth(),
                holiday.getEasterOffsetDays(),
                holiday.getTypeId(),
                holiday.getDate()
        );
    }
}
