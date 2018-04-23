/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab10.mb;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tuvshuu
 */
@ApplicationScoped
public class ApplicationMB {

    /**
     * Creates a new instance of ApplicationMB
     */
    @PersistenceContext
    private EntityManager em;

    public ApplicationMB() {
    }

    public EntityManager getEm() {
        return em;
    }

}
