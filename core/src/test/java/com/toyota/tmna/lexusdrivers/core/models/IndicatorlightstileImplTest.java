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
import com.toyota.tmna.lexusdrivers.core.models.impl.IndicatorlightstileImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class IndicatorlightstileImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private IndicatorlightstileImpl indicatorLights;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(IndicatorlightstileImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/IndicatorlightstileImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		indicatorLights = context.request().adaptTo(IndicatorlightstileImpl.class);
	}
	
	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = indicatorLights.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getTiletitle() {
		String expected = "Indicator Lights";
		String actual = indicatorLights.getTiletitle();
		assertEquals(expected, actual);
	}

	@Test
	void getIconerrormsg() {
		String expected = "https://staging.drivers.lexus.com/lexusdrivers/-/media/TMNA.LDNG/Project/LexusDrivers/Home/Dashboard/demo/icons/Icon-Esclamation-2X-01.svg?la=en&amp;rev=ec458d82481c4906bebd77da731d7f5d&amp;hash=05C3FE5E57FA5FF22E1478C25F68137F";
		String actual = indicatorLights.getIconerrormsg();
		assertEquals(expected, actual);
	}

	@Test
	void getErromsg() {
		String expected = "Errorr mEssage";
		String actual = indicatorLights.getErromsg();
		assertEquals(expected, actual);
	}

	@Test
	void getErrorctalabel() {
		String expected = "CTA Label for Error Message";
		String actual = indicatorLights.getErrorctalabel();
		assertEquals(expected, actual);
	}

	@Test
	void getErrorctalink() {
		String expected = "Error CTA Link";
		String actual = indicatorLights.getErrorctalink();
		assertEquals(expected, actual);
	}

	@Test
	void getTitleicon() {
		String expected = "titleicon";
		String actual = indicatorLights.getTitleicon();
		assertEquals(expected, actual);
	}

	@Test
	void getTilesList() {
		Resource expected = context.resourceResolver().getResource("/content/tilesList");
		indicatorLights = context.request().adaptTo(IndicatorlightstileImpl.class);
        assert indicatorLights != null;
        Resource actual = indicatorLights.getTilesList();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
}
