package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.MypanelImpl;
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
public class MypanelImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private MypanelImpl mypanelImpl;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(MypanelImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/MypanelImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        mypanelImpl = context.request().adaptTo(MypanelImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "title";
        String actual = mypanelImpl.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        String expected = "description";
        String actual = mypanelImpl.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getCtaText() {
        String expected = "ctaText";
        String actual = mypanelImpl.getCtaText();
        assertEquals(expected, actual);
    }

    @Test
    void getOrder() {
        String expected = "order";
        String actual = mypanelImpl.getOrder();
        assertEquals(expected, actual);
    }

    @Test
    void getCtaLink() {
        String expected = "ctaLink";
        String actual = mypanelImpl.getCtaLink();
        assertEquals(expected, actual);
    }

    @Test
    void getMyList() {
        String expected = "myList";
        String actual = mypanelImpl.getMyList();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected  = mypanelImpl.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getCtaList() {
        Resource expected = context.resourceResolver().getResource("/content/ctaList");
        mypanelImpl = context.request().adaptTo(MypanelImpl.class);
        assert mypanelImpl != null;
        Resource actual = mypanelImpl.getCtaList();
        assertNotNull(actual);
    }

    @Test
    void getHeaderIcon() {
        String expected = "headerIcon";
        String actual = mypanelImpl.getHeaderIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getMypanelClassName() {
        String expected = "mypanelClassName";
        String actual = mypanelImpl.getMypanelClassName();
        assertEquals(expected, actual);
    }

    @Test
    void getNotApplicableMyList() {
        String expected = "notApplicableMyList";
        String actual = mypanelImpl.getNotApplicableMyList();
        assertEquals(expected, actual);
    }


}
