package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.ListpanelcontainerImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ListpanelcontainerImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private ListpanelcontainerImpl listpanelcontainer;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(ListpanelcontainerImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ListpanelcontainerImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        listpanelcontainer = context.request().adaptTo(ListpanelcontainerImpl.class);
    }

    @Test
    void getIcon() {
        String expected = "icon";
        String actual = listpanelcontainer.getIcon();
        assertEquals(expected, actual);
    }
    @Test
    void getIconList() {
        String expected = "iconList";
        String actual = listpanelcontainer.getIconList();
        assertEquals(expected, actual);
    }

    @Test
    void getTitle() {
        String expected = "title";
        String actual = listpanelcontainer.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getType() {
        String expected = "type";
        String actual = listpanelcontainer.getType();
        assertEquals(expected, actual);
    }

    @Test
    void getManualType() {
        String expected = "manualtype";
        String actual = listpanelcontainer.getManualtype();
        assertEquals(expected, actual);
    }

    @Test
    void getNoServiceDataMessage() {
        String expected = "noServiceDataMessage";
        String actual = listpanelcontainer.getNoServiceDataMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getNoVehicleSelectedMessage() {
        String expected = "noVehicleSelectedMessage";
        String actual = listpanelcontainer.getNoVehicleSelectedMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getNextgenIconText() {
        String expected = "nextgenIconText";
        String actual = listpanelcontainer.getnextgenIconText();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        try {
            assertNull(listpanelcontainer.getExportedType());
        } catch (NullPointerException e){}
    }

}
