package com.jfree.memdb.schema;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public enum DataType {
	STRING(false, String.class), INTEGER(true, Integer.class), LONG(true, Long.class, Integer.class), FLOAT(false,
			Float.class), DOUBLE(false, Double.class,
					Float.class), DATE(false, Date.class), BOOLEAN(false, Boolean.class);

	private boolean autoIncrementPossible;

	private List<Class<?>> allowedInstances;

	private DataType(boolean autoIncrementPossible, Class<?>... allowedInstances) {
		this.autoIncrementPossible = autoIncrementPossible;
		this.allowedInstances = Arrays.asList(allowedInstances);
	}

	public boolean isAutoIncrementPossible() {
		return autoIncrementPossible;
	}

	public List<Class<?>> getAllowedInstances() {
		return allowedInstances;
	}

}
