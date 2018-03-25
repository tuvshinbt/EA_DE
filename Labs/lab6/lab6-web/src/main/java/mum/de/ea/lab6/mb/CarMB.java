/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab6.mb;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mum.de.ea.lab6.entity.Car;
import mum.de.ea.lab6.service.CarService;
import mum.de.ea.lab6.service.CarServiceImpl;

/**
 *
 * @author tuvshuu
 */
@Named(value = "carMB")
@RequestScoped
public class CarMB implements Serializable {

    private Car car;
    private final CarService carService = new CarServiceImpl();
    private String message = null;

    /**
     * Creates a new instance of CarMB
     */
    public CarMB() {
        System.out.println("%%% CAR MB is created");
        car = new Car();
    }

    public String show(Integer id) {
        car = carService.get(id);
        System.out.println("--- CAR.ID - " + car.getId());
        return "Car";
    }

    public String save() {
        if (car.getId() == null || car.getId() == 0) {
            int generatedId = carService.create(car);
            message = "New car had been successfully created. GeneratedId - " + generatedId;
            car.setId(generatedId);
        } else {
            boolean result = carService.update(car.getId(), car);
            message = "Result of update action is " + result;
        }
        System.out.println(message);
        return "Cars";
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
