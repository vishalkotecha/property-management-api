package com.narola.propertymanager.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreatePropertyRequest {
    
    private String number;
    private String address;
    private int rooms;
    private boolean isApproved;

}
