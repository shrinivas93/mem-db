package com.jfree.memdb;

public enum DataType {
	STRING(false), INTEGER(true), LONG(true), FLOAT(false), DOUBLE(false), DATE(
			false), TIMESTAMP(false), BOOLEAN(false), ENUM(false);

	private boolean autoIncrementPossible;

	private DataType(boolean autoIncrementPossible) {
		this.autoIncrementPossible = autoIncrementPossible;
	}

	public boolean isAutoIncrementPossible() {
		return autoIncrementPossible;
	}

}
