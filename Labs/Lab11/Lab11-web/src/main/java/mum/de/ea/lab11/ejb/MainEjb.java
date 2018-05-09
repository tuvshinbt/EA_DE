/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab11.ejb;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuvshuu
 */
@Singleton
public class MainEjb {

    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

}
