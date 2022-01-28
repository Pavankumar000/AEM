/*

 * ***********************************************************************

 * Lexus Drivers CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus Drivers.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus Drivers and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus Drivers

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus Drivers.

 * ***********************************************************************

 */

package com.toyota.tmna.lexusdrivers.core.models;


import com.toyota.tmna.lexusdrivers.core.models.impl.VehiclehealthreportImpl;
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
public class VehiclehealthreportImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private VehiclehealthreportImpl vehiclehealthreportImpl;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses(VehiclehealthreportImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/VehiclehealthreportImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        vehiclehealthreportImpl = context.request().adaptTo(VehiclehealthreportImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "title";
        String actual = vehiclehealthreportImpl.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getAlertTitle() {
        String expected = "CURRENT VEHICLE ALERTS";
        String actual = vehiclehealthreportImpl.getAlertTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getCaption() {
        String expected = "caption";
        String actual = vehiclehealthreportImpl.getCaption();
        assertEquals(expected, actual);
    }

    @Test
    void getCountLabel() {
        String expected = "VEHICLE ALERTS";
        String actual = vehiclehealthreportImpl.getCountLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getHealthHistoryLabel() {
        String expected = "Health History";
        String actual = vehiclehealthreportImpl.getHealthHistoryLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getHealthReportLabel() {
        String expected = "Health Report";
        String actual = vehiclehealthreportImpl.getHealthReportLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getHealthReportTitle() {
        String expected = "Vehicle Snap Shot";
        String actual = vehiclehealthreportImpl.getHealthReportTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getInfoDisclaimer() {
        String expected = "infoDisclaimer";
        String actual = vehiclehealthreportImpl.getInfoDisclaimer();
        assertEquals(expected, actual);
    }

    @Test
    void getMilesDrivenDate() {
        String expected = "Filter Categories";
        String actual = vehiclehealthreportImpl.getMilesDrivenDate();
        assertEquals(expected, actual);
    }

    @Test
    void getNoTransmissionMsg() {
        String expected = "VEHICLE DATA IS NOT TRANSMITTING";
        String actual = vehiclehealthreportImpl.getNoTransmissionMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getPdfLabel() {
        String expected = "Download Report PDFDownload Report PDF";
        String actual = vehiclehealthreportImpl.getPdfLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getRefreshLabel() {
        String expected = "Update";
        String actual = vehiclehealthreportImpl.getRefreshLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getResultsLabel() {
        String expected = "Showing {no of records} of {total} results";
        String actual = vehiclehealthreportImpl.getResultsLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getTimeStampMsg() {
        String expected = "timeStampMsg";
        String actual = vehiclehealthreportImpl.getTimeStampMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getTransmissionMsg() {
        String expected = "VEHICLE DATA IS TRANSMITTING";
        String actual = vehiclehealthreportImpl.getTransmissionMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getVhrImage() {
        String expected = "vhrImage";
        String actual = vehiclehealthreportImpl.getVhrImage();
        assertEquals(expected, actual);
    }

    @Test
    void getZeroAlerts() {
        String expected = "There are no alerts reported by your lexus.";
        String actual = vehiclehealthreportImpl.getZeroAlerts();
        assertEquals(expected, actual);
    }

    @Test
    void getquestionData() {
        String expected = "questionData";
        String actual = vehiclehealthreportImpl.getQuestionData();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected  = vehiclehealthreportImpl.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getPopoverData() {
        Resource expected = context.resourceResolver().getResource("/content/popoverData");
        vehiclehealthreportImpl = context.request().adaptTo(VehiclehealthreportImpl.class);
        assert vehiclehealthreportImpl != null;
        Resource actual = vehiclehealthreportImpl.getPopoverData();
        assertNotNull(actual);
    }

    @Test
    void getToolCards() {
        Resource expected = context.resourceResolver().getResource("/content/toolCards");
        vehiclehealthreportImpl = context.request().adaptTo(VehiclehealthreportImpl.class);
        assert vehiclehealthreportImpl != null;
        Resource actual = vehiclehealthreportImpl.getToolCards();
        assertNotNull(actual);
    }
}
