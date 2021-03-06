package com.example.propertymanager.model;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class AddUpdatePropertyRequest {
    
    private Long id;
    private String number;
    private String address;
    private int bedrooms;
    private boolean isApproved = false;
    private double rent;
    private int type; // flat, independent house, villa

}
