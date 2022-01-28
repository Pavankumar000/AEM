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


import com.toyota.tmna.lexusdrivers.core.models.impl.MaintenancescheduleImpl;
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
public class MaintenancescheduleImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private MaintenancescheduleImpl maintenancescheduleImpl;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses(MaintenancescheduleImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/MaintenancescheduleImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        maintenancescheduleImpl = context.request().adaptTo(MaintenancescheduleImpl.class);
    }

    @Test
    void getAuthWithoutVIN() {
        String expected = "Auth without VIN";
        String actual = maintenancescheduleImpl.getAuthWithoutVIN();
        assertEquals(expected, actual);
    }

    @Test
    void getAuthwithVIN() {
        String expected = "Auth with VIN";
        String actual = maintenancescheduleImpl.getAuthwithVIN();
        assertEquals(expected, actual);
    }

    @Test
    void getCTALabel() {
        String expected = "CTA Label";
        String actual = maintenancescheduleImpl.getCTALabel();
        assertEquals(expected, actual);
    }

    @Test
    void getCTALink() {
        String expected = "CTA Link";
        String actual = maintenancescheduleImpl.getCTALink();
        assertEquals(expected, actual);
    }

    @Test
    void getCurrentMileage() {
        String expected = "Current Mileage";
        String actual = maintenancescheduleImpl.getCurrentMileage();
        assertEquals(expected, actual);
    }

    @Test
    void getDealerCTA() {
        String expected = "Dealer CTA";
        String actual = maintenancescheduleImpl.getDealerCTA();
        assertEquals(expected, actual);
    }

    @Test
    void getDrive() {
        String expected = "Drive";
        String actual = maintenancescheduleImpl.getDrive();
        assertEquals(expected, actual);
    }

    @Test
    void getEngine() {
        String expected = "Engine";
        String actual = maintenancescheduleImpl.getEngine();
        assertEquals(expected, actual);
    }

    @Test
    void getFindDealerCTA() {
        String expected = "Find Dealer CTA";
        String actual = maintenancescheduleImpl.getFindDealerCTA();
        assertEquals(expected, actual);
    }

    @Test
    void getHeadingErrorMessage() {
        String expected = "Heading Message";
        String actual = maintenancescheduleImpl.getHeadingErrorMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getModelYear() {
        String expected = "2021";
        String actual = maintenancescheduleImpl.getModelYear();
        assertEquals(expected, actual);
    }

    @Test
    void getNoInfo() {
        String expected = "No Info";
        String actual = maintenancescheduleImpl.getNoInfo();
        assertEquals(expected, actual);
    }

    @Test
    void getNoVehicleMessage() {
        String expected = "No Vehicle Message";
        String actual = maintenancescheduleImpl.getNoVehicleMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getPrintIcon() {
        String expected = "Print Icon";
        String actual = maintenancescheduleImpl.getPrintIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getPrintLabel() {
        String expected = "Print Label";
        String actual = maintenancescheduleImpl.getPrintLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getReccomendMsg() {
        String expected = "Reccomend Message";
        String actual = maintenancescheduleImpl.getReccomendMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getRecommendText() {
        String expected = "Recommend Text";
        String actual = maintenancescheduleImpl.getRecommendText();
        assertEquals(expected, actual);
    }

    @Test
    void getscheduleServiceCTA() {
        String expected = "Schedule Service CTA";
        String actual = maintenancescheduleImpl.getscheduleServiceCTA();
        assertEquals(expected, actual);
    }

    @Test
    void getResultsTitle() {
        String expected = "Results Title";
        String actual = maintenancescheduleImpl.getResultsTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getSpecialConditons() {
        String expected = "Apecial Conditions Text";
        String actual = maintenancescheduleImpl.getSpecialConditons();
        assertEquals(expected, actual);
    }

    @Test
    void getSubHeadingErrorMessage() {
        String expected = "Sub Heading Message";
        String actual = maintenancescheduleImpl.getSubHeadingErrorMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getSubTitle() {
        String expected = "Sub Title";
        String actual = maintenancescheduleImpl.getSubTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getTransmission() {
        String expected = "Transmission";
        String actual = maintenancescheduleImpl.getTransmission();
        assertEquals(expected, actual);
    }

    @Test
    void getUnAuthInfo() {
        String expected = "Un-auth info";
        String actual = maintenancescheduleImpl.getUnAuthInfo();
        assertEquals(expected, actual);
    }

    @Test
    void getvehicleVIN() {
        String expected = "Vehicle VIN";
        String actual = maintenancescheduleImpl.getvehicleVIN();
        assertEquals(expected, actual);
    }

     @Test
    void getFindDealerCTALink() {
        String expected = "findDealerCTALink";
        String actual = maintenancescheduleImpl.getFindDealerCTALink();
        assertEquals(expected, actual);
    }

     @Test
    void getscheduleServiceCTALink() {
        String expected = "scheduleServiceCTALink";
        String actual = maintenancescheduleImpl.getScheduleServiceCTALink();
        assertEquals(expected, actual);
    }
    @Test
    void getExportedType() {
        String expected  = maintenancescheduleImpl.getExportedType();
        assertNotNull(expected);
    }

    
}
