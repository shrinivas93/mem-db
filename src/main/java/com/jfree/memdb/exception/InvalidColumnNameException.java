package com.jfree.memdb.exception;

public class InvalidColumnNameException extends RuntimeException {

	private static final long serialVersionUID = -2279596082334895213L;

	public InvalidColumnNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidColumnNameException(String message) {
		super(message);
	}

}
