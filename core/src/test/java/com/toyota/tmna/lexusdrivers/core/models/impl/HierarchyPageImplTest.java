package com.toyota.tmna.lexusdrivers.core.models;

import com.day.cq.wcm.api.Page;
import io.wcm.testing.mock.aem.junit5.AemContext;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HierarchyPageImplTest {

    @InjectMocks
    com.toyota.tmna.lexusdrivers.core.models.HierarchyPageImpl hierarchyPage;


    @Mock
    SlingHttpServletRequest request;

    @Mock
    Page currentPage;
    private final AemContext context = new AemContext();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        hierarchyPage = new com.toyota.tmna.lexusdrivers.core.models.HierarchyPageImpl();
    }

    @Test
    void getExportedHierarchyType() {
        assertEquals("page", hierarchyPage.getExportedHierarchyType());
    }
}
