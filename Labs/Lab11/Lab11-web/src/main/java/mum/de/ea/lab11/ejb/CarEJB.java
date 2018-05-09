/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab11.ejb;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.TypedQuery;
import mum.de.ea.lab11.aop.LoggerInterceptor;
import mum.de.ea.lab11.entity.Car;

/**
 *
 * @author tuvshuu
 */
@Stateful
@Interceptors(LoggerInterceptor.class)
public class CarEJB {

    @EJB
    private MainEjb mainEjb;

    public void createCar(Car car) {
        mainEjb.getEm().persist(car);
    }

    public Car getCar(Integer id) {
        return mainEjb.getEm().find(Car.class, id);
    }

    public void updateCar(Car car) {
        mainEjb.getEm().persist(car);
    }

    public void deleteCar(Integer id) {
        Car car = getCar(id);
        mainEjb.getEm().remove(car);
    }

    public List<Car> getCars() {
        TypedQuery typedQuery = mainEjb.getEm().createQuery("SELECT c FROM Car c", Car.class);
        return typedQuery.getResultList();
    }
}
