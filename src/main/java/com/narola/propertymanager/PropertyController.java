package com.narola.propertymanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narola.propertymanager.model.CreatePropertyRequest;
import com.narola.propertymanager.model.PropertyApproveResponse;
import com.narola.propertymanager.model.PropertyResponse;
import com.narola.propertymanager.model.SearchPropertyRequest;
import com.narola.propertymanager.service.PropertySearchResponse;
import com.narola.propertymanager.service.PropertyService;

@RestController
@RequestMapping("/api/v1/properties")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping
    public ResponseEntity<PropertyResponse> create(@RequestBody CreatePropertyRequest request) {
        PropertyResponse response = propertyService.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<PropertyResponse> update(@RequestBody CreatePropertyRequest request) {
        PropertyResponse response = propertyService.create(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/_list")
    public ResponseEntity<PropertySearchResponse> search(@RequestBody SearchPropertyRequest request) {
        PropertySearchResponse response = propertyService.search(request);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping("/approve/{propertyId}")
    public ResponseEntity<PropertyApproveResponse> approve(@PathVariable Long propertyId) {
        PropertyApproveResponse response = propertyService.approve(propertyId);
        return ResponseEntity.ok(response);
    }

}
