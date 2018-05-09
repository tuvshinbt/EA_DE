/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab11.mb;

import java.util.List;
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
@Named(value = "carsMB")
@RequestScoped
@Interceptors(LoggerInterceptor.class)
public class CarsMB {

    @Inject
    private CarEJB carEJB;

    /**
     * Creates a new instance of CarsMB
     */
    public CarsMB() {
    }

    public List<Car> getCars() {
        return carEJB.getCars();
    }

    public String deleteCar(Integer id) {
        carEJB.deleteCar(id);
        return null;
    }
}
