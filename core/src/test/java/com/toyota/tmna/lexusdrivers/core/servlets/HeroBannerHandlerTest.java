package com.toyota.tmna.lexusdrivers.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(AemContextExtension.class)
public class HeroBannerHandlerTest {

    private final AemContext context = new AemContext();
    HeroBannerHandler servlet = new HeroBannerHandler();
    MockSlingHttpServletRequest request;
    org.apache.sling.servlethelpers.MockSlingHttpServletResponse response;

    @BeforeEach
    void setUp() throws NoSuchFieldException {
        context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/HeroBannerHandlerTest.json",
                "/content/dam/lexusdrivers/content-fragments/herobanner");

    }

    @Test
    public void checkDoGet() throws ServletException, IOException {
        context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/HeroBannerHandlerMaster.json",
                "/content/dam/lexusdrivers/content-fragments/herobanner/methodType/jcr:content/data/master");
        request = context.request();
        response = context.response();
        request.addRequestParameter("type", "VIN");
        request.addRequestParameter("model","model");
        request.addRequestParameter("year","year");
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void checkDoGetNoAllMYListForVIN() throws ServletException, IOException {
        context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/HeroBannerHandlerNoAllMY.json",
                "/content/dam/lexusdrivers/content-fragments/herobanner/methodType/jcr:content/data/master");
        request = context.request();
        response = context.response();
        request.addRequestParameter("type", "VIN");
        request.addRequestParameter("model","model");
        request.addRequestParameter("year","year");
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void checkDoGetNoAllMYList() throws ServletException, IOException {
        context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/HeroBannerHandlerNoAllMYNoBannerForVin.json",
                "/content/dam/lexusdrivers/content-fragments/herobanner/methodType/jcr:content/data/master");
        request = context.request();
        response = context.response();
        request.addRequestParameter("type", "MY");
        request.addRequestParameter("model","model");
        request.addRequestParameter("year","year");
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void checkDoGetDefault() throws ServletException, IOException {
        context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/HeroBannerHandlerMaster.json",
                "/content/dam/lexusdrivers/content-fragments/herobanner/methodType/jcr:content/data/master");
        request = context.request();
        response = context.response();
        request.addRequestParameter("type", "default");
        request.addRequestParameter("model","model");
        request.addRequestParameter("year","year");
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void checkDoGetMY() throws ServletException, IOException {
        context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/HeroBannerHandlerMasterNoBannerForVIN.json",
                "/content/dam/lexusdrivers/content-fragments/herobanner/methodType/jcr:content/data/master");
        request = context.request();
        response = context.response();
        request.addRequestParameter("type", "MY");
        request.addRequestParameter("model","model");
        request.addRequestParameter("year","year");
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void checkDoGetNullCheck() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }
}
