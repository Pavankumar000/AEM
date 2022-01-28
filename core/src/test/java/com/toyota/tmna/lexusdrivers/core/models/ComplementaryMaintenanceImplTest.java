package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.ComplementaryMaintenanceImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.CopypanelImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ComplementaryMaintenanceImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private ComplementaryMaintenanceImpl csTileCompImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(ComplementaryMaintenanceImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ComplementaryMaintenanceImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		csTileCompImpl = context.request().adaptTo(ComplementaryMaintenanceImpl.class);
	}

	@Test
	void getScheduleServiceLink() {
		String expected = "/content/lexusdrivers/us/en/lexusdrivers/herobanner1";
		String actual = csTileCompImpl.getScheduleServiceLink();
		assertEquals(expected, actual);
	}

	@Test
	void getScheduleServiceLabel() {
		String expected = "SCHEDULE SERVICE";
		String actual = csTileCompImpl.getScheduleServiceLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getNoServiceDataMessage() {
		String expected = "This content is currently unavailable. Please check back later.";
		String actual = csTileCompImpl.getNoServiceDataMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getSixMonthsLabel() {
		String expected = "5000";
		String actual = csTileCompImpl.getSixMonthsLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getTwelveMonthLabel() {
		String expected = "10000";
		String actual = csTileCompImpl.getTwelveMonthLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getUnitsForMonth() {
		String expected = "MONTHS";
		String actual = csTileCompImpl.getUnitsForMonth();
		assertEquals(expected, actual);
	}

	@Test
	void getUnitsForMiles() {
		String expected = "MILES";
		String actual = csTileCompImpl.getUnitsForMiles();
		assertEquals(expected, actual);
	}

	@Test
	void getMinUsageMonths() {
		String expected = "6";
		String actual = csTileCompImpl.getMinUsageMonths();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = csTileCompImpl.getExportedType();
		assertEquals(expected, actual);
	}
	
	@Test
	void getMaxUsageMonths() {
		String expected = "12";
		String actual = csTileCompImpl.getMaxUsageMonths();
		assertEquals(expected, actual);
	}
}
