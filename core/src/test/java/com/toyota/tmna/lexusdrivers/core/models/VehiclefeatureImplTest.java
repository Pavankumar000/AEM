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


import com.toyota.tmna.lexusdrivers.core.models.impl.VehiclefeatureImpl;
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
public class VehiclefeatureImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private VehiclefeatureImpl vehiclefeatureImpl;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses(VehiclefeatureImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/VehiclefeatureImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        vehiclefeatureImpl = context.request().adaptTo(VehiclefeatureImpl.class);
    }

    @Test
    void getDisplayDescription() {
        String expected = "vehicle feature description";
        String actual = vehiclefeatureImpl.getDisplayDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getVehicleType() {
        String expected = "enform";
        String actual = vehiclefeatureImpl.getVehicleType();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected  = vehiclefeatureImpl.getExportedType();
        assertNotNull(expected);
    }
}
