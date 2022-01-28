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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.toyota.tmna.lexusdrivers.core.models.impl.CarouselImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class CarouselImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private CarouselImpl carouselImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(CarouselImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/CarouselImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		carouselImpl = context.request().adaptTo(CarouselImpl.class);
	}

	@Test
	void getTitle() {
		String expected = "LEXUS SUMMER SERVICE EVENT";
		String actual = carouselImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getAutoScroll() {
		boolean expected = true;
		boolean actual = carouselImpl.getAutoScroll();
		assertEquals(expected, actual);
	}

	@Test
	void getTimebetweenslides() {
		long expected = 10;
		long actual = carouselImpl.getTimebetweenslides();
		assertEquals(expected, actual);
	}

	@Test
	void getCarouselslides() {
		Resource expected = context.resourceResolver().getResource("/content/carouselslides");
		carouselImpl = context.request().adaptTo(CarouselImpl.class);
		assert carouselImpl != null;
		Resource actual = carouselImpl.getCarouselslides();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = carouselImpl.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	@JsonProperty("selection")
	void getType() {
		String expected = null;
		String actual = carouselImpl.getType();
		assertEquals(expected, actual);
	}

	@Test
	void getCtaMultiField() {
		Resource expected = context.resourceResolver().getResource("/content/ctaMultiField");
		carouselImpl = context.request().adaptTo(CarouselImpl.class);
		assert carouselImpl != null;
		Resource actual = carouselImpl.getCtaMultiField();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
	@Test
	void getDisclaimer() {
		String expected = "Disclaimer";
		String actual = carouselImpl.getDisclaimer();
		assertEquals(expected, actual);
	}

	@Test
	void getSubTitle() {
		String expected = "Sub Title";
		String actual = carouselImpl.getSubTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getId(){
		assert carouselImpl != null;
		String actual = carouselImpl.getId();
		assertNotNull(actual);
	}

}
