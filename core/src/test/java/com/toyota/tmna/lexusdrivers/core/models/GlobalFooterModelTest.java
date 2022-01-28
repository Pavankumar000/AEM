package com.toyota.tmna.lexusdrivers.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.json.JSONArray;
import org.apache.sling.api.resource.Resource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class GlobalFooterModelTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private   GlobalFooterModel globalFooterModel;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses(GlobalFooterModel.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/GlobalFooterTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory,
                org.osgi.framework.Constants.SERVICE_RANKING, Integer.MAX_VALUE);
        context.currentResource("/content");
        globalFooterModel = context.request().adaptTo(GlobalFooterModel.class);

    }

    @Test
    void getHeadlinePath() {
        String expected = "https://privacy.toyota.com/";
        String actual = globalFooterModel.getHeadlinePath();
        assertEquals(expected, actual);
    }

    @Test
    void getHeadline() {
        String expected = "DO NOT SELL MY PERSONAL INFORMATION";
        String actual = globalFooterModel.getHeadline();
        assertEquals(expected, actual);
    }

    @Test
    void getCopyRightDesc() {
        String expected = "<p>© 2006-2019 Lexus, a Division of Toyota Motor Sales, U.S.A., Inc. All information contained herein applies to U.S. vehicles only.</p>";
        String actual = globalFooterModel.getCopyRightDesc();
        assertEquals(expected, actual);
    }


    @Test
    void getCopyRightText() {
        String expected = "Safety Recalls & Service Campaigns";
        String actual = globalFooterModel.getCopyRightText();
        assertEquals(expected, actual);
    }


    @Test
    void getCopyRightLink() {
        String expected = "http://www.toyota.com/recall";
        String actual = globalFooterModel.getCopyRightLink();
        assertEquals(expected, actual);
    }

    @Test
    void getCopyopennewwindow() {
        String expected = "true";
        String actual = globalFooterModel.getCopyopennewwindow();
        assertEquals(expected, actual);
    }

    @Test
    void getHeadPathOpennewwindow() {
        String expected = "true";
        String actual = globalFooterModel.getHeadPathOpennewwindow();
        assertEquals(expected, actual);
    }
   

    @Test
    void getExportedType() {
        Resource footer = null;
        String expected = globalFooterModel.getExportedType();
        globalFooterModel.setFootercolumns(footer);
        assertNotNull(expected);
    }

    @Test
    void getMainMenuLinks() {
        Resource expected = globalFooterModel.getMainMenuLinks();
        assertNotNull(expected);
    }

    @Test
    void getNavigationLinks() {
        Resource expected = globalFooterModel.getNavigationLinks();
        assertNotNull(expected);
    }

    @Test
    void getSocialLinks() {
        Resource expected = globalFooterModel.getSocialLinks();
        assertNotNull(expected);
    }

}
