package com.omidanalyzer.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * Created by masoudLofti on 7/11/17.
 */
@SpringBootApplication
public class Application {

    private static ApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);

        Hand rightHand = context.getBean(Hand.class);
        Hand leftHand = context.getBean(Hand.class);
        leftHand.move();
        rightHand.move();
        System.out.println("Done;");
    }

    @Bean
    @Scope("prototype")
    public Hand handBean() {
        return new Hand();
    }


}
