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
import com.toyota.tmna.lexusdrivers.core.models.impl.VhrtilecomponentImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class VhrtilecomponentImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private VhrtilecomponentImpl vhr;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(VhrtilecomponentImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/VhrtilecomponentImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		vhr = context.request().adaptTo(VhrtilecomponentImpl.class);
	}
	
	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = vhr.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getTiletitle() {
		String expected = "VEHICLE HEALTH REPORT";
		String actual = vhr.getTiletitle();
		assertEquals(expected, actual);
	}

	@Test
	void getTitleicon() {
		String expected = "/content/dam/lexusdrivers/media/icons/waning-lights_for_delete/Master Warning.png";
		String actual = vhr.getTitleicon();
		assertEquals(expected, actual);
	}

	@Test
	void getIconerrormsg() {
		String expected = "https://staging.drivers.lexus.com/lexusdrivers/-/media/TMNA.LDNG/Project/LexusDrivers/Home/Dashboard/demo/icons/Icon-Esclamation-2X-01.svg?la=en&amp;rev=ec458d82481c4906bebd77da731d7f5d&amp;hash=05C3FE5E57FA5FF22E1478C25F68137F";
		String actual = vhr.getIconerrormsg();
		assertEquals(expected, actual);
	}

	@Test
	void getErromsg() {
		String expected = "Errorr mEssage";
		String actual = vhr.getErromsg();
		assertEquals(expected, actual);
	}

	@Test
	void getErrorctalabel() {
		String expected = "CTA Label for Error Message";
		String actual = vhr.getErrorctalabel();
		assertEquals(expected, actual);
	}

	@Test
	void getErrorctalink() {
		String expected = "Error CTA Link";
		String actual = vhr.getErrorctalink();
		assertEquals(expected, actual);
	}
	
	@Test
	void getTilesList() {
		Resource expected = context.resourceResolver().getResource("/content/tilesList");
		vhr = context.request().adaptTo(VhrtilecomponentImpl.class);
        assert vhr != null;
        Resource actual = vhr.getTilesList();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
}
