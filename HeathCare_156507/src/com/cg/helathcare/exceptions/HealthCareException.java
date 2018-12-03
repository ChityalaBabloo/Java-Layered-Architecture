package com.cg.helathcare.exceptions;

public class HealthCareException extends Exception {

	private String message;

	public HealthCareException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
