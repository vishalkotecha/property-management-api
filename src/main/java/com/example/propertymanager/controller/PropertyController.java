package com.example.propertymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.propertymanager.entity.Property;
import com.example.propertymanager.model.AddUpdatePropertyRequest;
import com.example.propertymanager.model.PropertyApproveResponse;
import com.example.propertymanager.model.SearchPropertyRequest;
import com.example.propertymanager.model.PropertySearchResponse;
import com.example.propertymanager.service.PropertyService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<Property> create(@RequestBody AddUpdatePropertyRequest request) {
        Property response = propertyService.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<Property> update(@RequestBody AddUpdatePropertyRequest request) {
        Property response = propertyService.update(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/_list")
    public ResponseEntity<List<PropertySearchResponse>> search(@RequestBody SearchPropertyRequest request) {
        List<PropertySearchResponse> response = propertyService.search(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/approve/{propertyId}")
    public ResponseEntity<PropertyApproveResponse> approve(@PathVariable Long propertyId) {
        PropertyApproveResponse response = propertyService.approve(propertyId);
        return ResponseEntity.ok(response);
    }

}
