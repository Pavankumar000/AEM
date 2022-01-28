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


import com.toyota.tmna.lexusdrivers.core.models.impl.MaintenanceschedulepdfImpl;
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
public class MaintenanceschedulepdfImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private MaintenanceschedulepdfImpl maintenancescheduleImpl;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses(MaintenanceschedulepdfImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/MaintenanceschedulepdfImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        maintenancescheduleImpl = context.request().adaptTo(MaintenanceschedulepdfImpl.class);
    }

    @Test
    void getCurrentMileageText() {
        String expected = "Current Mileage";
        String actual = maintenancescheduleImpl.getCurrentMileageText();
        assertEquals(expected, actual);
    }

    @Test
    void getMilesText() {
        String expected = "miles";
        String actual = maintenancescheduleImpl.getMilesText();
        assertEquals(expected, actual);
    }

    @Test
    void getFooterText() {
        String expected = "Footer Text";
        String actual = maintenancescheduleImpl.getFooterText();
        assertEquals(expected, actual);
    }

    @Test
    void getNextMileageText() {
        String expected = "NEXT MILEAGE";
        String actual = maintenancescheduleImpl.getNextMileageText();
        assertEquals(expected, actual);
    }

    @Test
    void getPreviousMileageText() {
        String expected = "Previous Mileage";
        String actual = maintenancescheduleImpl.getPreviousMileageText();
        assertEquals(expected, actual);
    }

    @Test
    void getRecommendedText() {
        String expected = "Mile Factory Recommended Service";
        String actual = maintenancescheduleImpl.getRecommendedText();
        assertEquals(expected, actual);
    }

    @Test
    void getSpecialConditionsHeading() {
        String expected = "Special Driving Conditions";
        String actual = maintenancescheduleImpl.getSpecialConditionsHeading();
        assertEquals(expected, actual);
    }

    @Test
    void getSpecialConditionsSubHeading() {
        String expected = "Special Conditions Sub Heading";
        String actual = maintenancescheduleImpl.getSpecialConditionsSubHeading();
        assertEquals(expected, actual);
    }

    @Test
    void getTitleText() {
        String expected = "LEXUS";
        String actual = maintenancescheduleImpl.getTitleText();
        assertEquals(expected, actual);
    }


    @Test
    void getExportedType() {
        String expected  = maintenancescheduleImpl.getExportedType();
        assertNotNull(expected);
    }
}
