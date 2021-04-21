package com.example.propertymanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.propertymanager.entity.Property;

public interface PropertyDao extends JpaRepository<Property, Long> {

}
