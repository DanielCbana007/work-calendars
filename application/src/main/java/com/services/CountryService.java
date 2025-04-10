package application.src.main.java.com.services;

import domain.src.java.com.model.Country;
import infrastructure.src.main.java.com.entities.CountryEntity;
import infrastructure.src.main.java.com.repositories.CountryEntityRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CountryService {

    private CountryEntityRepository countryEntityRepository;

    public Country createCountry(Country country) {
        CountryEntity countryEntity = mapToEntity(country);
        countryEntity = countryEntityRepository.save(countryEntity);
        return mapToModel(countryEntity);
    }

    public List<Country> getAllCountries() {
        List<CountryEntity> countryEntities = countryEntityRepository.findAll();
        return countryEntities.stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    public Optional<Country> getCountryById(Long id) {
        Optional<CountryEntity> countryEntity = countryEntityRepository.findById(id);
        return countryEntity.map(this::mapToModel);
    }

    public Country updateCountry(Long id, Country country) {
        if (countryEntityRepository.existsById(id)) {
            CountryEntity countryEntity = mapToEntity(country);
            countryEntity.setId(id);
            countryEntity = countryEntityRepository.save(countryEntity);
            return mapToModel(countryEntity);
        }
        return null;
    }

    public void deleteCountry(Long id) {
        countryEntityRepository.deleteById(id);
    }

    private Country mapToModel(CountryEntity countryEntity) {
        return new Country(
                countryEntity.getId(),
                countryEntity.getName()
        );
    }

    private CountryEntity mapToEntity(Country country) {
        return new CountryEntity(
                country.getId(),
                country.getName()
        );
    }
}
