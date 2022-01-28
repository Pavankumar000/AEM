package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.SelectedVehicleVideoBannerImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class SelectedVehicleVideoBannerImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private SelectedVehicleVideoBannerImpl selectedVehicleVideoBannerImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(SelectedVehicleVideoBannerImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/SelectedVehicleVideoBannerImplTest.json",
				"/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		selectedVehicleVideoBannerImpl = context.request().adaptTo(SelectedVehicleVideoBannerImpl.class);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = selectedVehicleVideoBannerImpl.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getVinLabel() {
		String expected = "VIN";
		String actual = selectedVehicleVideoBannerImpl.getVinLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getFuelTypeLabel() {
		String expected = "Fuel Type";
		String actual = selectedVehicleVideoBannerImpl.getFuelTypeLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getCapacityTypeLabel() {
		String expected = "Capacity";
		String actual = selectedVehicleVideoBannerImpl.getCapacityTypeLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getViewSpecLink() {
		String expected = "viewSpecLink";
		String actual = selectedVehicleVideoBannerImpl.getViewSpecLink();
		assertEquals(expected, actual);
	}

	@Test
	void getViewSpecText() {
		String expected = "View Specifications Text";
		String actual = selectedVehicleVideoBannerImpl.getViewSpecText();
		assertEquals(expected, actual);
	}

	@Test
	void getNickName() {
		String expected = "Nick Name";
		String actual = selectedVehicleVideoBannerImpl.getNickName();
		assertEquals(expected, actual);
	}

	@Test
	void getNickNameIcon() {
		String expected = "Nick Name Icon";
		String actual = selectedVehicleVideoBannerImpl.getNickNameIcon();
		assertEquals(expected, actual);
	}

	
	@Test
	void getAddvinLabel() {
		String expected = "addvinLabel";
		String actual = selectedVehicleVideoBannerImpl.getAddvinLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getDefaultDesktopImage() {
		String expected = "defaultDesktopImage";
		String actual = selectedVehicleVideoBannerImpl.getDefaultDesktopImage();
		assertEquals(expected, actual);
	}

	@Test
	void getAltDesktop() {
		String expected = "altDesktop";
		String actual = selectedVehicleVideoBannerImpl.getDesktopAlt();
		assertEquals(expected, actual);
	}

	@Test
	void getDefaultTabletImage() {
		String expected = "defaultTabletImage";
		String actual = selectedVehicleVideoBannerImpl.getDefaultTabletImage();
		assertEquals(expected, actual);
	}

	@Test
	void getAltTablet() {
		String expected = "altTablet";
		String actual = selectedVehicleVideoBannerImpl.getTabletAlt();
		assertEquals(expected, actual);
	}

	@Test
	void getDefaultMobileImage() {
		String expected = "defaultMobileImage";
		String actual = selectedVehicleVideoBannerImpl.getDefaultMobileImage();
		assertEquals(expected, actual);
	}

	@Test
	void getAltMobile() {
		String expected = "altMobile";
		String actual = selectedVehicleVideoBannerImpl.getMobileAlt();
		assertEquals(expected, actual);
	}

	@Test
	void getDefaultVideoSource() {
		String expected = "defaultVideoSource";
		String actual = selectedVehicleVideoBannerImpl.getDefaultVideoSource();
		assertEquals(expected, actual);
	}

	@Test
	void getDefaultImageSource() {
		String expected = "defaultImageSource";
		String actual = selectedVehicleVideoBannerImpl.getDefaultImageSource();
		assertEquals(expected, actual);
	}

	@Test
	void getLegalCopy() {
		String expected = "legalCopy";
		String actual = selectedVehicleVideoBannerImpl.getLegalCopy();
		assertEquals(expected, actual);
	}

	@Test
	void getAltDefaultImage() {
		String expected = "altDefaultImage";
		String actual = selectedVehicleVideoBannerImpl.getAltDefaultImage();
		assertEquals(expected, actual);
	}
}
