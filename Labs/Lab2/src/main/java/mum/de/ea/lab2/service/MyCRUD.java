/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab2.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import mum.de.ea.lab2.entity.Student;
import mum.de.ea.lab2.entity.Teacher;

/**
 *
 * @author tuvshuu
 */
public class MyCRUD {

    EntityManagerFactory emf = null;
    EntityManager em = null;

    public MyCRUD() {
        emf = Persistence.createEntityManagerFactory("mum.de.ea.lab2_PU");;
        em = emf.createEntityManager();
    }

    void close() {
        em.close();
        emf.close();
    }

    boolean deleteStudent(int studentId) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createQuery("DELETE FROM Lab2_Student s WHERE s.id = :id");
        int deletedCount = query.setParameter("id", studentId).executeUpdate();
        tx.commit();
        return deletedCount > 0;
    }

    void saveStudent(Student student) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        tx.commit();
    }

    void saveTeacher(Teacher teacher) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(teacher);
        tx.commit();
    }
}
