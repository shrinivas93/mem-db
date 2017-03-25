package com.jfree.memdb.schema;

import java.util.HashSet;
import java.util.Set;

public class PrimaryKey {
	private Set<Column> keys;

	private PrimaryKey() {
		keys = new HashSet<>();
	}

	public Set<Column> getKeys() {
		return keys;
	}

	public PrimaryKey setKeys(Set<Column> keys) {
		keys.clear();
		return addKeys(keys);
	}

	public PrimaryKey addKey(Column key) {
		this.keys.add(key);
		return this;
	}

	public PrimaryKey addKeys(Set<Column> keys) {
		for (Column key : keys) {
			addKey(key);
		}
		return this;
	}

	public static PrimaryKey createPrimaryKey(Column key) {
		return new PrimaryKey().addKey(key);
	}

	public static PrimaryKey createPrimaryKey(Set<Column> keys) {
		return new PrimaryKey().setKeys(keys);
	}

}
