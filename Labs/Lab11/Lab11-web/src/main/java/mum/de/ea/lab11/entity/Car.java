/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.de.ea.lab11.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author tuvshuu
 */
@Entity
@Table(name = "Car_lab10")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String Make;
    private String Model;
    @Column(name = "ManufacturingYear")
    private int Year;
    private int Miles;
    @Enumerated(EnumType.STRING)
    private Color color;

    @Version
    private Integer version;

    public Car() {
    }

    public Car(String Make, String Model, int Year, int Miles, Color color) {
        this.Make = Make;
        this.Model = Model;
        this.Year = Year;
        this.Miles = Miles;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String Make) {
        this.Make = Make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public int getMiles() {
        return Miles;
    }

    public void setMiles(int Miles) {
        this.Miles = Miles;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", Make=" + Make + ", Model=" + Model + ", Year=" + Year + ", Miles=" + Miles + ", color=" + color + ", version=" + version + '}';
    }

//    @PostUpdate
//    private void printInfo() {
//        System.out.println("Car information has been updated. ID - " + this.id);
//    }
}
