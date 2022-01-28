package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.VehicleinfopanelImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class VehicleinfopanelImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private VehicleinfopanelImpl vehicleinfopanelImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(VehicleinfopanelImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/VehicleinfopanelImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		vehicleinfopanelImpl = context.request().adaptTo(VehicleinfopanelImpl.class);

	}

	@Test
	void getJellytitle() {
		String expected = "jellytitle";
		String actual = vehicleinfopanelImpl.getJellytitle();
		assertEquals(expected, actual);
	}

	@Test
	void getButtonlink() {
		String expected = "buttonlink";
		String actual = vehicleinfopanelImpl.getButtonlink();
		assertEquals(expected, actual);
	}

	@Test
	void getButtontext() {
		String expected = "buttontext";
		String actual = vehicleinfopanelImpl.getButtontext();
		assertEquals(expected, actual);
	}

	@Test
	void getDefaultDescription() {
		String expected = "defaultDescription";
		String actual = vehicleinfopanelImpl.getDefaultDescription();
		assertEquals(expected, actual);
	}

	@Test
	void getDefaultJelly() {
		String expected = "defaultJelly";
		String actual = vehicleinfopanelImpl.getDefaultJelly();
		assertEquals(expected, actual);
	}

	@Test
	void getHasCapabilityDesc() {
		String expected = "hasCapabilityDesc";
		String actual = vehicleinfopanelImpl.getHasCapabilityDesc();
		assertEquals(expected, actual);
	}

	@Test
	void getVINLabel() {
		String expected = "VINLabel";
		String actual = vehicleinfopanelImpl.getVINLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getHasCapabilityTitle() {
		String expected = "hasCapabilityTitle";
		String actual = vehicleinfopanelImpl.getHasCapabilityTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getNoCapabilityTitle() {
		String expected = "noCapabilityTitle";
		String actual = vehicleinfopanelImpl.getNoCapabilityTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getVehicleLabel() {
		String expected = "vehicleLabel";
		String actual = vehicleinfopanelImpl.getVehicleLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getDefaultTitle() {
		String expected = "defaultTitle";
		String actual = vehicleinfopanelImpl.getDefaultTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = vehicleinfopanelImpl.getExportedType();
		assertNotNull(expected);
	}

	@Test
	void getMEIDLabel() {
		String expected = "MEIDLabel";
		String actual = vehicleinfopanelImpl.getMEIDLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getIMEILabel() {
		String expected = "IMEILabel";
		String actual = vehicleinfopanelImpl.getIMEILabel();
		assertEquals(expected, actual);
	}

	@Test
	void getNoCapabilityDesc() {
		String expected = "noCapabilityDesc";
		String actual = vehicleinfopanelImpl.getNoCapabilityDesc();
		assertEquals(expected, actual);
	}


}
