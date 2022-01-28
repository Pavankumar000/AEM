package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.MileagegraphImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.MultiselectfilterImpl;
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
public class MultiselectfilterImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private MultiselectfilterImpl multiselectfilter;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(MultiselectfilterImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/MultiselectfilterImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        multiselectfilter = context.request().adaptTo(MultiselectfilterImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "title";
        String actual = multiselectfilter.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getOptionList() {
        Resource expected = multiselectfilter.getOptionsList();
        assertNotNull(expected);
    }

    @Test
    void getExportedType() {
        String expected = multiselectfilter.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getPlaceholderText() {
        String expected = "placeholderText";
        String actual = multiselectfilter.getPlaceholderText();
        assertEquals(expected, actual);
    }

    @Test
    void getSelectAllLabel() {
        String expected = "selectAllLabel";
        String actual = multiselectfilter.getSelectAllLabel();
        assertEquals(expected, actual);
    }
}
