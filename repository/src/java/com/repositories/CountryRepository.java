package src.java.com.repositories;

import domain.src.java.com.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {

    Country save(Country country);

    Optional<Country> findById(Long id);

    List<Country> findAll();

    Country update(Country country);

    void deleteById(Long id);

    boolean existsById(Long id);
}