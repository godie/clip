package com.godieboy.clipo.exceptions;

public class TransactionNotFounException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public TransactionNotFounException(String message, Throwable cause) {
		super(message,cause);
	}
	
	public TransactionNotFounException(String message) {
		super(message);
	}



}
