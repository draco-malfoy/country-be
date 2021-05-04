package com.mt.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.country.model.Country;

public interface CountryRepo extends  JpaRepository<Country, Integer> {

}
