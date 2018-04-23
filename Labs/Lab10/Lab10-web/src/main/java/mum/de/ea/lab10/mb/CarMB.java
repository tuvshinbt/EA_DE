/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab10.mb;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import mum.de.ea.lab10.entity.Car;

/**
 *
 * @author tuvshuu
 */
@Named(value = "carMB")
@RequestScoped
public class CarMB implements Serializable {

    @Inject
    private ApplicationMB amb;
    private Car car;

    /**
     * Creates a new instance of CarMB
     */
    public CarMB() {
        car = new Car();
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String show(Integer id) {
        car = amb.getEm().find(Car.class, id);
        System.out.println("--- CAR.ID - " + car.getId());
        return "Car";
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String save() {
        car = amb.getEm().merge(car);
        amb.getEm().persist(car);
        return "Cars";
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
