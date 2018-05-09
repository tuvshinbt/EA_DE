/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab11.mb;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptors;
import mum.de.ea.lab11.aop.LoggerInterceptor;
import mum.de.ea.lab11.ejb.CarEJB;
import mum.de.ea.lab11.entity.Car;

/**
 *
 * @author tuvshuu
 */
@Named(value = "carEditMB")
@RequestScoped
@Interceptors(LoggerInterceptor.class)
public class CarEditMB {

    @Inject
    private CarEJB carEJB;

    Car car;
    private static final String URL_CAR_EDIT = "CarEdit";
    private static final String URL_CARS = "Cars";

    /**
     * Creates a new instance of CarMB
     */
    public CarEditMB() {
        System.out.println("FIRST CarMB Constuctor");
        car = new Car();
    }

    public String showCar(Integer id) {
        car = carEJB.getCar(id);
        return URL_CAR_EDIT;
    }

    public String updateCar() {
        carEJB.updateCar(car);
        return URL_CARS;
    }

    public String deleteCar() {
        carEJB.deleteCar(car.getId());
        return URL_CARS;
    }

    public Car getCar() {
        return car;
    }

}
