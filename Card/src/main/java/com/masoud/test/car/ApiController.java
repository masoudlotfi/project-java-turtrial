package com.masoud.test.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
public class ApiController {

    @Autowired
    private DataInterface dataInterface;

    private String status;

    @RequestMapping(value = "/car/list")
    public ArrayList<Car> listCar() {
        dataInterface.create("a" + System.currentTimeMillis());
        dataInterface.create("b" + System.currentTimeMillis());
        dataInterface.create("c" + System.currentTimeMillis());
        ArrayList<Car> cars = dataInterface.listCars();
        return cars;
    }

    @RequestMapping(value = "/car/show", method = RequestMethod.POST, params = "id")
    public Car showCar(@RequestParam("id") int id) {
        ArrayList<Car> cars = dataInterface.listCars();
        Car myCard = dataInterface.getCar(id);
        return myCard;
    }


    @RequestMapping(value = "/car/create", method = RequestMethod.POST, params = "name")
    public String createCar(@RequestParam("name") String name) {
        dataInterface.create(name + System.currentTimeMillis());
        ArrayList<Car> cars = dataInterface.listCars();
        int numberNewCar = cars.size() - 1;
        return "create car successfully.This number of new Car is " + numberNewCar;
    }

    @RequestMapping(value = "/car/engineState", method = RequestMethod.POST)
    public String setEngineStateOfCard(HttpServletRequest request,
                                       @RequestParam(value = "id", required = true) int id,
                                       @RequestParam(value = "stateEngine", required = true) String stateEngine
    ) {
        EngineState state1 = EngineState.valueOf(stateEngine);
        dataInterface.getCar(id).setEngineState(state1);
        return "Change state engine Successfully.";
    }

    @RequestMapping(value = "/car/name", method = RequestMethod.POST)
    public String setNameCard(HttpServletRequest request,
                              @RequestParam(value = "id", required = true) int id,
                              @RequestParam(value = "name", required = true) String name
    ) {
        dataInterface.getCar(id).updateName(name);
        return "Change name of car Successfully.";
    }

    @RequestMapping(value = "/car/updateFuel", method = RequestMethod.POST)
    public String updateFuelOfCar(HttpServletRequest request,
                                  @RequestParam(value = "id", required = true) int id,
                                  @RequestParam(value = "fuel", required = true) byte fuel
    ) {

        dataInterface.getCar(id).updateFuel(fuel);
        return "Update fuel of car Successfully.";
    }

    @RequestMapping(value = "/car/updateAirOfWheel", method = RequestMethod.POST)
    public String updateAirOfWheel(HttpServletRequest request,
                                   @RequestParam(value = "id", required = true) int id,
                                   @RequestParam(value = "top_left", required = true) byte topLeft,
                                   @RequestParam(value = "top_right", required = true) byte topRight,
                                   @RequestParam(value = "down_left", required = true) byte downLeft,
                                   @RequestParam(value = "down_right", required = true) byte downRight
    ) {

        dataInterface.getCar(id).getWheel().setTopLeft(topLeft);
        dataInterface.getCar(id).getWheel().setTopRight(topRight);
        dataInterface.getCar(id).getWheel().setDownLeft(downLeft);
        dataInterface.getCar(id).getWheel().setDownRight(downRight);
        return "Update air of wheel Successfully.";
    }

    @RequestMapping(value = "/car/grap", method = RequestMethod.POST)
    public Object grap(HttpServletRequest request,
                       @RequestParam(value = "id", required = true) int id,
                       @RequestParam(value = "telegram_id", required = true) long telegramId
    ) {
        dataInterface.create("c" + System.currentTimeMillis());
        ArrayList<Car> cars = dataInterface.listCars();
        Car myCard = dataInterface.getCar(id);
        String name = myCard.getName();
        GrabRestController grabRestController = Application.context.getBean(GrabRestController.class);
        grabRestController.setCarName(name);
        grabRestController.setTelegramId(telegramId);
        grabRestController.sendAlaram();
//        System.out.print(this.status);

        return  "";
//        return "Successfully{" +
//                "status='" + this.status + '\'' +
//                '}';
    }

    @Bean
    @Scope("prototype")
    public GrabRestController grabRestControllerBean() {
        return new GrabRestController();
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
