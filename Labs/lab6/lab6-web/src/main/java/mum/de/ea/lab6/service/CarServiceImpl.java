/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab6.service;

import java.util.List;
import mum.de.ea.lab6.dao.CarDAO;
import mum.de.ea.lab6.dao.CarDAOImpl;
import mum.de.ea.lab6.entity.Car;

/**
 *
 * @author tuvshuu
 */
public class CarServiceImpl implements CarService {

    CarDAO carDAO = new CarDAOImpl();

    public CarServiceImpl() {
        System.out.println("### CarService.CarServiceImpl() has been called. " + System.currentTimeMillis());
    }

    @Override
    public List<Car> getList() {
        System.out.println("CarService.getList() has been called");
        return carDAO.findAll();
    }

    @Override
    public Car get(Integer id) {
        System.out.println("CarService.get(" + id + ") has been called");
        return carDAO.findById(id);
    }

    @Override
    public Integer create(Car car) {
        System.out.println("CarService.create(" + car.toString() + ") has been called");
        return carDAO.create(car);
    }

    @Override
    public boolean update(Integer id, Car car) {
        try {
            System.out.println("CarService.update(" + id + ", "+ car.toString() + ") has been called");
            carDAO.update(id, car);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            System.out.println("CarService.delete(" + id + ") has been called");
            carDAO.delete(id);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

}
