package com.toyota.tmna.lexusdrivers.core.models;


import com.toyota.tmna.lexusdrivers.core.models.impl.ManualsImpl;
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
public class ManualsImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private ManualsImpl manuals;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(ManualsImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ManualsImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        manuals = context.request().adaptTo(ManualsImpl.class);
    }

    @Test
    void getIcon() {
        String expected = "icon";
        String actual = manuals.getIcon();
        assertEquals(expected, actual);
    }
    @Test
    void getIconList() {
        String expected = "iconList";
        String actual = manuals.getIconList();
        assertEquals(expected, actual);
    }

    @Test
    void getTitle() {
        String expected = "title";
        String actual = manuals.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getType() {
        String expected = "type";
        String actual = manuals.getType();
        assertEquals(expected, actual);
    }

    @Test
    void getManualType() {
        String expected = "manualtype";
        String actual = manuals.getManualtype();
        assertEquals(expected, actual);
    }

    @Test
    void getNoServiceDataMessage() {
        String expected = "noServiceDataMessage";
        String actual = manuals.getNoServiceDataMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getNoVehicleSelectedMessage() {
        String expected = "noVehicleSelectedMessage";
        String actual = manuals.getNoVehicleSelectedMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getNextgenIconText() {
        String expected = "nextgenIconText";
        String actual = manuals.getnextgenIconText();
        assertEquals(expected, actual);
    }

    @Test
    void getWarrantyPeriod() {
        String expected = "warrantyPeriod";
        String actual = manuals.getWarrantyPeriod();
        assertEquals(expected, actual);
    }

    @Test
    void getMilesText() {
        String expected = "milesText";
        String actual = manuals.getMilesText();
        assertEquals(expected, actual);
    }

    @Test
    void getWarrantyMessage() {
        String expected = "warrantyMessage";
        String actual = manuals.getwarrantyMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = manuals.getExportedType();
        assertNotNull(expected);
    }
}
