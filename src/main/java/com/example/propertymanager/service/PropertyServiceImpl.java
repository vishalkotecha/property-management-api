package com.example.propertymanager.service;

import com.example.propertymanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.propertymanager.dao.PropertyDao;
import com.example.propertymanager.entity.Property;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private static final String INVALID_REQUEST = "Invalid request";
    private static final String PROPERTY_NOT_FOUND = "Property not found";
    private static final String PROPERTY_TYPE_NOT_FOUND = "Invalid Property type";
    private static final String ADDRESS_LENGTH_NOT_ENOUGH = "Address length should be more than 10 and less than equals to 255 ";

    @Autowired
    private PropertyDao propertyDao;

    @Transactional
    @Override
    public Property create(AddUpdatePropertyRequest request) {
        validate(request);
        Property property = Property.builder().address(request.getAddress()).bedrooms(request.getBedrooms()).isApproved(false).type(request.getType()).rent(request.getRent())
                .number(request.getNumber()).build();
        propertyDao.save(property);
        return property;
    }

    @Override
    public Property update(AddUpdatePropertyRequest request) {
        validate(request);
        Property property = propertyDao.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, PROPERTY_NOT_FOUND));

        property.setAddress(request.getAddress());
        property.setBedrooms(request.getBedrooms());
        property.setNumber(request.getNumber());
        property.setRent(request.getRent());
        property.setType(request.getType());

        return propertyDao.save(property);
    }

    private void validate(AddUpdatePropertyRequest request) {
        if (request == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, INVALID_REQUEST);
        }

        if (request.getAddress().length() < 10 || request.getAddress().length() > 255) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, PROPERTY_TYPE_NOT_FOUND);
        }

        if(!PropertyTypes.exists(request.getType())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ADDRESS_LENGTH_NOT_ENOUGH);
        }
    }

    @Override
    public List<PropertySearchResponse> search(SearchPropertyRequest request) {
        return propertyDao.findPropertiesByRentOrBedrooms(request.getRent(), request.getBedrooms())
                .stream().map(property -> PropertySearchResponse.builder().id(property.getId()).number(property.getNumber())
                        .address(property.getAddress()).bedrooms(property.getBedrooms()).isApproved(property.isApproved())
                        .rent(property.getRent()).type(property.getType()).build())
                .collect(Collectors.toList());
    }

    @Override
    public PropertyApproveResponse approve(Long propertyId) {
        Property property = propertyDao.findById(propertyId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, PROPERTY_NOT_FOUND));

        property.setApproved(true);
        Property approvedProperty = propertyDao.save(property);
        return new PropertyApproveResponse(approvedProperty.isApproved());
    }

}
