package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.WelcometitleImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class WelcometitleImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private WelcometitleImpl welcometitleImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(WelcometitleImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/WelcometitleImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content/welcomp");
		welcometitleImpl = context.request().adaptTo(WelcometitleImpl.class);

	}

	@Test
	void getTitle() {
		String expected = "WELCOME TO LEXUS DRIVERS";
		String actual = welcometitleImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = welcometitleImpl.getExportedType();
		assertEquals(expected, actual);
	}

}
