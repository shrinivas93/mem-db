package com.jfree.memdb;

import com.jfree.memdb.schema.DataType;

public class Validator {
	public static boolean validateDefaultValueType(DataType type, Object defaultValue) {
		return type.getAllowedInstances().contains(defaultValue.getClass());
	}
}
