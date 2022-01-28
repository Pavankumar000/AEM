package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.WelcomeexperienceImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class WelcomeexperienceImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private WelcomeexperienceImpl highlighted;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(WelcomeexperienceImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/WelcomeexperienceImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        highlighted = context.request().adaptTo(WelcomeexperienceImpl.class);
    }

    @Test
    void getWelcomeTitle() {
        String expected = "welcomeTitle";
        String actual = highlighted.getWelcomeTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getExploreTitle() {
        String expected = "exploreTitle";
        String actual = highlighted.getExploreTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getBodyWithVehicle() {
        String expected = "bodyWithVehicle";
        String actual = highlighted.getBodyWithVehicle();
        assertEquals(expected, actual);
    }

    @Test
    void getBodyWithoutVehicle() {
        String expected = "bodyWithoutVehicle";
        String actual = highlighted.getBodyWithoutVehicle();
        assertEquals(expected, actual);
    }

    @Test
    void getWalkThroughButtonText() {
        String expected = "walkThroughButtonText";
        String actual = highlighted.getWalkThroughButtonText();
        assertEquals(expected, actual);
    }

    @Test
    void getSkipButtonText() {
        String expected = "skipButtonText";
        String actual = highlighted.getSkipButtonText();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = highlighted.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getVinValidation() {
        Resource expected = highlighted.getvinValidations();
        assertNotNull(expected);
    }
}
