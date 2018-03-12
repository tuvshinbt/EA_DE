/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author tuvshuu
 */
@Entity(name = "Lab2_Notebook")
public class Notebook {

    @Id
    @GeneratedValue
    private Long id;
    private Integer totalPageNmbr;

    public Notebook() {
    }

    public Notebook(Integer totalPageNmbr) {
        this.totalPageNmbr = totalPageNmbr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotalPageNmbr() {
        return totalPageNmbr;
    }

    public void setTotalPageNmbr(Integer totalPageNmbr) {
        this.totalPageNmbr = totalPageNmbr;
    }

}
