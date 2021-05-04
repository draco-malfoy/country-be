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

import com.mt.country.model.State;
import com.mt.country.service.StateService;

@RestController
@RequestMapping("/state")
@CrossOrigin(origins = "http://localhost:4200")
public class StateController {

	private StateService stateService;

	public StateController(StateService stateService) {
		this.stateService = stateService;
	}

	@GetMapping("/allStates")
	public ResponseEntity<List<State>> findAllStates() {
		List<State> StatesList = stateService.findAllStates();
		return new ResponseEntity<>(StatesList, HttpStatus.OK);
	}

	@PostMapping("/addCountry")
	public ResponseEntity<State> addState(@RequestBody State state) {
		State newState = stateService.addState(state);
		return new ResponseEntity<>(newState, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<State> findState(@PathVariable("id") Integer id) {
		State findState = stateService.findStateById(id);
		return new ResponseEntity<>(findState, HttpStatus.OK);
	}

	@PutMapping("/updateState")
	public ResponseEntity<State> updateCountry(@RequestBody State state) {
		State updateState = stateService.updateState(state);
		return new ResponseEntity<>(updateState, HttpStatus.OK);
	}

	@DeleteMapping("/deleteState/{id}")
	public ResponseEntity<?> deleteState(@PathVariable("id") Integer id) {
		stateService.deleteState(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}