package com.jfree.memdb.exception;

public class InvalidDataTypeException extends RuntimeException {

	private static final long serialVersionUID = -5996290595465101033L;

	public InvalidDataTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDataTypeException(String message) {
		super(message);
	}

}
