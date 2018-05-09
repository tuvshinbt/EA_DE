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
@Named(value = "carMB")
@RequestScoped
@Interceptors(LoggerInterceptor.class)
public class CarMB {

    @Inject
    private CarEJB carEJB;

    Car car;
    private static final String URL_CARS = "Cars";

    /**
     * Creates a new instance of CarMB
     */
    public CarMB() {
        car = new Car();
    }

    public String createCar() {
        carEJB.createCar(car);
        return URL_CARS;
    }

    public Car getCar() {
        return car;
    }

}
