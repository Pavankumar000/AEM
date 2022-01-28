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


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.AccordionImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class AccordionImplTest {
	
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private AccordionImpl accordionImpl;


	@BeforeEach
	void setUp() {
		context.addModelsForClasses(AccordionImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/AccordionImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		accordionImpl = context.request().adaptTo(AccordionImpl.class);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = accordionImpl.getExportedType();
		assertEquals(expected, actual);
	}
	
	@Test
	void getAccordianList() {
		Resource expected = context.resourceResolver().getResource("/content/accordionList");
		accordionImpl = context.request().adaptTo(AccordionImpl.class);
        assert accordionImpl != null;
        Resource actual = accordionImpl.getAccordionList();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
	
	@Test
	void getTableColumnsList() {
		Resource expected = context.resourceResolver().getResource("/content/tableColumnsList");
		accordionImpl = context.request().adaptTo(AccordionImpl.class);
        assert accordionImpl != null;
        Resource actual = accordionImpl.getTableColumnsList();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

}
