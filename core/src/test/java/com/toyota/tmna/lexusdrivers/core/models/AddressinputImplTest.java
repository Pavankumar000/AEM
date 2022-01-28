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
import com.toyota.tmna.lexusdrivers.core.models.impl.AddressinputImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class AddressinputImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private AddressinputImpl addressinputImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(AddressinputImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/AddressinputImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		addressinputImpl = context.request().adaptTo(AddressinputImpl.class);
	}

	@Test
	void getAddressLabel() {
		String expected = "Address Label";
		String actual = addressinputImpl.getAddressLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getAddressValidations() {
		Resource expected = context.resourceResolver().getResource("/content/addressValidations");
		addressinputImpl = context.request().adaptTo(AddressinputImpl.class);
		assert addressinputImpl != null;
		Resource actual = addressinputImpl.getAddressValidations();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = addressinputImpl.getExportedType();
		assertEquals(expected, actual);
	}
}
