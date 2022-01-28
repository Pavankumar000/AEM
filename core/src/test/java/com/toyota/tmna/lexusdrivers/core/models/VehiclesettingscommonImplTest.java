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


import com.toyota.tmna.lexusdrivers.core.models.impl.VehiclesettingscommonImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class VehiclesettingscommonImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private VehiclesettingscommonImpl vehiclesettingscommonImpl;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses(VehiclesettingscommonImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/VehiclesettingscommonImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        vehiclesettingscommonImpl = context.request().adaptTo(VehiclesettingscommonImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "title";
        String actual = vehiclesettingscommonImpl.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getAddVehicleIcon() {
        String expected = "/content/dam/lexusdrivers/media/images";
        String actual = vehiclesettingscommonImpl.getAddVehicleIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getAddVehicleLabel() {
        String expected = "addVehicleLabel";
        String actual = vehiclesettingscommonImpl.getAddVehicleLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getActiveSubscription() {
        String expected = "activeSubscription";
        String actual = vehiclesettingscommonImpl.getActiveSubscription();
        assertEquals(expected, actual);
    }

    @Test
    void getCardType() {
        String expected = "vehiclesettings";
        String actual = vehiclesettingscommonImpl.getCardType();
        assertEquals(expected, actual);
    }

    @Test
    void getConfirmationLabel() {
        String expected = "OK";
        String actual = vehiclesettingscommonImpl.getConfirmationLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getConfirmationMsg() {
        String expected = "Vehicle {0} deleted successfully.";
        String actual = vehiclesettingscommonImpl.getConfirmationMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getDelelteMsg() {
        String expected = "Are you sure you want to delete {0} vehicle?";
        String actual = vehiclesettingscommonImpl.getDelelteMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getDeletePrimaryLabel() {
        String expected = "Confirm";
        String actual = vehiclesettingscommonImpl.getDeletePrimaryLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getDeleteSecondaryLabel() {
        String expected = "Cancel";
        String actual = vehiclesettingscommonImpl.getDeleteSecondaryLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getInActiveSubscription() {
        String expected = "In Active Subsciption Message";
        String actual = vehiclesettingscommonImpl.getInActiveSubscription();
        assertEquals(expected, actual);
    }

    @Test
    void getNoVehicleMsg() {
        String expected = "noVehicleMsg";
        String actual = vehiclesettingscommonImpl.getNoVehicleMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getSection() {
        String expected = "section";
        String actual = vehiclesettingscommonImpl.getSection();
        assertEquals(expected, actual);
    }
    @Test
    void getSetPrimaryLabel() {
        String expected = "OK";
        String actual = vehiclesettingscommonImpl.getSetPrimaryLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getSetPrimaryMsg() {
        String expected = "successfully set as primary vehicle.";
        String actual = vehiclesettingscommonImpl.getSetPrimaryMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getSubSection() {
        String expected = "subSection";
        String actual = vehiclesettingscommonImpl.getSubSection();
        assertEquals(expected, actual);
    }

    @Test
    void getVehicleError() {
        String expected = "vehicleError";
        String actual = vehiclesettingscommonImpl.getVehicleError();
        assertEquals(expected, actual);
    }

    @Test
    void getVehicleSpecError() {
        String expected = "vehicleSpecError";
        String actual = vehiclesettingscommonImpl.getVehicleSpecError();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected  = vehiclesettingscommonImpl.getExportedType();
        assertNotNull(expected);
    }
}
