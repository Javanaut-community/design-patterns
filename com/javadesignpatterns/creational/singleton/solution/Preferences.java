package com.javadesignpatterns.creational.singleton.solution;

class Preferences {

    private static Preferences instance;

    private Preferences() {}

    public static Preferences getInstance() {
        if (instance == null) {
            instance = new Preferences();
        }
        return instance;
    }
    private String color = "black";

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}

class Window {

    public void painWindow() {
        System.out.println("Painting window: " + Preferences.getInstance().getColor());
    }

}

class App {

    public static void main(String[] args) {
        Preferences.getInstance().setColor("blue");
        Window window = new Window();
        window.painWindow();

        Preferences.getInstance().setColor("black");
        window.painWindow(); //(1)
    }

}
