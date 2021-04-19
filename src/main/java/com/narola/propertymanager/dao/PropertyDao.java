package com.narola.propertymanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narola.propertymanager.entity.Property;

public interface PropertyDao extends JpaRepository<Property, Long> {

}
