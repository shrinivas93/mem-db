package com.jfree.memdb;

import java.util.Date;

import com.jfree.memdb.MemDB.QueryBuilder;
import com.jfree.memdb.schema.Column;
import com.jfree.memdb.schema.DataType;
import com.jfree.memdb.schema.Database;
import com.jfree.memdb.schema.Table;

public class ColumnTest {
	public static void main(String[] args) {
		Database database = Database.newDatabase("test");
		database.addTable(Table.newTable("tab").addColumn(Column.newColumn("name", DataType.STRING)));
		new QueryBuilder("test", "tab").select().where().groupby().orderby().offset().limit().build().execute();

		Column.newColumn("age1", DataType.BOOLEAN).setDefaultValue(true).setAutoIncrement(false);
		Column.newColumn("age2", DataType.LONG).setDefaultValue(1).setAutoIncrement(true);
		Column.newColumn("age3", DataType.INTEGER).setDefaultValue(1).setAutoIncrement(true);
		Column.newColumn("age4", DataType.DOUBLE).setDefaultValue(1D).setAutoIncrement(false);
		Column.newColumn("age5", DataType.DOUBLE).setDefaultValue(1F).setAutoIncrement(false);
		Column.newColumn("age6", DataType.FLOAT).setDefaultValue(1F).setAutoIncrement(false);
		Column.newColumn("age7", DataType.STRING).setDefaultValue("1").setAutoIncrement(false);
		Column.newColumn("age8", DataType.DATE).setDefaultValue(new Date()).setAutoIncrement(false);
		Column.newColumn("age9", DataType.LONG).setDefaultValue(1).setAutoIncrement(true);
	}
}
