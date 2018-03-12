/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab2.entity;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author tuvshuu
 */
@Entity(name = "Lab2_Student")
@DiscriminatorValue("S")
public class Student extends Person {

    @Id
    @GeneratedValue
    private Long id;
    private Double gpa;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Notebook> notebooks;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Collection<Notebook> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(Collection<Notebook> notebooks) {
        this.notebooks = notebooks;
    }

}
