package com.jfree.memdb;

import com.jfree.memdb.exception.AutoIncrementException;
import com.jfree.memdb.exception.InvalidColumnNameException;
import com.jfree.memdb.exception.InvalidDataTypeException;
import com.jfree.memdb.exception.InvalidDefaultValueException;

public class Column {
	private String name;
	private DataType type;
	private Object defaultValue;
	private Reference reference;
	private boolean notNull;
	private boolean unique;
	private boolean autoIncrement;

	private Column() {

	}

	public String getName() {
		return name;
	}

	public Column setName(String name) {
		this.name = name;
		return this;
	}

	public DataType getType() {
		return type;
	}

	public Column setType(DataType type) {
		this.type = type;
		return this;
	}

	public Object getDefaultValue() {
		return defaultValue;
	}

	public Column setDefaultValue(Object defaultValue) {
		if (!Validator.validateDefaultValueType(type, defaultValue)) {
			throw new InvalidDefaultValueException(
					"\n" + "Found defaultValue of type " + defaultValue.getClass() + " for column " + name + "("
							+ type.name() + ").\n" + "Expected one out of " + type.getAllowedInstances());
		}
		this.defaultValue = defaultValue;
		return this;
	}

	public Reference getReference() {
		return reference;
	}

	public Column setReference(Reference reference) {
		this.reference = reference;
		return this;
	}

	public boolean isNotNull() {
		return notNull;
	}

	public Column setNotNull(boolean notNull) {
		this.notNull = notNull;
		return this;
	}

	public boolean isUnique() {
		return unique;
	}

	public Column setUnique(boolean unique) {
		this.unique = unique;
		return this;
	}

	public boolean isAutoIncrement() {
		return autoIncrement;
	}

	public Column setAutoIncrement(boolean autoIncrement) {
		if (autoIncrement && !type.isAutoIncrementPossible()) {
			throw new AutoIncrementException(
					"\nAuto increment not possible for the column " + name + "(" + type + ").");
		}
		this.autoIncrement = autoIncrement;
		return this;
	}

	public static Column newColumn(String name, DataType type) {
		if (name == null) {
			throw new InvalidColumnNameException("Column name cannot be null");
		}
		if (type == null) {
			throw new InvalidDataTypeException("Data type cannot be null");
		}
		return new Column().setName(name).setType(type);
	}

}
