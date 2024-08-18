package com.javadesignpatterns.creational.builder.solution;

public class QueryBuildDirector {

	public Query buildQuery(String from, String where, QueryBuilder builder){
		builder.from(from); //(1)!
        builder.where(where);
        return builder.getQuery();
	}

}
