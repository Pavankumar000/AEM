package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.VinlookuppanelImpl;
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
public class VinlookuppanelImplTest {
    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private VinlookuppanelImpl vinlookuppanel;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(VinlookuppanelImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/VinlookuppanelImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        vinlookuppanel = context.request().adaptTo(VinlookuppanelImpl.class);

    }

    @Test
    void getTitle() {
        String expected = "title";
        String actual = vinlookuppanel.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = vinlookuppanel.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getUrl() {
        assertEquals("successURL", vinlookuppanel.getSuccessURL());
    }
}
