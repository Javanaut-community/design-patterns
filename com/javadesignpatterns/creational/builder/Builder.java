package com.javadesignpatterns.creational.builder;

public class Builder {

	public static void main(String[] args){

		String from="client table";
		String where="client name = ...";

		// build the query by using the director
		SqlQuery sqlQuery = new SqlQuery(); //(1)!
        sqlQuery.setFrom(from);
        sqlQuery.setWhere(where);
        sqlQuery.execute();

		// using mongodb query
        MongoDbQuery mongoDbQuery = new MongoDbQuery(); //(2)!
        mongoDbQuery.setFrom(from);
        mongoDbQuery.setWhere(where);
        mongoDbQuery.execute();
    }

}
