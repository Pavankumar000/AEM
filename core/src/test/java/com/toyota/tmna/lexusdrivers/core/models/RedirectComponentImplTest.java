package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.RedirectComponentImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class RedirectComponentImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private RedirectComponentImpl redirectComponent;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(RedirectComponentImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/RedirectComponentImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        redirectComponent = context.request().adaptTo(RedirectComponentImpl.class);
    }

    @Test
    void getaccessType() {
        String expected = "accessType";
        String actual = redirectComponent.getAccessType();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = redirectComponent.getExportedType();
        assertNotNull(expected);
    }


}
