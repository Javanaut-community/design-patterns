package com.javadesignpatterns.creational.builder.solution;

public class SqlQueryBuilder implements QueryBuilder{

	private SqlQuery query = new SqlQuery(); //(1)!

	@Override
	public void from(String from) { //(2)!
		query.setFrom(from);
	}

	@Override
	public void where(String where) {
		query.setWhere(where);
	}

	@Override
	public Query getQuery() { //(3)!
		return query;
	}

}
