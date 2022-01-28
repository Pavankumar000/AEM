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

import com.toyota.tmna.lexusdrivers.core.models.impl.WelcometilesImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class WelcometilesImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private WelcometilesImpl welcometilesImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(WelcometilesImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/WelcometilesImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		welcometilesImpl = context.request().adaptTo(WelcometilesImpl.class);
	}
	@Test
	void getDisplaytitle() {
		String expected = "EXPLORE EXCLUSIVE MEMBER BENEFITS, VEHICLE INFORMATION AND MORE";
		String actual = welcometilesImpl.getDisplaytitle();
		assertEquals(expected, actual);
	}
	@Test
	void getExportedType(){
		String expected = "nt:unstructured";
		String actual = welcometilesImpl.getExportedType();
		assertEquals(expected, actual);
	}
	
	@Test
	void getDataSource() {
		Resource expected = context.resourceResolver().getResource("/content/dataSource");
		welcometilesImpl = context.request().adaptTo(WelcometilesImpl.class);
        assert welcometilesImpl != null;
        Resource actual = welcometilesImpl.getDataSource();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
	
}
