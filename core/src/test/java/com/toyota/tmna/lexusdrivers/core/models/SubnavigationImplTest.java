package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.SubnavigationImpl;
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
public class SubnavigationImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private SubnavigationImpl subnavigation;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(SubnavigationImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/SubnavigationImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        subnavigation = context.request().adaptTo(SubnavigationImpl.class);
    }

    @Test
    void getModuleName() {
        String expected = "moduleName";
        String actual = subnavigation.getModuleName();
        assertEquals(expected, actual);
    }

    @Test
    void getShowActiveTab() {
        Boolean expected = Boolean.TRUE;
        Boolean actual = subnavigation.getShowActiveTab();
        assertEquals(expected, actual);
    }
    
    @Test
    void getnextIcon() {
        String expected = "nextIcon";
        String actual = subnavigation.getNextIcon();
        assertEquals(expected, actual);
    }
    
    @Test
    void getPrevIcon() {
        String expected = "prevIcon";
        String actual = subnavigation.getPrevIcon();
        assertEquals(expected, actual);
    }
    
    @Test
    void getMoreLabel() {
        String expected = "moreLabel";
        String actual = subnavigation.getMoreLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getSubNavType() {
        String expected = "subNavType";
        String actual = subnavigation.getSubNavType();
        assertEquals(expected, actual);
    }
    
    @Test
    void getIsStickyNav() {
        String expected = "isStickyNav";
        String actual = subnavigation.getIsStickyNav();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = subnavigation.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getNavLinks() {
        Resource expected = subnavigation.getnavlinks();
        assertNull(expected);
    }
}
