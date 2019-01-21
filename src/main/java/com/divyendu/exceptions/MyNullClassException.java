package com.divyendu.exceptions;

public class MyNullClassException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;
	public MyNullClassException(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
