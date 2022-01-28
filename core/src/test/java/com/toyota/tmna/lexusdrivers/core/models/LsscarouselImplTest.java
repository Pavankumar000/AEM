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


import com.toyota.tmna.lexusdrivers.core.models.impl.LsscarouselImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.ServicecardImpl;
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
public class LsscarouselImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private  LsscarouselImpl lss;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses( LsscarouselImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/LsscarouselImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        lss = context.request().adaptTo(LsscarouselImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "Title";
        String actual = lss.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getDefaultMsg() {
        String expected = "Default Message";
        String actual = lss.getDefaultMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        String expected = "Description";
        String actual = lss.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getDescriptgetGarageMsgion() {
        String expected = "Garage Message";
        String actual = lss.getGarageMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getHeading() {
        String expected = "Heading";
        String actual = lss.getHeading();
        assertEquals(expected, actual);
    }

    @Test
    void getHidevideo() {
        String expected = "Hide Video";
        String actual = lss.getHidevideo();
        assertEquals(expected, actual);
    }

    @Test
    void getModalcta() {
        String expected = "Modal Cta";
        String actual = lss.getModalcta();
        assertEquals(expected, actual);
    }

    @Test
    void getNoLssMsg() {
        String expected = "No LSS Message";
        String actual = lss.getNoLssMsg();
        assertEquals(expected, actual);
    }

    @Test
    void getNovehicleEquipped() {
        String expected = "No Vehicle Equipped Heading";
        String actual = lss.getNovehicleEquipped();
        assertEquals(expected, actual);
    }

    @Test
    void getNovehicleEquippedImg() {
        String expected = "No Vehicle Equipped Image";
        String actual = lss.getNovehicleEquippedImg();
        assertEquals(expected, actual);
    }

    @Test
    void getSubtitle() {
        String expected = "Sub Title";
        String actual = lss.getSubtitle();
        assertEquals(expected, actual);
    }

    @Test
    void getVehicleEquipped() {
        String expected = "Vehicle Equipped Heading";
        String actual = lss.getVehicleEquipped();
        assertEquals(expected, actual);
    }

    @Test
    void getVehicleEquippedImg() {
        String expected = "Vehicle Equipped Image";
        String actual = lss.getVehicleEquippedImg();
        assertEquals(expected, actual);
    }

    @Test
    void getId() {
        String expected = "Video Source";
        String actual = lss.getId();
        assertEquals(expected, actual);
    }

    @Test
    void getVideo_title() {
        String expected = "Video Title";
        String actual = lss.getVideo_title();
        assertEquals(expected, actual);
    }

    @Test
    void getVideo_type() {
        String expected = "video";
        String actual = lss.getVideo_type();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected  = lss.getExportedType();
        assertNotNull(expected);
    }

    @Test
    void getCarouselslides() {
        Resource expected = context.resourceResolver().getResource("/content/carouselslides");
        lss = context.request().adaptTo(LsscarouselImpl.class);
        assert lss != null;
        Resource actual = lss.getCarouselslides();
        assertNotNull(actual);
    }

    @Test
    void getBannerList() {
        Resource expected = context.resourceResolver().getResource("/content/bannerList");
        lss = context.request().adaptTo(LsscarouselImpl.class);
        assert lss != null;
        Resource actual = lss.getBannerList();
        assertNotNull(actual);
    }

    @Test
    void getDescList() {
        Resource expected = context.resourceResolver().getResource("/content/descList");
        lss = context.request().adaptTo(LsscarouselImpl.class);
        assert lss != null;
        Resource actual = lss.getDescList();
        assertNotNull(actual);
    }

    @Test
    void getCtaList() {
        Resource expected = context.resourceResolver().getResource("/content/ctaList");
        lss = context.request().adaptTo(LsscarouselImpl.class);
        assert lss != null;
        Resource actual = lss.getCtaList();
        assertNotNull(actual);
    }


}
