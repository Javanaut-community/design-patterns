package com.javadesignpatterns.creational.singleton.solution;

public class Singleton {

    private static Singleton instance; //(1)!

    private Singleton() {} //(2)!

    public static Singleton getInstance() { //(3)!
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

}
