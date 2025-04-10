package infrastructure.src.main.java.com.repositories;

import infrastructure.src.main.java.com.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CountryEntityRepository extends JpaRepository<CountryEntity, Long> {

    Optional<CountryEntity> findByName(String name);
}