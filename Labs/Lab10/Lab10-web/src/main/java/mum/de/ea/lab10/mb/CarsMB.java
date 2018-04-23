/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab10.mb;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mum.de.ea.lab10.entity.Car;

/**
 *
 * @author tuvshuu
 */
@Named(value = "carsMB")
@RequestScoped
public class CarsMB implements Serializable {

    @Inject
    private ApplicationMB amb;

    public CarsMB() {
    }

    public List<Car> getCars() {
        TypedQuery typedQuery = amb.getEm().createQuery("SELECT c FROM Car c", Car.class);
        return typedQuery.getResultList();
    }

}
