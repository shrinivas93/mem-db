package com.jfree.memdb;

public class Validator {
	public static boolean validateDefaultValueType(DataType type, Object defaultValue) {
		return type.getAllowedInstances().contains(defaultValue.getClass());
	}
}
