package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.ExploredriversImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ExploredriversImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private ExploredriversImpl exploredriversImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(ExploredriversImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ExploredriversImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content/Exploredrivers");
		exploredriversImpl = context.request().adaptTo(ExploredriversImpl.class);

	}

	@Test
	void getTitle() {
		String expected = "title";
		String actual = exploredriversImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getSubTitle() {
		String expected = "sub title";
		String actual = exploredriversImpl.getSubTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getTileImagePath() {
		String expected = "image path";
		String actual = exploredriversImpl.getTileImagePath();
		assertEquals(expected, actual);
	}

	@Test
	void getLinkText() {
		String expected = "Link Text";
		String actual = exploredriversImpl.getLinkText();
		assertEquals(expected, actual);
	}

	@Test
	void getPageUrl() {
		String expected = "page url";
		String actual = exploredriversImpl.getPageUrl();
		assertEquals(expected, actual);
	}

	@Test
	void getTagText() {
		String expected = "tag text";
		String actual = exploredriversImpl.getTagText();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = exploredriversImpl.getExportedType();
		assertEquals(expected, actual);
	}
}
