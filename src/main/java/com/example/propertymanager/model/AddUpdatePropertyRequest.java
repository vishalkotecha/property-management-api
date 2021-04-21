package com.example.propertymanager.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class AddUpdatePropertyRequest {
    
    private Long id;
    private String number;
    private String address;
    private int bedrooms;
    private boolean isApproved;
    private double rent;
    private int type; // flat, independent house, villa

}
