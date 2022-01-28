package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.DisplaymessagewrapperImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class DisplaymessagewrapperImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private DisplaymessagewrapperImpl displaymessagewrapperImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(DisplaymessagewrapperImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/DisplaymessagewrapperImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		displaymessagewrapperImpl = context.request().adaptTo(DisplaymessagewrapperImpl.class);
	}

	@Test
	void getDisplayTitle() {
		String expected = "SUCCESS";
		String actual = displaymessagewrapperImpl.getDisplayTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getDisplayDescription() {
		String expected = "description";
		String actual = displaymessagewrapperImpl.getDisplayDescription();
		assertEquals(expected, actual);
	}

	@Test
	void getDisplayPrimaryButtonLink() {
		String expected = "/content/lexusdrivers/us/en/home";
		String actual = displaymessagewrapperImpl.getDisplayPrimaryButtonLink();
		assertEquals(expected, actual);
	}

	@Test
	void getDisplayPrimaryButtonText() {
		String expected = "OK";
		String actual = displaymessagewrapperImpl.getDisplayPrimaryButtonText();
		assertEquals(expected, actual);
	}

	@Test
	void getDisplaySupportContent() {
		String expected = "Support Content";
		String actual = displaymessagewrapperImpl.getDisplaySupportContent();
		assertEquals(expected, actual);
	}

	@Test
	void getDisplayVerticalCenterAlign() {
		boolean expected = true;
		boolean actual = displaymessagewrapperImpl.getDisplayVerticalCenterAlign();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = displaymessagewrapperImpl.getExportedType();
		assertEquals(expected, actual);
	}
}
