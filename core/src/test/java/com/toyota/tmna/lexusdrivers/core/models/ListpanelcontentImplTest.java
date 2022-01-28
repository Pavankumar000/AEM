package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.AddVINTileImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.ListpanelcontentImpl;
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
public class ListpanelcontentImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private ListpanelcontentImpl addVINTile;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(AddVINTileImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ListpanelcontentImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        addVINTile = context.request().adaptTo(ListpanelcontentImpl.class);
    }

    @Test
    void getIcon() {
        String expected = "icon";
        String actual = addVINTile.getIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getTitle() {
        String expected = "Title";
        String actual = addVINTile.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getIconList() {
        String expected = "iconList";
        String actual = addVINTile.getIconList();
        assertEquals(expected, actual);
    }

    @Test
    void getManualtype() {
        String expected = "manualtype";
        String actual = addVINTile.getManualtype();
        assertEquals(expected, actual);
    }

    @Test
    void getMultimediaManualTitle() {
        String expected = "multimediaManualTitle";
        String actual = addVINTile.getMultimediaManualTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getnextgenIconText() {
        String expected = "nextgenIconText";
        String actual = addVINTile.getnextgenIconText();
        assertEquals(expected, actual);
    }

    @Test
    void getNoServiceDataMessage() {
        String expected = "noServiceDataMessage";
        String actual = addVINTile.getNoServiceDataMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getNoVehicleSelectedMessage() {
        String expected = "noVehicleSelectedMessage";
        String actual = addVINTile.getNoVehicleSelectedMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getPanelType() {
        String expected = "panelType";
        String actual = addVINTile.getPanelType();
        assertEquals(expected, actual);
    }

    @Test
    void getwarrantyServicesTitle() {
        String expected = "warrantyServicesTitle";
        String actual = addVINTile.getwarrantyServicesTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected  = addVINTile.getExportedType();
        assertNotNull(expected);
    }

}
