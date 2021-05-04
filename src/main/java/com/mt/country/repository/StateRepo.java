package com.mt.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mt.country.model.State;

public interface StateRepo extends JpaRepository<State, Integer> {

}
