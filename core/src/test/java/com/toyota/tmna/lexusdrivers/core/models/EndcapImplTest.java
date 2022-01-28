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


import com.toyota.tmna.lexusdrivers.core.models.impl.EndcapImpl;
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
public class EndcapImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private  EndcapImpl endcapImpl;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses( EndcapImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/EndcapImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        endcapImpl = context.request().adaptTo(EndcapImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "Title";
        String actual = endcapImpl.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getDesktopimage() {
        String expected = "/content/dam/lexusdrivers/content-fragments/appconfig/app-config";
        String actual = endcapImpl.getDesktopimage();
        assertEquals(expected, actual);
    }

    @Test
    void getMobileimage() {
        String expected = "/content/dam/lexusdrivers/content-fragments/appconfig/app-config";
        String actual = endcapImpl.getMobileimage();
        assertEquals(expected, actual);
    }

    @Test
    void getDesktopimagealt() {
        String expected = "DesktopImage Alternate Text";
        String actual = endcapImpl.getDesktopimagealt();
        assertEquals(expected, actual);
    }

    @Test
    void getMobileimagealt() {
        String expected = "Mobile Image Alternate Text";
        String actual = endcapImpl.getMobileimagealt();
        assertEquals(expected, actual);
    }


    @Test
    void getExportedType() {
        String expected  = endcapImpl.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getIcons() {
        Resource expected = context.resourceResolver().getResource("/content/icons");
        endcapImpl = context.request().adaptTo(EndcapImpl.class);
        assert endcapImpl != null;
        Resource actual = endcapImpl.getIcons();
        assertNotNull(actual);
    }

}
