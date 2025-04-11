package src.java.com.repositories;

import domain.src.java.com.model.Holiday;

import java.util.List;
import java.util.Optional;

public interface HolidayRepository {

    Holiday save(Holiday holiday);

    Optional<Holiday> findById(Long id);

    List<Holiday> findAll();

    Holiday update(Holiday holiday);

    void deleteById(Long id);

    boolean existsByName(String name);
}