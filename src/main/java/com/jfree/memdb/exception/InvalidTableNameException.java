package com.jfree.memdb.exception;

public class InvalidTableNameException extends RuntimeException {

	private static final long serialVersionUID = -626801088286840081L;

	public InvalidTableNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidTableNameException(String message) {
		super(message);
	}

}
