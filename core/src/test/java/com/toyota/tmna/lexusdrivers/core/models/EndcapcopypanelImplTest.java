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
import com.toyota.tmna.lexusdrivers.core.models.impl.EndcapcopypanelImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class EndcapcopypanelImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private EndcapcopypanelImpl endcapcopypanelImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(EndcapcopypanelImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/EndcapcopypanelImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		endcapcopypanelImpl = context.request().adaptTo(EndcapcopypanelImpl.class);
	}

	@Test
	void getTitle() {
		String expected = "Title";
		String actual = endcapcopypanelImpl.getTitle();
		assertEquals(expected, actual);
	}

	

	@Test
	void getTitleStyle() {
		String expected = "heading-2";
		String actual = endcapcopypanelImpl.getTitleStyle();
		assertEquals(expected, actual);
	}

	@Test
	void getTagline() {
		String expected = "Tagline";
		String actual = endcapcopypanelImpl.getTagline();
		assertEquals(expected, actual);
	}

	@Test
	void getTaglineStyle() {
		String expected = "heading-2";
		String actual = endcapcopypanelImpl.getTaglineStyle();
		assertEquals(expected, actual);
	}

	@Test
	void getDescription() {
		String expected = "Description";
		String actual = endcapcopypanelImpl.getDescription();
		assertEquals(expected, actual);
	}

	@Test
	void getComponentStyle() {
		String expected = "transparent";
		String actual = endcapcopypanelImpl.getComponentStyle();
		assertEquals(expected, actual);
	}

	@Test
	void getenableCustomCSS() {
		String expected = "enableCustomCSS";
		String actual = endcapcopypanelImpl.getEnableCustomCSS();
		assertEquals(expected, actual);
	}

	@Test
	void getCtaMultiField() {
		Resource expected = context.resourceResolver().getResource("/content/ctaMultiField");
		endcapcopypanelImpl = context.request().adaptTo(EndcapcopypanelImpl.class);
        assert endcapcopypanelImpl != null;
        Resource actual = endcapcopypanelImpl.getCtaMultiField();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = endcapcopypanelImpl.getExportedType();
		assertEquals(expected, actual);
	}
}
