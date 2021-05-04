package com.mt.country.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.country.exception.CountryNotFoundException;
import com.mt.country.model.Country;
import com.mt.country.model.State;
import com.mt.country.repository.StateRepo;

@Service
public class StateService {

	private final StateRepo stateRepo;

	@Autowired
	public StateService(StateRepo sr) {
		stateRepo = sr;
	}

	public State addState(State state) {
		state.setId(new Random().nextInt());
		return state;
	}

	public List<State> findAllStates() {
		return stateRepo.findAll();
	}

	public State findStateById(Integer id) {
		return stateRepo.findById(id).orElseThrow(() -> new CountryNotFoundException("The entered state is not found"));
	}

	public void deleteState(Integer id) {
		stateRepo.deleteById(id);
	}

	public State updateState(State state) {
		return stateRepo.save(state);
	}

}
