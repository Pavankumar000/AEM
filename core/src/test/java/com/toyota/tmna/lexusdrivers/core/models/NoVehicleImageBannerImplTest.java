package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.NoVehicleImageBannerImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class NoVehicleImageBannerImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private NoVehicleImageBannerImpl noVehicleImageBannerImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(NoVehicleImageBannerImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/NoVehicleImageBannerImplTest.json",
				"/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		noVehicleImageBannerImpl = context.request().adaptTo(NoVehicleImageBannerImpl.class);
	}
	
	//===
		@Test
		void getLabel() {
			String expected = "label";
			String actual = noVehicleImageBannerImpl.getLabel();
			assertEquals(expected, actual);
		}

		@Test
		void getDesktop_banner_image() {
			String expected = "desktop_banner_image";
			String actual = noVehicleImageBannerImpl.getDesktop_banner_image();
			assertEquals(expected, actual);
		}

		@Test
		void getDesktop_alt_text() {
			String expected = "desktop_alt_text";
			String actual = noVehicleImageBannerImpl.getDesktop_alt_text();
			assertEquals(expected, actual);
		}

		@Test
		void getTablet_banner_image() {
			String expected = "tablet_banner_image";
			String actual = noVehicleImageBannerImpl.getTablet_banner_image();
			assertEquals(expected, actual);
		}

		@Test
		void getTablet_alt_text() {
			String expected = "tablet_alt_text";
			String actual = noVehicleImageBannerImpl.getTablet_alt_text();
			assertEquals(expected, actual);
		}

		@Test
		void getMobile_banner_image() {
			String expected = "mobile_banner_image";
			String actual = noVehicleImageBannerImpl.getMobile_banner_image();
			assertEquals(expected, actual);
		}

		@Test
		void getMobile_alt_text() {
			String expected = "mobile_alt_text";
			String actual = noVehicleImageBannerImpl.getMobile_alt_text();
			assertEquals(expected, actual);
		}

		@Test
		void getPrimarybutton() {
			String expected = "primary btn text";
			String actual = noVehicleImageBannerImpl.getPrimarybutton();
			assertEquals(expected, actual);
		}

		@Test
		void getPrimarybuttonURL() {
			String expected = "primary button url";
			String actual = noVehicleImageBannerImpl.getPrimarybuttonURL();
			assertEquals(expected, actual);
		}
		@Test
		void getExportedType() {
			String expected = "nt:unstructured";
			String actual = noVehicleImageBannerImpl.getExportedType();
			assertEquals(expected, actual);
		}
}
