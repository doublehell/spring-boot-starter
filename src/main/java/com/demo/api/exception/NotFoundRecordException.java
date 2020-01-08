package com.demo.api.exception;

@SuppressWarnings("serial")
public class NotFoundRecordException extends RuntimeException {
	
	public NotFoundRecordException(String message) {
		super(message);
	}
	
}
