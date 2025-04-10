package application.src.main.java.com.services;

import domain.src.java.com.model.Holiday;
import infrastructure.src.main.java.com.entities.HolidayEntity;
import infrastructure.src.main.java.com.repositories.HolidayEntityRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class HolidayService {

    private HolidayEntityRepository holidayEntityRepository;

    public Holiday createHoliday(Holiday holiday) {
        HolidayEntity holidayEntity = mapToEntity(holiday);
        holidayEntity = holidayEntityRepository.save(holidayEntity);
        return mapToModel(holidayEntity);
    }

    public List<Holiday> getAllHolidays() {
        List<HolidayEntity> holidayEntities = holidayEntityRepository.findAll();
        List<Holiday> holidays = new ArrayList<>();
        for (HolidayEntity holidayEntity : holidayEntities) {
            holidays.add(mapToModel(holidayEntity));
        }
        return holidays;
    }

    public Optional<Holiday> getHolidayById(Long id) {
        Optional<HolidayEntity> holidayEntity = holidayEntityRepository.findById(id);
        return holidayEntity.map(this::mapToModel);
    }

    public Holiday updateHoliday(Long id, Holiday holiday) {
        if (holidayEntityRepository.existsById(id)) {
            HolidayEntity holidayEntity = mapToEntity(holiday);
            holidayEntity.setId(id);
            holidayEntity = holidayEntityRepository.save(holidayEntity);
            return mapToModel(holidayEntity);
        }
        return null;
    }

    public void deleteHoliday(Long id) {
        if (holidayEntityRepository.existsById(id)) {
            holidayEntityRepository.deleteById(id);
        }
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
