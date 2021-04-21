package com.example.propertymanager;

import com.example.propertymanager.dao.PropertyDao;
import com.example.propertymanager.entity.Property;
import com.example.propertymanager.model.AddUpdatePropertyRequest;
import com.example.propertymanager.model.PropertyApproveResponse;
import com.example.propertymanager.model.PropertySearchResponse;
import com.example.propertymanager.model.SearchPropertyRequest;
import com.example.propertymanager.service.PropertyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceImplTest {

    @InjectMocks
    private PropertyServiceImpl propertyService;

    @Mock
    private PropertyDao propertyDao;

    @Test(expected = Exception.class)
    public void create_invalid_request_test() {

        Property propertyRequest = new Property();
        propertyRequest.setNumber("78-79");
        propertyRequest.setAddress("USA");
        propertyRequest.setRent(150);
        propertyRequest.setApproved(false);
        propertyRequest.setType(1);

        Property propertyResponse = new Property();
        propertyResponse.setId(1L);

        propertyService.create(null);
    }

    @Test(expected = Exception.class)
    public void create_invalid_address_test() {

        AddUpdatePropertyRequest addUpdatePropertyRequest = new AddUpdatePropertyRequest();
        addUpdatePropertyRequest.setNumber("78-79");
        addUpdatePropertyRequest.setAddress("USA");
        addUpdatePropertyRequest.setRent(150);
        addUpdatePropertyRequest.setType(1);

        Property propertyRequest = new Property();
        propertyRequest.setNumber("78-79");
        propertyRequest.setAddress("USA");
        propertyRequest.setRent(150);
        propertyRequest.setApproved(false);
        propertyRequest.setType(1);

        Property propertyResponse = new Property();
        propertyResponse.setId(1L);

        propertyService.create(addUpdatePropertyRequest);
    }

    @Test(expected = Exception.class)
    public void create_invalid_type_test() {

        AddUpdatePropertyRequest addUpdatePropertyRequest = new AddUpdatePropertyRequest();
        addUpdatePropertyRequest.setNumber("78-79");
        addUpdatePropertyRequest.setAddress("Down Street, USA");
        addUpdatePropertyRequest.setRent(150);
        addUpdatePropertyRequest.setType(0);

        Property propertyRequest = new Property();
        propertyRequest.setNumber("78-79");
        propertyRequest.setAddress("USA");
        propertyRequest.setRent(150);
        propertyRequest.setApproved(false);
        propertyRequest.setType(0);

        Property propertyResponse = new Property();
        propertyResponse.setId(1L);

        propertyService.create(addUpdatePropertyRequest);
    }

    @Test
    public void create_success_test() {

        AddUpdatePropertyRequest addUpdatePropertyRequest = new AddUpdatePropertyRequest();
        addUpdatePropertyRequest.setNumber("78-79");
        addUpdatePropertyRequest.setAddress("Down Street, USA");
        addUpdatePropertyRequest.setRent(150);
        addUpdatePropertyRequest.setType(1);

        Property propertyRequest = new Property();
        propertyRequest.setNumber("78-79");
        propertyRequest.setAddress("USA");
        propertyRequest.setRent(150);
        propertyRequest.setApproved(false);
        propertyRequest.setType(1);

        Long propertyId = 1L;
        Property propertyResponse = new Property();
        propertyResponse.setId(propertyId);

        propertyService.create(addUpdatePropertyRequest);
    }

    @Test
    public void update_success_test() {

        long propertyId = 1L;

        AddUpdatePropertyRequest addUpdatePropertyRequest = new AddUpdatePropertyRequest();
        addUpdatePropertyRequest.setId(propertyId);
        addUpdatePropertyRequest.setNumber("78-79");
        addUpdatePropertyRequest.setAddress("Down Street, USA");
        addUpdatePropertyRequest.setRent(150);
        addUpdatePropertyRequest.setType(1);

        Property propertyRequest = new Property();
        propertyRequest.setId(propertyId);
        propertyRequest.setNumber("78-79");
        propertyRequest.setAddress("USA");
        propertyRequest.setRent(150);
        propertyRequest.setApproved(false);
        propertyRequest.setType(1);

        Property propertyResponse = new Property();
        propertyResponse.setId(propertyId);

        when(propertyDao.findById(propertyId)).thenReturn(Optional.of(propertyRequest));
        when(propertyDao.save(propertyRequest)).thenReturn(propertyResponse);

        propertyService.update(addUpdatePropertyRequest);
    }

    @Test
    public void search_with_non_existing_data_test() {
        SearchPropertyRequest request = new SearchPropertyRequest();
        request.setBedrooms(10);
        request.setRent(15000);

        when(propertyDao.findPropertiesByRentOrBedrooms(15000, 10)).thenReturn(new ArrayList<>());

        List<PropertySearchResponse> actualResponse = propertyService.search(request);
        assertTrue(actualResponse.isEmpty());
    }

    @Test
    public void search_test() {
        SearchPropertyRequest request = new SearchPropertyRequest();
        request.setBedrooms(1);
        request.setRent(150);

        List<PropertySearchResponse> expectedResponse = new ArrayList<>();
        PropertySearchResponse propertySearchResponse = new PropertySearchResponse();
        propertySearchResponse.setId(1L);
        propertySearchResponse.setNumber("78-79");
        propertySearchResponse.setAddress("USA");
        propertySearchResponse.setRent(150);
        propertySearchResponse.setApproved(false);
        propertySearchResponse.setType(1);
        expectedResponse.add(propertySearchResponse);

        Property property = new Property();
        property.setId(1L);
        property.setNumber("78-79");
        property.setAddress("USA");
        property.setRent(150);
        property.setApproved(false);
        property.setType(1);
        List<Property> properties = new ArrayList<>();
        properties.add(property);

        when(propertyDao.findPropertiesByRentOrBedrooms(150, 1)).thenReturn(properties);

        List<PropertySearchResponse> actualResponse = propertyService.search(request);
        assertEquals(actualResponse.size(), expectedResponse.size());
    }

    @Test(expected = Exception.class)
    public void approve_property_id_not_found_test() {
        propertyService.approve(1L);
    }

    @Transactional
    @Test
    public void approve_success_test() {

        Long propertyId = 1L;

        Property property = new Property();
        property.setId(propertyId);
        property.setNumber("78-79");
        property.setAddress("USA");
        property.setRent(150);
        property.setApproved(false);
        property.setType(1);

        when(propertyDao.findById(propertyId)).thenReturn(Optional.of(property));
        when(propertyDao.save(property)).thenReturn(property);

        PropertyApproveResponse response = propertyService.approve(propertyId);
        assertTrue(response.isApproved());
    }
}
