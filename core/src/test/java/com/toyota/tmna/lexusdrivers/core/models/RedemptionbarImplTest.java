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


import com.toyota.tmna.lexusdrivers.core.models.impl.RedemptionbarImpl;
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
public class RedemptionbarImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private RedemptionbarImpl redemptionbarImpl;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses(RedemptionbarImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/RedemptionbarImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        redemptionbarImpl = context.request().adaptTo(RedemptionbarImpl.class);
    }

    @Test
    void getTitle() {
        String expected = "title";
        String actual = redemptionbarImpl.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getClaimDesc() {
        String expected = "Claim Description";
        String actual = redemptionbarImpl.getClaimDesc();
        assertEquals(expected, actual);
    }

    @Test
    void getClaimLabel() {
        String expected = "CLAIM";
        String actual = redemptionbarImpl.getClaimLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getClaimLink() {
        String expected = "https://www.thelexuscollection.com/";
        String actual = redemptionbarImpl.getClaimLink();
        assertEquals(expected, actual);
    }

    @Test
    void getContactInfo() {
        String expected = "contactInfo";
        String actual = redemptionbarImpl.getContactInfo();
        assertEquals(expected, actual);
    }

    @Test
    void getIcon() {
        String expected = "/content/dam/lexusdrivers/media/images";
        String actual = redemptionbarImpl.getIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getLogoutDesc() {
        String expected = "logoutDesc";
        String actual = redemptionbarImpl.getLogoutDesc();
        assertEquals(expected, actual);
    }

    @Test
    void getSignInLabel() {
        String expected = "signInLabel";
        String actual = redemptionbarImpl.getSignInLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getSignInLink() {
        String expected = "signinLink";
        String actual = redemptionbarImpl.getSignInLink();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected  = redemptionbarImpl.getExportedType();
        assertNotNull(expected);
    }
}
