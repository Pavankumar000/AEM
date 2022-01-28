package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.ResendactivationemailImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })

class ResendactivationemailImplTest {
    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private ResendactivationemailImpl raei;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(ResendactivationemailImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ResendactivationemailImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content/resendactivationemai");
        raei = context.request().adaptTo(ResendactivationemailImpl.class);

    }

    @Test
    void getSendEmailLabel() {
        String expected = "EMAIL";
        String actual = raei.getSendEmailLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getNeedMoreHelp() {
        String expected = "NEED MORE HELP? CONTACT US.";
        String actual = raei.getNeedMoreHelp();
        assertEquals(expected, actual);
    }

    @Test
    void getSuccessPage() {
        String expected = "/content/lexusdrivers/us/en/resend-activation-email-sucess";
        String actual = raei.getSuccessPage();
        assertEquals(expected, actual);
    }

    @Test
    void getemailField() {
        String expected = "EMAIL";
        String actual = raei.getEmailField();
        assertEquals(expected, actual);
    }

    

    @Test
    void getExportedType() {
        String expected = "nt:unstructured";
        String actual = raei.getExportedType();
        assertEquals(expected, actual);
    }
    
    @Test
    void getRules(){
    	Resource expected = context.resourceResolver().getResource("/content/resendactivationemai/rules");
    	raei = context.request().adaptTo(ResendactivationemailImpl.class);
		assert raei != null;
		Resource actual = raei.getRules();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
    }

}