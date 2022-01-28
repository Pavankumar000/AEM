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
import com.toyota.tmna.lexusdrivers.core.models.impl.ConfigurationComponentImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.QuicklinksImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ConfigurationComponentImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private ConfigurationComponentImpl configurationComponentImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(ConfigurationComponentImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ConfigurationComponentImplTest.json",
				"/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		configurationComponentImpl = context.request().adaptTo(ConfigurationComponentImpl.class);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = configurationComponentImpl.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getComponenttype() {
		String expected = "States";
		String actual = configurationComponentImpl.getComponenttype();
		assertEquals(expected, actual);
	}

	@Test
	void getMultilist() {
		Resource expected = context.resourceResolver().getResource("/content/multilist");
		configurationComponentImpl = context.request().adaptTo(ConfigurationComponentImpl.class);
		assert configurationComponentImpl != null;
		Resource actual = configurationComponentImpl.getMultilist();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
}
