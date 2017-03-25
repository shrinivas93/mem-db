package com.jfree.memdb.schema;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.jfree.memdb.MemDB;
import com.jfree.memdb.exception.InvalidTableNameException;

public class Database {

	private String name;
	private Map<String, Table> tables;

	public Database() {
		tables = new LinkedHashMap<>();
	}

	public String getName() {
		return name;
	}

	public Database setName(String name) {
		this.name = name;
		return this;
	}

	public Table getTable(String tableName) {
		return tables.get(tableName);
	}

	public Map<String, Table> getTables() {
		return tables;
	}

	public Database setTables(Set<Table> tables) {
		this.tables.clear();
		return addTables(tables);
	}

	public Database addTable(Table table) {
		this.tables.put(table.getName(), table);
		MemDB.addTable(name, table.getName());
		return this;
	}

	public Database addTables(Set<Table> tables) {
		for (Table table : tables) {
			addTable(table);
		}
		return this;
	}

	public static Database newDatabase(String name) {
		if (name == null) {
			throw new InvalidTableNameException("Database name cannot be null");
		}
		MemDB.addDatabase(name);
		return new Database().setName(name);
	}
}
