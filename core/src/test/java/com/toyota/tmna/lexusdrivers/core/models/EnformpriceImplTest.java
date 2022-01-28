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


import com.toyota.tmna.lexusdrivers.core.models.impl.EnformpriceImpl;
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
public class EnformpriceImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private EnformpriceImpl enformpriceImpl;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses(EnformpriceImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/EnformpriceImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        enformpriceImpl = context.request().adaptTo(EnformpriceImpl.class);
    }

    @Test
    void getAdditionalYearsLabel() {
        String expected = "additionalYearsLabel";
        String actual = enformpriceImpl.getAdditionalYearsLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getCardDescription() {
        String expected = "cardDescription";
        String actual = enformpriceImpl.getCardDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getCardTitle() {
        String expected = "cardTitle";
        String actual = enformpriceImpl.getCardTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getDealerLabel() {
        String expected = "dealerLabel";
        String actual = enformpriceImpl.getDealerLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getMonthlyLabel() {
        String expected = "monthlyLabel";
        String actual = enformpriceImpl.getMonthlyLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getMonthlyUnitValue() {
        String expected = "monthlyUnitValue";
        String actual = enformpriceImpl.getMonthlyUnitValue();
        assertEquals(expected, actual);
    }

    @Test
    void getMsrpLabel() {
        String expected = "msrpLabel";
        String actual = enformpriceImpl.getMsrpLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getMsrpUnitValue() {
        String expected = "msrpUnitValue";
        String actual = enformpriceImpl.getMsrpUnitValue();
        assertEquals(expected, actual);
    }

    @Test
    void getPriceType() {
        String expected = "priceType";
        String actual = enformpriceImpl.getPriceType();
        assertEquals(expected, actual);
    }

    @Test
    void getYearlyLabel() {
        String expected = "yearlyLabel";
        String actual = enformpriceImpl.getYearlyLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getYearlyUnitValue() {
        String expected = "yearlyUnitValue";
        String actual = enformpriceImpl.getYearlyUnitValue();
        assertEquals(expected, actual);
    }


    @Test
    void getExportedType() {
        String expected  = enformpriceImpl.getExportedType();
        assertNotNull(expected);
    }
}
