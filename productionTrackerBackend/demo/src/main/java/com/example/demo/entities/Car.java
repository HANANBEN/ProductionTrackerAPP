package com.example.demo.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private String carPlate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(String plaqueImmatriculation) {
        this.carPlate = plaqueImmatriculation;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date dateLivraison) {
        this.deliveryDate = dateLivraison;
    }
}

