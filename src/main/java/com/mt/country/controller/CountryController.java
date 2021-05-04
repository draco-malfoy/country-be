package com.mt.country.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.country.model.Country;
import com.mt.country.service.CountryService;

@RestController
@RequestMapping("/country")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CountryController {

	private CountryService countryService;

	public CountryController(CountryService countryService) {
		this.countryService = countryService;
	}

	@GetMapping("/allCountries")
	public ResponseEntity<List<Country>> findAllCountries() {
		List<Country> countriesList = countryService.findAllCountries();
		return new ResponseEntity<>(countriesList, HttpStatus.OK);
	}

	@PostMapping("/addCountry")
	public ResponseEntity<Country> addCountry(@RequestBody Country country) {
		Country newCountry = countryService.addCountry(country);
		return new ResponseEntity<>(newCountry, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Country> findCountry(@PathVariable("id") Integer id) {
		Country findCountry = countryService.findCountryById(id);
		return new ResponseEntity<>(findCountry, HttpStatus.OK);
	}

	@PutMapping("/updateCountry")
	public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
		Country updateCountry = countryService.updateCountry(country);
		return new ResponseEntity<>(updateCountry, HttpStatus.OK);
	}

	@DeleteMapping("/deleteCountry/{id}")
	public ResponseEntity<?> deleteCountry(@PathVariable("id") Integer id) {
		countryService.deleteCountry(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
