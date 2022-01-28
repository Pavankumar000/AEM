package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.VideoimagecopypanelImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class VideoimagecopypanelImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private VideoimagecopypanelImpl videoimagecopypanelImplTest;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(VideoimagecopypanelImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/VideoimagecopypanelImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		videoimagecopypanelImplTest = context.request().adaptTo(VideoimagecopypanelImpl.class);
	}

	@Test
	void getTitle() {
		String expected = "Title-PRODUCT PANEL";
		String actual = videoimagecopypanelImplTest.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getDescription() {
		String expected = "Description";
		String actual = videoimagecopypanelImplTest.getDescription();
		assertEquals(expected, actual);
	}

	@Test
	void getIcon() {
		String expected = "/content/dam/lexusdrivers/media/global-safety-connect-icon-55x55.png";
		String actual = videoimagecopypanelImplTest.getIcon();
		assertEquals(expected, actual);
	}

	@Test
	void getType() {
		String expected = "ProductPanel";
		String actual = videoimagecopypanelImplTest.getType();
		assertEquals(expected, actual);
	}

	@Test
	void getAlignment() {
		String expected = "center";
		String actual = videoimagecopypanelImplTest.getAlignment();
		assertEquals(expected, actual);
	}

	@Test
	void getCtaLink() {
		String expected = "/content/lexusdrivers/language-masters";
		String actual = videoimagecopypanelImplTest.getCtaLink();
		assertEquals(expected, actual);
	}

	@Test
	void getCtatext() {
		String expected = "Learn More";
		String actual = videoimagecopypanelImplTest.getCtatext();
		assertEquals(expected, actual);
	}

	@Test
	void getHasDividerLine() {
		String expected = "true";
		String actual = videoimagecopypanelImplTest.getHasDividerLine();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = videoimagecopypanelImplTest.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getImage() {
		String expected = "IMAGE";
		String actual = videoimagecopypanelImplTest.getImage();
		assertEquals(expected, actual);
	}

	@Test
	void getVideo() {
		String expected = "VIDO";
		String actual = videoimagecopypanelImplTest.getVideo();
		assertEquals(expected, actual);
	}

	@Test
	void getExtrapadding() {
		String expected = "true";
		String actual = videoimagecopypanelImplTest.getExtrapadding();
		assertEquals(expected, actual);
	}

	@Test
	void getHeader() {
		String expected = "header";
		String actual = videoimagecopypanelImplTest.getHeader();
		assertEquals(expected, actual);
	}

	@Test
	void getImagealt() {
		String expected = "IMAGE ALT";
		String actual = videoimagecopypanelImplTest.getImagealt();
		assertEquals(expected, actual);
	}
	
	@Test
	void getCtatype() {
		String expected = "ctatype";
		String actual = videoimagecopypanelImplTest.getCtatype();
		assertEquals(expected, actual);
	}

	@Test
	void getAssetsource() {
		String expected = "Asset";
		String actual = videoimagecopypanelImplTest.getAssetsource();
		assertEquals(expected, actual);
	}

	@Test
	void getTextplacement() {
		String expected = "bottom";
		String actual = videoimagecopypanelImplTest.getTextplacement();
		assertEquals(expected, actual);
	}
	
	@Test
	void getAssetType() {
		String expected = "assetType";
		String actual = videoimagecopypanelImplTest.getAssetType();
		assertEquals(expected, actual);
	}

	@Test
	void getArticleType() {
		String expected = "articleType";
		String actual = videoimagecopypanelImplTest.getArticleType();
		assertEquals(expected, actual);
	}

	@Test
	void getMyList() {
		String expected = "myList";
		String actual = videoimagecopypanelImplTest.getMyList();
		assertEquals(expected, actual);
	}

	@Test
	void getnotApplicableMyList() {
		String expected = "notApplicableMyList";
		String actual = videoimagecopypanelImplTest.getNotApplicableMyList();
		assertEquals(expected, actual);
	}

	@Test
	void getShowCTA() {
		String expected = "showCTA";
		String actual = videoimagecopypanelImplTest.getShowCTA();
		assertEquals(expected, actual);
		assertNull(videoimagecopypanelImplTest.getCtaLinks());
	}
}
