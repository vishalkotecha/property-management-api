package com.narola.propertymanager.service;

import com.narola.propertymanager.model.CreatePropertyRequest;
import com.narola.propertymanager.model.PropertyApproveResponse;
import com.narola.propertymanager.model.PropertyResponse;
import com.narola.propertymanager.model.SearchPropertyRequest;
import com.narola.propertymanager.model.UpdatePropertyRequest;

public interface PropertyService {

   PropertyResponse create(CreatePropertyRequest request);
   PropertyResponse update(UpdatePropertyRequest request);
   PropertySearchResponse search(SearchPropertyRequest request);
   PropertyApproveResponse approve(Long propertyId);
}
