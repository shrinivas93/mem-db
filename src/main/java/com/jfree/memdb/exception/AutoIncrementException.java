package com.jfree.memdb.exception;

public class AutoIncrementException extends RuntimeException {

	private static final long serialVersionUID = 3272235715790475387L;

	public AutoIncrementException(String message, Throwable cause) {
		super(message, cause);
	}

	public AutoIncrementException(String message) {
		super(message);
	}

}
