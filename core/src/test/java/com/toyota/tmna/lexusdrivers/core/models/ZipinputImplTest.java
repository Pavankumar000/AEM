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
import com.toyota.tmna.lexusdrivers.core.models.impl.ZipinputImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ZipinputImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private ZipinputImpl zipinputImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(ZipinputImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ZipinputImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		zipinputImpl = context.request().adaptTo(ZipinputImpl.class);
	}

	@Test
	public void getZipInputLabel() {
		String expected = "zipInputLabel";
		String actual = zipinputImpl.getZipInputLabel();
		assertEquals(expected, actual);
	}

	@Test
	public void getZipCodeValidations() {
		Resource expected = context.resourceResolver().getResource("/content/zipCodeValidations");
		zipinputImpl = context.request().adaptTo(ZipinputImpl.class);
		assert zipinputImpl != null;
		Resource actual = zipinputImpl.getZipCodeValidations();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

	@Test
	public void getExportedType() {
		String expected = "nt:unstructured";
		String actual = zipinputImpl.getExportedType();
		assertEquals(expected, actual);
	}
}
