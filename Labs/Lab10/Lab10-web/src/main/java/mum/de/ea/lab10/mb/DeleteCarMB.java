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
@Named(value = "deleteCarMB")
@RequestScoped
public class DeleteCarMB implements Serializable {

    @Inject
    private ApplicationMB amb;

    @Inject
    private CarsMB carsMB;
    private Car car;
    private int numberOfCar;

    /**
     * Creates a new instance of CarMB
     */
    public DeleteCarMB() {
        car = new Car();
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String show(Integer id) {
        car = amb.getEm().find(Car.class, id);
        car = amb.getEm().merge(car);
//        amb.getEm().lock(car, LockModeType.OPTIMISTIC);
        System.out.println("--- CAR.ID - " + car.getId());
        return "DeleteCar";
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String delete() {
        car = amb.getEm().merge(car);
        amb.getEm().remove(car);
        return "Cars";
    }

    public Car getCar() {
        return car;
    }

    public Integer getNumberOfCar() {
        return numberOfCar;
    }

}
