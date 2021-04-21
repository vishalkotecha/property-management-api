package com.example.propertymanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchPropertyRequest {

    private double rent;
    private int bedrooms;
}
