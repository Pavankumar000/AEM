package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.LdWrapperImpl;
import com.toyota.tmna.lexusdrivers.core.services.AuthService;
import com.toyota.tmna.lexusdrivers.core.services.impl.AuthServiceImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junit.framework.Assert;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class LdWrapperImplTest {



    MockSlingHttpServletRequest mockSlingHttpServletRequest;
    private final AemContext context = new AemContext();

    LdWrapperImpl ldWrapper;

    @Test
    void getItemOrderTest(){
     ldWrapper = new LdWrapperImpl();
     String[] object = ldWrapper.getExportedItemsOrder();
     Assert.assertNotNull(object);
    }

    @Test
    void getItemTest(){
        ldWrapper = new LdWrapperImpl();
        Map object = ldWrapper.getExportedItems();
        Assert.assertNotNull(object);
    }

    @Test
    void InitTest(){
        MockSlingHttpServletRequest request = context.request();
        AuthService authService = new AuthServiceImpl();
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/SubscriptionImplTest.json", "/content");
        Resource wrapper = context.currentResource("/content");
        ldWrapper = new LdWrapperImpl(request, authService, wrapper);
        ldWrapper.init();
        Map object = ldWrapper.getExportedItems();
        Assert.assertNotNull(object);
    }

    @Test
    void getItemTestNullResource(){
        MockSlingHttpServletRequest request = context.request();
        AuthService authService = new AuthServiceImpl();
        ldWrapper = new LdWrapperImpl(request, authService, null);
        ldWrapper.init();
    }

}
