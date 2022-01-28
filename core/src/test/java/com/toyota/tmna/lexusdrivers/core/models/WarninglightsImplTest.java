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

import com.toyota.tmna.lexusdrivers.core.models.impl.QuicklinksImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.WarninglightsImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.WelcometilesImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class WarninglightsImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private WarninglightsImpl warninglightsImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(WarninglightsImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/WarninglightsImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		warninglightsImpl = context.request().adaptTo(WarninglightsImpl.class);

	}

	@Test
	void getTitle() {
		String expected = "SUCCESS";
		String actual = warninglightsImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getDisclaimer() {
		String expected = "Disclaimer";
		String actual = warninglightsImpl.getDisclaimer();
		assertEquals(expected, actual);
	}

	@Test
	void getScheduleServiceCTA() {
		String expected = "Schedule";
		String actual = warninglightsImpl.getScheduleServiceCTA();
		assertEquals(expected, actual);
	}

	@Test
	void getScheduleServiceLink() {
		String expected = "Schedule Service Link";
		String actual = warninglightsImpl.getScheduleServiceLink();
		assertEquals(expected, actual);
	}

	@Test
	void getManualsCTA() {
		String expected = "Manuals";
		String actual = warninglightsImpl.getManualsCTA();
		assertEquals(expected, actual);
	}

	@Test
	void getManualsLink() {
		String expected = "Manuals Link";
		String actual = warninglightsImpl.getManualsLink();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = warninglightsImpl.getExportedType();
		assertEquals(expected, actual);
	}
	@Test
	void getwlDataSource(){
		Resource expected = context.resourceResolver().getResource("/content/wldataSource");
		warninglightsImpl = context.request().adaptTo(WarninglightsImpl.class);
        assert warninglightsImpl != null;
        Resource actual = warninglightsImpl.getwlDataSource();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

}
