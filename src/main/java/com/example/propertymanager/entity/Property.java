package com.example.propertymanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String address;
    private int bedrooms;
    private boolean isApproved;
    private double rent;
    private int type; // flat, independent house, villa
}
