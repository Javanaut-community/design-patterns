package com.javadesignpatterns.creational.builder.solution;

public interface QueryBuilder {

	void from(String from); //(1)!

	void where(String where);

	Query getQuery(); //(2)!

}
