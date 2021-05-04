package com.mt.country.exception;

public class CountryNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CountryNotFoundException(String msg) {
		super(msg);
	}
}
