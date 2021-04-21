package com.example.propertymanager.service;

import com.example.propertymanager.entity.Property;
import com.example.propertymanager.model.AddUpdatePropertyRequest;
import com.example.propertymanager.model.PropertyApproveResponse;
import com.example.propertymanager.model.PropertySearchResponse;
import com.example.propertymanager.model.SearchPropertyRequest;

import java.util.List;

public interface PropertyService {

    Property create(AddUpdatePropertyRequest request);

    Property update(AddUpdatePropertyRequest request);

    List<PropertySearchResponse> search(SearchPropertyRequest request);

    PropertyApproveResponse approve(Long propertyId);
}
