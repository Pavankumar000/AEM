package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.VehiclecardImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class VehiclecardImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private VehiclecardImpl vehiclecardImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(VehiclecardImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/VehiclecardImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		vehiclecardImpl = context.request().adaptTo(VehiclecardImpl.class);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = vehiclecardImpl.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getTitle() {
		String expected = "Title";
		String actual = vehiclecardImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getSetPrimvehicle() {
		String expected = "Set as Primary Vehicle";
		String actual = vehiclecardImpl.getSetPrimvehicle();
		assertEquals(expected, actual);
	}

	@Test
	void getPrimVehicle() {
		String expected = "Primary Vehicle";
		String actual = vehiclecardImpl.getPrimVehicle();
		assertEquals(expected, actual);
	}

	@Test
	void getManagecta() {
		String expected = "Manage this Vehicle";
		String actual = vehiclecardImpl.getManagecta();
		assertEquals(expected, actual);
	}

	@Test
	void getDeletevehiclelabel() {
		String expected = "Delete this vehicle";
		String actual = vehiclecardImpl.getDeletevehiclelabel();
		assertEquals(expected, actual);
	}

	@Test
	void getVinlabel() {
		String expected = "VIN";
		String actual = vehiclecardImpl.getVinlabel();
		assertEquals(expected, actual);
	}

	@Test
	void getNoVinLabel() {
		String expected = "ADD VEHICLE VIN TO MANAGE THIS VEHICLE";
		String actual = vehiclecardImpl.getNoVinLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getNoVinButtonLabel() {
		String expected = "Add VIN";
		String actual = vehiclecardImpl.getNoVinButtonLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getOthertitle() {
		String expected = "See your Other Vehicle";
		String actual = vehiclecardImpl.getOthertitle();
		assertEquals(expected, actual);
	}

	@Test
	void getOtherprimvehicle() {
		String expected = "Set as Primary Vehicle";
		String actual = vehiclecardImpl.getOtherprimvehicle();
		assertEquals(expected, actual);
	}

	@Test
	void getOtherdescription() {
		String expected = "OD";
		String actual = vehiclecardImpl.getOtherdescription();
		assertEquals(expected, actual);
	}

	@Test
	void getSelectvehiclelabel() {
		String expected = "Select a Vehicle";
		String actual = vehiclecardImpl.getSelectvehiclelabel();
		assertEquals(expected, actual);
	}

	@Test
	void getOtherVehicleButton() {
		String expected = "Vehicle Specifications";
		String actual = vehiclecardImpl.getOtherVehicleButton();
		assertEquals(expected, actual);
	}

	@Test
	void getDefaultImg() {
		String expected = "defaultImg";
		String actual = vehiclecardImpl.getDefaultImg();
		assertEquals(expected, actual);
	}

	@Test
	void getCardType() {
		String expected = "cardType";
		String actual = vehiclecardImpl.getCardType();
		assertEquals(expected, actual);
		assertEquals("manageVehicleCTALink", vehiclecardImpl.getManageVehicleCTALink());

	}
}
