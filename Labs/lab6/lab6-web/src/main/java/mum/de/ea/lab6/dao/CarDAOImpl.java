/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab6.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mum.de.ea.lab6.entity.Car;

/**
 *
 * @author tuvshuu
 */
public class CarDAOImpl implements CarDAO {

    public CarDAOImpl() {
    }

    EntityManagerFactory emf = null;
    EntityManager em = null;
    EntityTransaction tx = null;

    private void open() {
        emf = Persistence.createEntityManagerFactory("mum.de.ea_lab6-web_war_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    private void close() {
        tx.commit();
        em.close();
        emf.close();
    }

    @Override
    public List<Car> findAll() {
        open();
        Query query = em.createQuery("SELECT c FROM CarTbl c");
        List<Car> cars = (List<Car>) query.getResultList();
        close();
        return cars;
    }

    @Override
    public Car findById(int id) {
        open();
        Car car = (Car) em.find(Car.class, id);
        close();
        return car;
    }

    @Override
    public Integer create(Car car) {
        open();
        em.persist(car);
        em.flush();
        close();
        return car.getId();
    }

    @Override
    public void update(int id, Car car) {
        open();
        Car oldCar = em.find(Car.class, id);
        if (oldCar != null) {
            oldCar.setMake(car.getMake());
            oldCar.setModel(car.getModel());
            oldCar.setMiles(car.getMiles());
            oldCar.setYear(car.getYear());
            em.persist(oldCar);
        }
        close();
    }

    @Override
    public void delete(int id) {
        open();
        Car oldCar = em.find(Car.class, id);
        if (oldCar != null) {
            em.remove(oldCar);
        }
        close();
    }

}
