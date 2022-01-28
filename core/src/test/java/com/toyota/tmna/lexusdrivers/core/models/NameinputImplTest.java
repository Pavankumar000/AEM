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
import com.toyota.tmna.lexusdrivers.core.models.impl.NameinputImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class NameinputImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private NameinputImpl nameinputImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(NameinputImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/NameinputImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		nameinputImpl = context.request().adaptTo(NameinputImpl.class);
	}

	@Test
	void getLabel() {
		String expected = "label";
		String actual = nameinputImpl.getLabel();
		assertEquals(expected, actual);
	}

	
	@Test
	void getRequiredMessage() {
		String expected = "requiredMessage";
		String actual = nameinputImpl.getRequiredMessage();
		assertEquals(expected, actual);
	}

	

	@Test
	void getRules() {
		Resource expected = context.resourceResolver().getResource("/content/rules");
		nameinputImpl = context.request().adaptTo(NameinputImpl.class);
		assert nameinputImpl != null;
		Resource actual = nameinputImpl.getRules();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = nameinputImpl.getExportedType();
		assertEquals(expected, actual);
		
	}
}
