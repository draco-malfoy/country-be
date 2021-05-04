package com.mt.country.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private long population;
	private String capital;
	private String flagUrl;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id")
	private List<State> states;

	public Country() {
		super();
	}

	public Country(String name, long population, List<State> states, String capital, String flagUrl) {
		super();
		this.name = name;
		this.population = population;
		this.states = states;
		this.capital = capital;
		this.flagUrl = flagUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getFlagUrl() {
		return flagUrl;
	}

	public void setFlagUrl(String flagUrl) {
		this.flagUrl = flagUrl;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	@JsonManagedReference
	public List<State> getStates() {
		return states;
	}

	public void setStates(ArrayList<State> states) {
		this.states = states;
	}

}
