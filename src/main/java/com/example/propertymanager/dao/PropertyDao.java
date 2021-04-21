package com.example.propertymanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.propertymanager.entity.Property;

import java.util.List;

public interface PropertyDao extends JpaRepository<Property, Long> {

    List<Property> findPropertiesByRentOrBedrooms(double rent, int bedrooms);
}
