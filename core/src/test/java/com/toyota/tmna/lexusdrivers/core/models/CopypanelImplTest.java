package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.CopypanelImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class CopypanelImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private CopypanelImpl copypanelImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(CopypanelImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/CopypanelImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		copypanelImpl = context.request().adaptTo(CopypanelImpl.class);
	}

	@Test
	void getTitle() {
		String expected = "Title-PRODUCT PANEL";
		String actual = copypanelImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getDescription() {
		String expected = "Description";
		String actual = copypanelImpl.getDescription();
		assertEquals(expected, actual);
	}

	@Test
	void getIcon() {
		String expected = "/content/dam/lexusdrivers/media/global-safety-connect-icon-55x55.png";
		String actual = copypanelImpl.getIcon();
		assertEquals(expected, actual);
	}

	@Test
	void getType() {
		String expected = "ProductPanel";
		String actual = copypanelImpl.getType();
		assertEquals(expected, actual);
	}

	@Test
	void getAlignment() {
		String expected = "center";
		String actual = copypanelImpl.getAlignment();
		assertEquals(expected, actual);
	}

	@Test
	void getCtaLink() {
		String expected = "/content/lexusdrivers/language-masters";
		String actual = copypanelImpl.getCtaLink();
		assertEquals(expected, actual);
	}

	@Test
	void getCtatext() {
		String expected = "Learn More";
		String actual = copypanelImpl.getCtatext();
		assertEquals(expected, actual);
	}

	@Test
	void getHasDividerLine() {
		String expected = "true";
		String actual = copypanelImpl.getHasDividerLine();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = copypanelImpl.getExportedType();
		assertEquals(expected, actual);
	}
	
	@Test
	void getImage() {
		String expected = "IMAGE";
		String actual = copypanelImpl.getImage();
		assertEquals(expected, actual);
	}

	@Test
	void getVideo() {
		String expected = "VIDO";
		String actual = copypanelImpl.getVideo();
		assertEquals(expected, actual);
	}

	@Test
	void getExtrapadding() {
		String expected = "true";
		String actual = copypanelImpl.getExtrapadding();
		assertEquals(expected, actual);
	}

	@Test
	void getHeader() {
		String expected = "header";
		String actual = copypanelImpl.getHeader();
		assertEquals(expected, actual);
	}

	@Test
	void getImagealt() {
		String expected = "IMAGE ALT";
		String actual = copypanelImpl.getImagealt();
		assertEquals(expected, actual);
	}

	@Test
	void getCtatype() {
		String expected = "ctatype";
		String actual = copypanelImpl.getCtatype();
		assertEquals(expected, actual);
	}


	@Test
	void getJoinDesc() {
		String expected = "joinDesc";
		String actual = copypanelImpl.getJoinDesc();
		assertEquals(expected, actual);
	}

	@Test
	void getRichTextTitle() {
		String expected = "richTextTitle";
		String actual = copypanelImpl.getRichTextTitle();
		assertEquals(expected, actual);
	}
	@Test
	void getShowHeaderasLink() {
		String expected = "false";
		String actual = copypanelImpl.getShowHeaderasLink();
		assertEquals(expected, actual);
	}
	@Test
	void getShowTitleInasLink() {
		String expected = "false";
		String actual = copypanelImpl.getShowTitleInasLink();
		assertEquals(expected, actual);
	}
}
