package com.example.propertymanager.model;

import lombok.*;

@Builder(toBuilder = true)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropertySearchResponse{

    private Long id;
    private String number;
    private String address;
    private int bedrooms;
    private boolean isApproved;
    private double rent;
    private int type;
}
