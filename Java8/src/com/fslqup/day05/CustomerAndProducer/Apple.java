package com.fslqup.day05.CustomerAndProducer;

public class Apple {
    private String taste;
    private  String color;

    public Apple() {
    }

    @Override
    public String toString() {
        return "Apple{" +
                "taste='" + taste + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public Apple(String taste, String color) {
        this.taste = taste;
        this.color = color;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
