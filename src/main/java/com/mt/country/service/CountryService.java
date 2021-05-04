package com.mt.country.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.country.exception.CountryNotFoundException;
import com.mt.country.model.Country;
import com.mt.country.repository.CountryRepo;

@Service
public class CountryService {

	private CountryRepo countryRepo;

	@Autowired
	public CountryService(CountryRepo cr) {
		countryRepo = cr;
	}

	public Country addCountry(Country country) {
		return countryRepo.save(country);
	}

	public List<Country> findAllCountries() {
		return countryRepo.findAll();
	}

	public Country findCountryById(Integer id) {
		return countryRepo.findById(id)
				.orElseThrow(() -> new CountryNotFoundException("The entered country is not found"));
	}

	public void deleteCountry(Integer id) {
		countryRepo.deleteById(id);
	}

	public Country updateCountry(Country country) {
		return countryRepo.save(country);
	}
}
