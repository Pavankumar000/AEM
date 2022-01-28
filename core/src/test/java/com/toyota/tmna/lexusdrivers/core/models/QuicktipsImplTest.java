package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.QuicktipsImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class QuicktipsImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private QuicktipsImpl quicktipsImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(QuicktipsImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/QuicktipsImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		quicktipsImpl = context.request().adaptTo(QuicktipsImpl.class);
	}

	@Test
	void getTitle() {
		String expected = "QUICK TIPS";
		String actual = quicktipsImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getSubTitle() {
		String expected = "Sub Title";
		String actual = quicktipsImpl.getSubTitle();
		assertEquals(expected, actual);
	}
	
	@Test
	void getDescription() {
		String expected = "Description";
		String actual = quicktipsImpl.getDescription();
		assertEquals(expected, actual);
	}
	
	@Test
	void getImage() {
		String expected = "/content/dam/lexusdrivers/media/global-safety-connect-icon-55x55.png";
		String actual = quicktipsImpl.getImage();
		assertEquals(expected, actual);
	}
	
	@Test
	void getOpacity() {
		String expected = "0.7";
		String actual = quicktipsImpl.getOpacity();
		assertEquals(expected, actual);
	}
	
	@Test
	void getLargeTileImage() {
		String expected = "/content/dam/lexusdrivers/media/global-safety-connect-icon-55x55.png";
		String actual = quicktipsImpl.getLargeTileImage();
		assertEquals(expected, actual);
	}
	
	@Test
	void getMediumTileImage() {
		String expected = "/content/dam/lexusdrivers/media/global-safety-connect-icon-55x55.png";
		String actual = quicktipsImpl.getMediumTileImage();
		assertEquals(expected, actual);
	}
	
	@Test
	void getSmallTileImage() {
		String expected = "/content/dam/lexusdrivers/media/global-safety-connect-icon-55x55.png";
		String actual = quicktipsImpl.getSmallTileImage();
		assertEquals(expected, actual);
	}
	
	@Test
	void getTileImageOpacity() {
		String expected = "0.7";
		String actual = quicktipsImpl.getTileImageOpacity();
		assertEquals(expected, actual);
	}
	
	@Test
	void getVideoUrl() {
		String expected = "/content/dam/lexusdrivers/media/global-safety-connect-icon-55x55.png";
		String actual = quicktipsImpl.getVideoUrl();
		assertEquals(expected, actual);
	}
	
	@Test
	void getVideoId() {
		String expected = "vId12345";
		String actual = quicktipsImpl.getVideoId();
		assertEquals(expected, actual);
	}
	
	@Test
	void getPrimaryLinkText() {
		String expected = "Learn More";
		String actual = quicktipsImpl.getPrimaryLinkText();
		assertEquals(expected, actual);

	}
	
	@Test
	void getPrimaryLink() {
		String expected = "/content/lexusdrivers/language-masters";
		String actual = quicktipsImpl.getPrimaryLink();
		assertEquals(expected, actual);

	}
	
	@Test
	void getSecondaryLinkText() {
		String expected = "Secondary Learn More";
		String actual = quicktipsImpl.getSecondaryLinkText();
		assertEquals(expected, actual);

	}
	
	@Test
	void getSecondaryLink() {
		String expected = "/content/lexusdrivers/language-masters";
		String actual = quicktipsImpl.getSecondaryLink();
		assertEquals(expected, actual);

	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = quicktipsImpl.getExportedType();
		assertEquals(expected, actual);
	}

}
