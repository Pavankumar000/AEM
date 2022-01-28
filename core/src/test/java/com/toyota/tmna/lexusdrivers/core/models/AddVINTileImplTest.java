package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.toyota.tmna.lexusdrivers.core.models.impl.AddVINTileImpl;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class AddVINTileImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private AddVINTileImpl addVINTile;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(AddVINTileImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/AddVINTileImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        addVINTile = context.request().adaptTo(AddVINTileImpl.class);
    }

    @Test
    void getComponentType() {
        String expected = "Modal";
        String actual = addVINTile.getComponentType();
        assertEquals(expected, actual);
    }
    @Test
    void getImagePosition() {
        String expected = "Below Desc";
        String actual = addVINTile.getImagePosition();
        assertEquals(expected, actual);
    }

    @Test
    void getTitle() {
        String expected = "Title";
        String actual = addVINTile.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        String expected = "des";
        String actual = addVINTile.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getShowSeperator() {
        String expected = "true";
        String actual = addVINTile.getShowSeperator();
        assertEquals(expected, actual);
    }

    @Test
    void getImage() {
        String expected = "fimage";
        String actual = addVINTile.getImage();
        assertEquals(expected, actual);
    }

    @Test
    void getAltText() {
        String expected = "findvin";
        String actual = addVINTile.getAltText();
        assertEquals(expected, actual);
    }

    @Test
    void getButtonLabel() {
        String expected = "OK";
        String actual = addVINTile.getButtonLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getvehicleError() {
        String expected = "vehicleError";
        String actual = addVINTile.getvehicleError();
        assertEquals(expected, actual);
    }

    @Test
    void getvehicleMaxLimit() {
        String expected = "vehicleMaxLimit";
        String actual = addVINTile.getvehicleMaxLimit();
        assertEquals(expected, actual);
    }

    @Test
    void getvinText() {
        String expected = "vinText";
        String actual = addVINTile.getvintext();
        assertEquals(expected, actual);
    }

    @Test
    void getvinValidations() {
        Resource actual = addVINTile.getVinValidations();
        assertNotNull(actual);
    }

    @Test
    void getExportedType() {
        String expected = "nt:unstructured";
        String actual = addVINTile.getExportedType();
        assertEquals(expected, actual);
    }

}
