package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.MileagegraphImpl;
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
public class MileagegraphImplTest {
    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private MileagegraphImpl mileagegraph;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(MileagegraphImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/MileagegraphImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        mileagegraph = context.request().adaptTo(MileagegraphImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "title";
        String actual = mileagegraph.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void geterorMessage() {
        String expected = "erorMessage";
        String actual = mileagegraph.getErorMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = mileagegraph.getExportedType();
        assertNotNull(expected);
    }

}
