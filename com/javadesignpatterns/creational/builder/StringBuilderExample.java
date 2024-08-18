package com.javadesignpatterns.creational.builder;

public class StringBuilderExample {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder(); //(1)!
        String hello = builder.append("Hello ")
                .append("fellow ") //(2)!
                .append("Javanauts")
                .toString();
        System.out.println(hello);
    }

}
