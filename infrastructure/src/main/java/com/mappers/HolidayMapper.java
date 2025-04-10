package infrastructure.src.main.java.com.mappers;

import domain.src.java.com.model.Holiday;
import infrastructure.src.main.java.com.entities.HolidayEntity;
import org.springframework.stereotype.Component;

@Component
public class HolidayMapper {

    public Holiday toModel(HolidayEntity holidayEntity) {
        if (holidayEntity == null) {
            return null;
        }

        Holiday holiday = new Holiday(holidayEntity.getId(), holidayEntity.getName(), holidayEntity.getDate(), holidayEntity.getCountryId());
        holiday.setId(holidayEntity.getId());
        holiday.setCountryId(holidayEntity.getCountryId());
        holiday.setName(holidayEntity.getName());
        holiday.setDay(holidayEntity.getDay());
        holiday.setMonth(holidayEntity.getMonth());
        holiday.setEasterOffsetDays(holidayEntity.getEasterOffsetDays());
        holiday.setTypeId(holidayEntity.getTypeId());
        holiday.setDate(holidayEntity.getDate());
        return holiday;
    }

    public HolidayEntity toEntity(Holiday holiday) {
        if (holiday == null) {
            return null;
        }

        HolidayEntity holidayEntity = new HolidayEntity();
        holidayEntity.setId(holiday.getId());
        holidayEntity.setCountryId(holiday.getCountryId());
        holidayEntity.setName(holiday.getName());
        holidayEntity.setDay(holiday.getDay());
        holidayEntity.setMonth(holiday.getMonth());
        holidayEntity.setEasterOffsetDays(holiday.getEasterOffsetDays());
        holidayEntity.setTypeId(holiday.getTypeId());
        holidayEntity.setDate(holiday.getDate());
        return holidayEntity;
    }
}
