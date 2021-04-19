package com.narola.propertymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Property {

    @Id
    private Long id;
    private String number;
    private String address;
    private int bedrooms;
    private boolean isApproved;
    private double rent;
    private int type; // flat, independent house, villa
}
