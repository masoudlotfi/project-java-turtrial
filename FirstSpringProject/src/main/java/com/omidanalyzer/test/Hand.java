package com.omidanalyzer.test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by masoudLofti on 7/11/17.
 */
public class Hand {

    @Autowired
    public void setBrainInterface(BrainInterface brainInterface) {
        this.brainInterface = brainInterface;
    }

    private BrainInterface brainInterface;

    public Hand() {

    }

    void move() {
        System.out.print(brainInterface.doTest());
    }
}
