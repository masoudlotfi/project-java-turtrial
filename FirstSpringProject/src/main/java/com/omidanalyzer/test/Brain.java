package com.omidanalyzer.test;

import org.springframework.stereotype.Component;

/**
 * Created by masoudLofti on 7/11/17.
 */
@Component
public class Brain implements BrainInterface {

    @Override
    public String doTest() {
        return "Yeah ! , I am Moving !";
    }

}
