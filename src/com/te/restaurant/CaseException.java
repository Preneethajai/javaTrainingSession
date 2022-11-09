package com.te.restaurant;

public class CaseException extends RuntimeException {
	String message;

	public CaseException(String message) {
		super(message);
		this.message = message;
	}
	
}
