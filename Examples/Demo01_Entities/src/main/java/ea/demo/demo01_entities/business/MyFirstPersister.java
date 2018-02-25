/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ea.demo.demo01_entities.business;

import ea.demo.demo01_entities.entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author tuvshuu
 */
public class MyFirstPersister {

    private EntityManagerFactory emf;
    private EntityManager em;

    public MyFirstPersister() {
        emf = Persistence.createEntityManagerFactory("Demo01_EntityPU");
        em = emf.createEntityManager();
    }

    public void start() {
        if (emf != null) {
            end();
        }
        emf = Persistence.createEntityManagerFactory("Demo01_EntityPU");
        em = emf.createEntityManager();
    }

    public void end() {
        if (emf != null) {
            em.close();
            emf.close();
            emf = null;
        }
    }

    public void save(Student student) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        tx.commit();
    }

    public static void main(String[] args) {
        Student jack = new Student("Jack");
        jack.setCoursesTaken(5);
        jack.setGpa(3.3f);
        MyFirstPersister persister = new MyFirstPersister();
        persister.save(jack);
        persister.end();
    }
}
