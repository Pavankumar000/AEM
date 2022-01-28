package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.HerovideobannerImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class HerovideobannerImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private HerovideobannerImpl herovideobannerImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(HerovideobannerImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/HerovideobannerImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		herovideobannerImpl = context.request().adaptTo(HerovideobannerImpl.class);
	}

	@Test
	void getVideoSource() {
		String expected = "/content/dam/lexusdrivers/media/Home/Default/Hero/2019/Videos/LDNG-Logged-out-HP-Video_TOM_051619.mp4";
		String actual = herovideobannerImpl.getVideoSource();
		assertEquals(expected, actual);
	}

	@Test
	void getVideoSourceAlt() {
		String expected = "Hero Video Alt";
		String actual = herovideobannerImpl.getVideoSourceAlt();
		assertEquals(expected, actual);
	}

	@Test
	void getImageSourceAlt() {
		String expected = "Image Source Alt";
		String actual = herovideobannerImpl.getImageSourceAlt();
		assertEquals(expected, actual);
	}

	@Test
	void getId() {
		String expected = "Desktop Image Alt";
		String actual = herovideobannerImpl.getId();
		assertEquals(expected, actual);
	}

	@Test
	void getDesktopImageAlt() {
		String expected = "Desktop Image Alt";
		String actual = herovideobannerImpl.getDesktopImageAlt();
		assertEquals(expected, actual);
	}

	@Test
	void getMobileImageAlt() {
		String expected = "Mobile Image Alt";
		String actual = herovideobannerImpl.getMobileImageAlt();
		assertEquals(expected, actual);
	}

	@Test
	void getTabletImageAlt() {
		String expected = "Tablet Image Alt";
		String actual = herovideobannerImpl.getTabletImageAlt();
		assertEquals(expected, actual);
	}

	@Test
	void getLegalCopy() {
		String expected = "Legal Copy";
		String actual = herovideobannerImpl.getLegalCopy();
		assertEquals(expected, actual);
	}

	@Test
	void getNickNameText() {
		String expected = "Nick Name Text";
		String actual = herovideobannerImpl.getNickNameText();
		assertEquals(expected, actual);
	}

	@Test
	void getViewSpecsText() {
		String expected = "View Specs Text";
		String actual = herovideobannerImpl.getViewSpecsText();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = herovideobannerImpl.getExportedType();
		assertEquals(expected, actual);
	}
	@Test
	void getImageSource(){
		String expected = "Image Source";
		String actual = herovideobannerImpl.getImageSource();
		assertEquals(expected, actual);
	}
	@Test
	void getDesktopImage(){
		String expected = "Desktop Image";
		String actual = herovideobannerImpl.getDesktopImage();
		assertEquals(expected, actual);
	}
	@Test
	void getMobileImage(){
		String expected = "Mobile Image";
		String actual = herovideobannerImpl.getMobileImage();
		assertEquals(expected, actual);
	}
	@Test
	void getTabletImage(){
		String expected = "Tablet Image";
		String actual = herovideobannerImpl.getTabletImage();
		assertEquals(expected, actual);
	}
	@Test
	void getViewSpecsLink(){
		String expected = "View Specs Link";
		String actual = herovideobannerImpl.getViewSpecsLink();
		assertEquals(expected, actual);
	}
	@Test
	void getVINText(){
		String expected = "VIN Text";
		String actual = herovideobannerImpl.getVINText();
		assertEquals(expected, actual);
	}
}
