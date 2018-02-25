/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import ea.demo.demo01_entities.entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tuvshuu
 */
public class MyFirstPersisterTest {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(
            "Demo01_EntityPU");
    private EntityManager em;
    private EntityTransaction tx;

    public MyFirstPersisterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }

    @After
    public void tearDown() {
        if (em != null) {
            em.close();
        }
    }

    @Test
    public void findStudent() throws Exception {
        System.out.println("call findStudent()");
        Student stud = em.find(Student.class, 1L);
        assertEquals("Jack", stud.getName());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
