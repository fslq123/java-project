package com.fslq.day05.demoapi;

public class Apple {
    private String color;
    private Float prize;

    public Apple(String color, float prize) {
        this.color=color;
        this.prize=prize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPrize() {
        return prize;
    }

    public void setPrize(Float prize) {
        this.prize = prize;
    }
}
