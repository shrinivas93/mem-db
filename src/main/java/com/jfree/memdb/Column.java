package com.jfree.memdb;

public class Column {
	private String name;
	private DataType type;
	private Object defaultValue;
	private Reference reference;
	private boolean notNull;
	private boolean unique;
	private boolean autoIncrement;

	public Column(String name, DataType type) {
		super();
		this.name = name;
		this.type = type;
	}

}
