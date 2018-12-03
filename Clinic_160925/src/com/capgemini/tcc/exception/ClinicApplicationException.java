package com.capgemini.tcc.exception;

public class ClinicApplicationException extends Exception{
	
	private String exception;

	public ClinicApplicationException(String exception) {
		super();
		this.exception = exception;
	}

	public String getException() {
		return exception;
	}
}
