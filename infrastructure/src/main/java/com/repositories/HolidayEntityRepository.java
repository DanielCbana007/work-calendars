package infrastructure.src.main.java.com.repositories;

import infrastructure.src.main.java.com.entities.HolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HolidayEntityRepository extends JpaRepository<HolidayEntity, Long> {

    List<HolidayEntity> findByCountryId(Long countryId);

    Optional<HolidayEntity> findByNameAndCountryId(String name, Long countryId);
}
