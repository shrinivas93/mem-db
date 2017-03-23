package com.jfree.memdb;

public class Reference {
	private Table table;
	private Column column;

	public Reference(Table table, Column column) {
		this.table = table;
		this.column = column;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

}
