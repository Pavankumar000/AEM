package com.toyota.tmna.lexusdrivers.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
public class LPSHandlerTest {
    private final AemContext context = new AemContext();
    LPSHandler servlet = new LPSHandler();
    MockSlingHttpServletRequest request;
    org.apache.sling.servlethelpers.MockSlingHttpServletResponse response;

    @BeforeEach
    void setUp() throws NoSuchFieldException {
        context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/LPSHandlerServletTest.json",
                "/content/dam/lexusdrivers/content-fragments/lps/year/model");
        request = context.request();
        response = context.response();
    }

    @Test
    public void checkLPS() throws ServletException, IOException {

        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void checkLPSID() throws ServletException, IOException {
        request.addRequestParameter("LPSID", "model-year");
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

}
