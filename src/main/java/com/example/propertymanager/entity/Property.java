package com.example.propertymanager.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Builder(toBuilder = true)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String address;
    private int bedrooms;
    private boolean isApproved;
    private double rent;
    private int type; // flat, bungalow, villa
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
