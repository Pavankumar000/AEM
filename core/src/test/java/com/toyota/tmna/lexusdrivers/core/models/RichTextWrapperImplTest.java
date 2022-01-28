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


import com.toyota.tmna.lexusdrivers.core.models.impl.RichTextWrapperImpl;
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
public class RichTextWrapperImplTest {

    private final AemContext context = new AemContext();
    @Mock
    private ModelFactory modelFactory;
    private RichTextWrapperImpl richTextWrapperImpl;


    @BeforeEach
    void setUp() {
        context.addModelsForClasses(RichTextWrapperImpl.class);
        context.load().json("/com/toyota/tmna/lexusdrivers/core/models/RichTextWrapperImplTest.json", "/content");
        context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
                Integer.MAX_VALUE);
        context.currentResource("/content");
        richTextWrapperImpl = context.request().adaptTo(RichTextWrapperImpl.class);
    }
    @Test
    void getTitle() {
        String expected = "title";
        String actual = richTextWrapperImpl.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getClassName() {
        String expected = "class name";
        String actual = richTextWrapperImpl.getClassName();
        assertEquals(expected, actual);
    }

    @Test
    void getDescription () {
        String expected = "Rich text wrapper";
        String actual = richTextWrapperImpl.getDescription();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String expected  = richTextWrapperImpl.getExportedType();
        assertNotNull(expected);
    }
}
