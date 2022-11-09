package com.te.javabasic.exception;

public class InsufficientBalanceException extends RuntimeException {

//	String message;

	public InsufficientBalanceException(String message) {
		super(message);
	}

}
