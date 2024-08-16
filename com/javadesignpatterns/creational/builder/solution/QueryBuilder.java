package com.javadesignpatterns.creational.builder.solution;

public interface QueryBuilder {

	void from(String from);

	void where(String where);

	Query getQuery();

}
