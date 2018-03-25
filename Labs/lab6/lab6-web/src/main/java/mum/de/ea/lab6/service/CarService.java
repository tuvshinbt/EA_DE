/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab6.service;

import java.util.List;
import mum.de.ea.lab6.entity.Car;

/**
 *
 * @author tuvshuu
 */
public interface CarService {

    List<Car> getList();

    Car get(Integer id);

    Integer create(Car car);

    boolean update(Integer id, Car car);

    boolean delete(Integer id);
}
