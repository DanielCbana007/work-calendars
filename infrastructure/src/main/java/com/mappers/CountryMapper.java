package infrastructure.src.main.java.com.mappers;

import domain.src.java.com.model.Country;
import infrastructure.src.main.java.com.entities.CountryEntity;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public Country toModel(CountryEntity countryEntity) {
        if (countryEntity == null) {
            return null;
        }

        Country country = new Country();
        country.setId(countryEntity.getId());
        country.setName(countryEntity.getName());
        return country;
    }

    public CountryEntity toEntity(Country country) {
        if (country == null) {
            return null;
        }

        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setId(country.getId());
        countryEntity.setName(country.getName());
        return countryEntity;
    }
}