/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab2.service;

import java.util.Arrays;
import mum.de.ea.lab2.entity.Laptop;
import mum.de.ea.lab2.entity.Notebook;
import mum.de.ea.lab2.entity.Student;
import mum.de.ea.lab2.entity.Teacher;

/**
 *
 * @author tuvshuu
 */
public class Lab2Service {

    public static void main(String[] args) {
        MyCRUD dbService = new MyCRUD();

        /**
         * PERSIST the instances
         */
        Student studentJack = new Student();
        studentJack.setGpa(Double.MAX_VALUE);
        studentJack.setName("Jack");
        studentJack.setGpa(3.4);
        studentJack.setNotebooks(Arrays.asList(new Notebook(100), new Notebook(120), new Notebook(60)));
        dbService.saveStudent(studentJack);

        Student studentJohn = new Student();
        studentJohn.setName("John");
        studentJohn.setGpa(3.2);
        studentJohn.setNotebooks(Arrays.asList(new Notebook(200), new Notebook(50)));
        dbService.saveStudent(studentJohn);

        Student studentJill = new Student();
        studentJill.setName("Jill");
        studentJill.setGpa(3.6);
        dbService.saveStudent(studentJill);

        Teacher teacherJim = new Teacher();
        teacherJim.setName("Jim");
        teacherJim.setSalary(45000.0);
        teacherJim.setLaptop(new Laptop("Dell"));
        dbService.saveTeacher(teacherJim);

        Teacher teacherJasmin = new Teacher();
        teacherJasmin.setName("Jasmin");
        teacherJasmin.setSalary(46000.0);
        teacherJasmin.setLaptop(new Laptop("Mac"));
        dbService.saveTeacher(teacherJasmin);

        // REMOVE
        System.out.println("Result of remove action - " + dbService.deleteStudent(8));

        // CLOSE
        dbService.close();
    }
}
