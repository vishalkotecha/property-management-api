package com.example.propertymanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.propertymanager.dao.PropertyDao;
import com.example.propertymanager.entity.Property;
import com.example.propertymanager.model.AddUpdatePropertyRequest;
import com.example.propertymanager.model.PropertyApproveResponse;
import com.example.propertymanager.model.PropertyTypes;
import com.example.propertymanager.model.SearchPropertyRequest;

@Service
public class PropertyServiceImpl implements PropertyService {

    private static final String PROPERTY_NOT_FOUND = "Property not found";
    private static final String PROPERTY_TYPE_NOT_FOUND = "Invalid Property type";
    @Autowired
    private PropertyDao propertyDao;

    @Override
    public Property create(AddUpdatePropertyRequest request) {
        validate(request);
        Property property = Property.builder().address(request.getAddress()).bedrooms(request.getBedrooms()).isApproved(request.isApproved()).type(request.getType()).rent(request.getRent())
                .number(request.getNumber()).build();
        propertyDao.save(property);
        return property;
    }

    @Override
    public Property update(AddUpdatePropertyRequest request) {
        validate(request);
        Property property = propertyDao.findById(request.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, PROPERTY_NOT_FOUND));
        // TODO
        return null;
    }

    private void validate(AddUpdatePropertyRequest request) {
        if(!PropertyTypes.exists(request.getType())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PROPERTY_TYPE_NOT_FOUND);
        }
    }

    @Override
    public PropertySearchResponse search(SearchPropertyRequest request) {
        return null;

    }

    @Override
    public PropertyApproveResponse approve(Long propertyId) {
        return null;

    }

}
