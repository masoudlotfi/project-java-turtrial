package com.masoud.test.car;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car implements CarInterface {

    private int id;
    private String name;
    private EngineState engine;
    private WheelsConfig wheel;
    private byte fuel;

    @Override
    public void setEngineState(EngineState engine) {
        this.engine = engine;
    }

    @Override
    public void updateName(String name) {
        this.name = name;
    }

    @Override
    public void updateFuel(byte amountOfFuel) {
        this.fuel = amountOfFuel;
    }

    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWheel(WheelsConfig wheel) {
        this.wheel = wheel;
    }

    public void setEngine(EngineState engine) {
        this.engine = engine;
    }

    public void setFuel(byte fuel) {
        this.fuel = fuel;
    }

    public void setFuel() {
        this.fuel = 100;
    }


    //getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EngineState getEngine() {
        return engine;
    }

    public WheelsConfig getWheel() {
        return wheel;
    }

    public byte getFuel() {
        return fuel;
    }
}
