package com.masoud.test.car;

import java.util.ArrayList;

/**
 * Created by masoudLofti on 7/11/17.
 */
public interface DataInterface {

    ArrayList<Car> listCars();

    Car getCar(int index);

    Car create(String name);

    Car delete(int numberOfCar);

}
