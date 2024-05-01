package com.javadesignpatterns.creational.singleton;

class Preferences {

    private String color;

    public Preferences(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}

class Window {

    private Preferences preferences;

    public Window(Preferences preferences) {
        this.preferences = preferences;
    }

    public void painWindow() {
        System.out.println("Painting window: " + preferences.getColor());
    }

}

class App {

    public static void main(String[] args) {
        Preferences preferences = new Preferences("blue");
        Window window = new Window(preferences);
        window.painWindow();

        Preferences second = new Preferences("black");
        window.painWindow(); //(1)!
    }

}
