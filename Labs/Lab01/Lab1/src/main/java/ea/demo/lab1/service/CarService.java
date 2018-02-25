/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.demo.lab1.service;

import ea.demo.lab1.entity.Car;
import ea.demo.lab1.entity.Color;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author tuvshuu
 */
public class CarService {

    public static void main(String[] args) {
        // Creates an instance of book
        Car car = new Car("Toyota", "Corolla", 2018, 0, Color.RED);
        // Obtains an entity manager and a transaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab1_persistence");
        EntityManager em = emf.createEntityManager();
        // Persists the book to the database
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(car);
        tx.commit();

        em.close();
        emf.close();
    }
}
