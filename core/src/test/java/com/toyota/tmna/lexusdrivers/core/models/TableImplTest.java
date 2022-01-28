package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.TableImpl;
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
public class TableImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private TableImpl table;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(TableImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/TableImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        table = context.request().adaptTo(TableImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "title";
        String actual = table.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getHeaderCSS() {
        String expected = "headerCSS";
        String actual = table.getHeaderCSS();
        assertEquals(expected, actual);
    }

    @Test
    void getRowCSS() {
        String expected = "rowCSS";
        String actual = table.getRowCSS();
        assertEquals(expected, actual);
    }

    @Test
    void getDownLoadFullSpec() {
        String expected = "downLoadFullSpec";
        String actual = table.getDownLoadFullSpec();
        assertEquals(expected, actual);
    }

    @Test
    void getDownloadIcon() {
        String expected = "downloadIcon";
        String actual = table.getDownloadIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getisVehicleSpec() {
        Boolean expected = Boolean.TRUE;
        Boolean actual = table.getHideVehicleSpec();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected = table.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getNavLinks() {
        Resource expected = table.getColumnsList();
        assertNull(expected);
    }

}
