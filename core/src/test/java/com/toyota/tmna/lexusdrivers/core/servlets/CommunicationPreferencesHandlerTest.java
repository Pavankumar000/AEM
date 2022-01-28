package com.toyota.tmna.lexusdrivers.core.servlets;

import com.toyota.tmna.lexusdrivers.core.bean.UserInfo;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(AemContextExtension.class)
public class CommunicationPreferencesHandlerTest {
    private final AemContext context = new AemContext();
    CommunicationPreferencesHandler servlet = new CommunicationPreferencesHandler();
    MockSlingHttpServletRequest request;
    MockSlingHttpServletResponse response;

    @BeforeEach
    void setUp() throws NoSuchFieldException {
        context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/CommunicationPreferencesHandlerTest.json",
                "/content/dam/lexusdrivers/content-fragments/communicationpreferences/CPID.dcr/jcr:content/data/master");
        Resource resource = context.currentResource("/content/dam/lexusdrivers/content-fragments/communicationpreferences/CPID.dcr/jcr:content/data/master");
        request = context.request();
        request.setResource(resource);
        response = context.response();
    }

    @Test
    public void checkCommunicationPreferencesHandler() throws ServletException, IOException {
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

    @Test
    public void checkCommunicationPreferencesHandlerWithId() throws ServletException, IOException {
        request.addRequestParameter("CPID", "CPID");
        servlet.doGet(request, response);
        assertEquals(200, response.getStatus());
    }

}
