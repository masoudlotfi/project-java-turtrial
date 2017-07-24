package com.masoud.test.car;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WheelsConfig {
    private byte topLeft = 100;
    private byte topRight = 100;
    private byte downLeft = 100;
    private byte downRight = 100;

    public WheelsConfig(byte topLeft, byte topRight, byte downLeft, byte downRight) {
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.downLeft = downLeft;
        this.downRight = downRight;
    }

    public WheelsConfig() {

    }

    public byte getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(byte topLeft) {
        this.topLeft = topLeft;
    }

    public byte getTopRight() {
        return topRight;
    }

    public void setTopRight(byte topRight) {
        this.topRight = topRight;
    }

    public byte getDownLeft() {
        return downLeft;
    }

    public void setDownLeft(byte downLeft) {
        this.downLeft = downLeft;
    }

    public byte getDownRight() {
        return downRight;
    }

    public void setDownRight(byte downRight) {
        this.downRight = downRight;
    }
}
