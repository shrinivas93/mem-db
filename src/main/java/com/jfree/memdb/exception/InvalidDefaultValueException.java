package com.jfree.memdb.exception;

public class InvalidDefaultValueException extends RuntimeException {

	private static final long serialVersionUID = 8548330829711177145L;

	public InvalidDefaultValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDefaultValueException(String message) {
		super(message);
	}

}
