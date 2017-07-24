package com.masoud.test.car;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@SpringBootApplication
public class Application implements DataInterface {
    public static ApplicationContext context;

    public static void main(String[] args) throws JSONException {
        context = SpringApplication.run(Application.class, args);
    }

    private int index = 0;
    private ArrayList<Car> cars = new ArrayList<Car>();

    @Override
    public ArrayList<Car> listCars() {
        return this.cars;
    }

    @Override
    public Car getCar(int index) {
        return this.cars.get(index);
    }

    @Override
    public Car create(String name) {
        Car car = Application.context.getBean(Car.class);
        car.setId(index);
        car.setName(name);
        car.setFuel();
        car.setEngineState(EngineState.ON);
        car.setWheel(Application.context.getBean(WheelsConfig.class));
        this.cars.add(index, car);
        index++;
        return car;
    }

    @Bean
    @Scope("prototype")
    public Car carBean() {

        return new Car();
    }

    @Bean
    @Scope("prototype")
    public WheelsConfig wheelsConfigBean() {

        return new WheelsConfig();
    }

    @Bean
    @Scope("singleton")
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

    @Override
    public Car delete(int numberOfCar) {
        return this.cars.remove(numberOfCar);
    }
}
