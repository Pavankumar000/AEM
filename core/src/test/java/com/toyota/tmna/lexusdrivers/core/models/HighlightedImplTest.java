package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.HighlightedImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.sling.api.resource.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class HighlightedImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private HighlightedImpl highlighted;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(HighlightedImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/HighlightedImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        highlighted = context.request().adaptTo(HighlightedImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "Title";
        String actual = highlighted.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getTiles() {
        Resource expected = highlighted.getTiles();
        assertNotNull(expected);
    }

    @Test
    void getExportedType() {
        String expected = highlighted.getExportedType();
        assertNotNull(expected);
    }
}
