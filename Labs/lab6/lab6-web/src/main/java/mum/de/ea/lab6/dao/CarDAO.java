/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab6.dao;

import java.util.List;
import mum.de.ea.lab6.entity.Car;

/**
 *
 * @author tuvshuu
 */
public interface CarDAO {

    List<Car> findAll();

    Car findById(int id);

    Integer create(Car car);

    void update(int id, Car car);

    void delete(int id);

}
