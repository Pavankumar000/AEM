package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.TechnologyslideImpl;
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
public class TechnologyslideImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private TechnologyslideImpl technologyslide;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(TechnologyslideImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/TechnologyslideImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        technologyslide = context.request().adaptTo(TechnologyslideImpl.class);
    }


    @Test
    void getTitle() {
        String expected = "title";
        String actual = technologyslide.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getSubTitle() {
        String expected = "subTitle";
        String actual = technologyslide.getSubTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        String expected = "description";
        String actual = technologyslide.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getModelYear() {
        String expected = "modelYear";
        String actual = technologyslide.getModelYear();
        assertEquals(expected, actual);
    }

    @Test
    void getImage() {
        String expected = "image";
        String actual = technologyslide.getImage();
        assertEquals(expected, actual);
    }

    @Test
    void getimageAltText() {
        String expected = "imageAltText";
        String actual = technologyslide.getImageAltText();
        assertEquals(expected, actual);
    }

    @Test
    void getctalink() {
        String expected = "ctalink";
        String actual = technologyslide.getCtalink();
        assertEquals(expected, actual);
    }

    @Test
    void getCtalabel() {
        String expected = "ctalabel";
        String actual = technologyslide.getCtalabel();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = technologyslide.getExportedType();
        assertNotNull(expected);
    }

}
