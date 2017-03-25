package com.jfree.memdb.schema;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.jfree.memdb.MemDB;
import com.jfree.memdb.exception.InvalidTableNameException;

public class Table {
	private String name;
	private PrimaryKey primaryKey;
	private Map<String, Column> columns;

	private Table() {
		columns = new LinkedHashMap<>();
	}

	public String getName() {
		return name;
	}

	public Table setName(String name) {
		this.name = name;
		return this;
	}

	public PrimaryKey getPrimaryKey() {
		return primaryKey;
	}

	public Table setPrimaryKey(PrimaryKey primaryKey) {
		this.primaryKey = primaryKey;
		return this;
	}

	public Column getColumn(String columnName) {
		return columns.get(columnName);
	}

	public Map<String, Column> getColumns() {
		return columns;
	}

	public Table setColumns(Set<Column> columns) {
		this.columns.clear();
		return addColumns(columns);
	}

	public Table addColumn(Column column) {
		this.columns.put(column.getName(), column);
		return this;
	}

	public Table addColumns(Set<Column> columns) {
		for (Column column : columns) {
			addColumn(column);
		}
		return this;
	}

	public static Table newTable(String name) {
		if (name == null) {
			throw new InvalidTableNameException("Table name cannot be null");
		}
		return new Table().setName(name);
	}

}
