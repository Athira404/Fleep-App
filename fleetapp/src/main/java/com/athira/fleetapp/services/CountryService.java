package com.athira.fleetapp.services;

import com.athira.fleetapp.entities.Country;
import com.athira.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

//    Return list of countries
    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

//    save new country
    public void saveCountry(Country country){
        countryRepository.save(country);
    }

//    get country by id
    public Country findById(Integer id){
        return countryRepository.findById(id).get();
    }

    public void deleteCountry(int id) {
        countryRepository.deleteById(id);
    }
}
