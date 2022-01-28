package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.NovehicletileImpl;
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
public class NovehicletileImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private NovehicletileImpl novehicletile;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(NovehicletileImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/NovehicletileImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        novehicletile = context.request().adaptTo(NovehicletileImpl.class);
    }

    @Test
    void getMilageTest() {
        String expected = "milage";
        String actual = novehicletile.getMilage();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = novehicletile.getExportedType();
        assertNotNull(expected);
    }
}
