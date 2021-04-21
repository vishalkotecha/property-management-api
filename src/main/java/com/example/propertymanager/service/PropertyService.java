package com.example.propertymanager.service;

import com.example.propertymanager.entity.Property;
import com.example.propertymanager.model.AddUpdatePropertyRequest;
import com.example.propertymanager.model.PropertyApproveResponse;
import com.example.propertymanager.model.SearchPropertyRequest;

public interface PropertyService {

    Property create(AddUpdatePropertyRequest request);

    Property update(AddUpdatePropertyRequest request);

    PropertySearchResponse search(SearchPropertyRequest request);

    PropertyApproveResponse approve(Long propertyId);
}
