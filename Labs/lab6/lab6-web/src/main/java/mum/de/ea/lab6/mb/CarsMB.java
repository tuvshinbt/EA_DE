/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab6.mb;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.inject.Inject;
import mum.de.ea.lab6.entity.Car;
import mum.de.ea.lab6.service.CarService;
import mum.de.ea.lab6.service.CarServiceImpl;

/**
 *
 * @author tuvshuu
 */
@Named(value = "carsMB")
@RequestScoped
public class CarsMB implements Serializable {

    @Inject
    private CarMB carMB;

    private List<Car> cars;
    private final CarService carService = new CarServiceImpl();

    public CarsMB() {
        cars = carService.getList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void deleteCar(Integer id) {
        carService.delete(id);
        cars = carService.getList();
    }

}
