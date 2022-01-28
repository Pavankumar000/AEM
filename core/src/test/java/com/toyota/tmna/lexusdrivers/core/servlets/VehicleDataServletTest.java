package com.toyota.tmna.lexusdrivers.core.servlets;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.apache.sling.servlethelpers.MockSlingHttpServletResponse;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.google.gson.JsonObject;
import com.toyota.tmna.lexusdrivers.core.bean.VehicleDataTags;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class VehicleDataServletTest {
    VehicleDataServlet servlet = new VehicleDataServlet();
    MockSlingHttpServletRequest request;
    MockSlingHttpServletResponse response;
    private final AemContext context = new AemContext();
    final String PARAM_YEAR = "year";
    final String PARAM_MODEL = "model";
    final String PARAM_CODE = "code";
    final String PARAM_TRIM = "trim";
    final String PARAM_TYPE = "type";
    final String TYPE_VALUE = "banner,jelly,trim,vhr,all";

    @BeforeEach
    void setUp() throws NoSuchFieldException {
        request = context.request();
        request.addRequestParameter(PARAM_YEAR, PARAM_YEAR);
        request.addRequestParameter(PARAM_MODEL, PARAM_MODEL);
        request.addRequestParameter(PARAM_CODE, PARAM_CODE);
        request.addRequestParameter(PARAM_TRIM, PARAM_TRIM);
        request.addRequestParameter(PARAM_TYPE, TYPE_VALUE);
        response = context.response();
    }

    @Test
    public void checkVehicleData() throws ServletException, IOException {
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void checkMultipleVehicleDataFSports() throws ServletException, IOException {
        final String PARAM_MULTIPLE_VEHICLE = "multipleVehicles";
        request.addRequestParameter(PARAM_MULTIPLE_VEHICLE, "year:year;model:-FSport;code:code;trim:trim");
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void checkMultipleVehicleData() throws ServletException, IOException {
        final String PARAM_MULTIPLE_VEHICLE = "multipleVehicles";
        request.addRequestParameter(PARAM_MULTIPLE_VEHICLE, "year:year;model:model;code:code;trim:trim");
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void setVehicleDataTest(){
        String params = "year:year;model:-FSport;trim:trim;";
        MockSlingHttpServletRequest request2;
        request2 = context.request();
        request2.addRequestParameter(PARAM_YEAR, PARAM_YEAR);
        request2.addRequestParameter(PARAM_MODEL, PARAM_MODEL);
        request2.addRequestParameter(PARAM_CODE, PARAM_CODE);
        request2.addRequestParameter(PARAM_TRIM, PARAM_TRIM);
        VehicleDataTags tags = new VehicleDataTags(params,request2);
        servlet.setVehicleData(null, "type", new JsonObject(), request2, tags);
    }
	
    @Test
	public void testgetFeatureData() {
		  JsonObject vehicle = new JsonObject();
		  ValueMap props=new ValueMapDecorator(new HashMap<String, Object>());
		  servlet.setVehicleJson("feature", null, null, null , props, null, request, vehicle);
    }

    @Test
    public void testgetFeatureDataBannerData() {
        JsonObject vehicle = new JsonObject();
        ValueMap props=new ValueMapDecorator(new HashMap<String, Object>());
        props.put("DesktopImage","DesktopImage");
        servlet.setVehicleJson("banner", props, null, null, props, null, request, vehicle);
    }

    @Test
    public void testgetFeatureDataVHR() {
        String params = "year:year;model:-FSport;trim:trim;";
        JsonObject vehicle = new JsonObject();
        ValueMap props=new ValueMapDecorator(new HashMap<String, Object>());
        props.put("DesktopImage","DesktopImage");
        MockSlingHttpServletRequest request2;
        request2 = context.request();
        request2.addRequestParameter(PARAM_YEAR, PARAM_YEAR);
        request2.addRequestParameter(PARAM_MODEL, PARAM_MODEL);
        request2.addRequestParameter(PARAM_CODE, PARAM_CODE);
        request2.addRequestParameter(PARAM_TRIM, PARAM_TRIM);
        VehicleDataTags tags = new VehicleDataTags(params,request2);
        servlet.setVehicleJson("all", props, props, props, props, tags, request, vehicle);
    }

	 

}
