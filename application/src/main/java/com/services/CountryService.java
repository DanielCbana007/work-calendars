package com.services;

import domain.src.java.com.model.Country;
import src.java.com.repositories.CountryRepository;

import java.util.List;
import java.util.Optional;

public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country updateCountry(Country country) {
        if (countryRepository.existsById(country.getId())) {
            return countryRepository.update(country);
        } else {
            throw new IllegalArgumentException("Country not found");
        }
    }

    public void deleteCountry(Long id) {
        if (countryRepository.existsById(id)) {
            countryRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Country not found");
        }
    }

    public boolean existsById(Long id) {
        return countryRepository.existsById(id);
    }
}
