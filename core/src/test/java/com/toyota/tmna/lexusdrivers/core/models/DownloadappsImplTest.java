package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.DownloadappsImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class DownloadappsImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private DownloadappsImpl downloadapps;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(DownloadappsImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/DownloadappsImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        downloadapps = context.request().adaptTo(DownloadappsImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "title";
        String actual = downloadapps.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = downloadapps.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getNavLinks() {
        Resource expected = downloadapps.getDownloadLinks();
        assertNull(expected);
    }
}
