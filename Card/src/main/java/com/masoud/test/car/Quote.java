package com.masoud.test.car;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private String type;

    public Quote() {
    }

    public String getType() {
        return type;
    }

    public void setType(String Success) {
        this.type = Success;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                '}';
    }
}