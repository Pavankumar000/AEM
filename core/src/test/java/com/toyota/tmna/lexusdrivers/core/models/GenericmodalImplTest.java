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
import com.toyota.tmna.lexusdrivers.core.models.impl.GenericmodalImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class GenericmodalImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private GenericmodalImpl genericmodalImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(GenericmodalImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/GenericmodalImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		genericmodalImpl = context.request().adaptTo(GenericmodalImpl.class);
	}

	@Test
	void getTitle() {
		String expected = "This is title";
		String actual = genericmodalImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getCloseIcon() {
		String expected = "close icon";
		String actual = genericmodalImpl.getCloseIcon();
		assertEquals(expected, actual);
	}

	@Test
	void getBody() {
		String expected = "Body Text";
		String actual = genericmodalImpl.getBody();
		assertEquals(expected, actual);
	}

	@Test
	void getFooter() {
		String expected = "Footer";
		String actual = genericmodalImpl.getFooter();
		assertEquals(expected, actual);
	}

	@Test
	void getModaltype() {
		String expected = "tilespecific";
		String actual = genericmodalImpl.getModaltype();
		assertEquals(expected, actual);
	}

	@Test
	void getModalbackground() {
		String expected = "primary";
		String actual = genericmodalImpl.getModalbackground();
		assertEquals(expected, actual);
	}

	@Test
	void getSize() {
		String expected = "medium";
		String actual = genericmodalImpl.getSize();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = genericmodalImpl.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getCtaMultiField() {
		Resource expected = context.resourceResolver().getResource("/content/ctaMultiField");
		genericmodalImpl = context.request().adaptTo(GenericmodalImpl.class);
		assert genericmodalImpl != null;
		Resource actual = genericmodalImpl.getCtaMultiField();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
}
