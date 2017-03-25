package com.jfree.memdb;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemDB {
	private static final Map<String, Map<String, Map<String, List<Object>>>> databases = new LinkedHashMap<String, Map<String, Map<String, List<Object>>>>();

	private MemDB() {
	}

	public static class QueryBuilder {
		private String databaseName;
		private String tableName;

		public QueryBuilder(String databaseName, String tableName) {
			this.databaseName = databaseName;
			this.tableName = tableName;
		}

		public Selector select() {
			return new Selector(this);
		}

	}

	public static class Selector {
		private QueryBuilder queryBuilder;

		private Selector(QueryBuilder queryBuilder) {
			this.queryBuilder = queryBuilder;
		}

		public Selector where() {
			return this;
		}

		public Selector groupby() {
			return this;
		}

		public Selector orderby() {
			return this;
		}

		public Selector offset() {
			return this;

		}

		public Selector limit() {
			return this;
		}

		public Query build() {
			return new Query(queryBuilder, this);
		}
	}

	public static class Query {
		private QueryBuilder queryBuilder;
		private Selector selector;
		private QueryType queryType;

		private Query(QueryBuilder queryBuilder, Selector selector) {
			this.queryBuilder = queryBuilder;
			this.selector = selector;
			queryType = QueryType.SELECT;
		}

		public void execute() {
			switch (queryType) {
			case SELECT:
				executeQuery();
				break;
			case INSERT:
				executeInsert();
				break;
			case UPDATE:
				executeUpdate();
				break;
			}
		}

		private void executeUpdate() {
			// TODO Auto-generated method stub

		}

		private void executeInsert() {
			// TODO Auto-generated method stub

		}

		private void executeQuery() {
			Map<String, Map<String, List<Object>>> database = databases.get(queryBuilder.databaseName);
			Map<String, List<Object>> table = database.get(queryBuilder.tableName);
			List<Map<String, Object>> result = new LinkedList<>();
			Set<String> columns = table.keySet();
			Iterator<String> iterator = columns.iterator();
			String next = iterator.next();
			List<Object> list = table.get(next);
			int size = list.size();
			for (int i = 0; i < size; i++) {
				Map<String, Object> map = new LinkedHashMap<>();
				for (String column : columns) {
					map.put(column, table.get(column).get(i));
				}
				result.add(map);
			}
			System.out.println(result);
		}
	}

	private enum QueryType {
		SELECT, INSERT, UPDATE
	}

	public static void addDatabase(String name) {
		databases.put(name, new LinkedHashMap<String, Map<String, List<Object>>>());
	}

	public static void addTable(String databaseName, String tableName) {
		databases.get(databaseName).put(tableName, new LinkedHashMap<String, List<Object>>());
	}
}
