/*

 * ***********************************************************************

 * Lexus Drivers CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus Drivers.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus Drivers and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus Drivers

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus Drivers.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.AddvehicleImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;


@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class AddvehicleImplTest {

	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private Addvehicle model;

    @BeforeEach
    public void setUp()
        throws Exception
    {
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
    	context.addModelsForClasses(AddvehicleImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/AddvehicleImplTest.json", "/content");
		context.currentResource("/content");
		model = context.request().adaptTo(Addvehicle.class);
    }

    @Test
    public void testGetNoServiceDataMessage() {
      model.getAddVehicleBtnLabel();
      model.getTitle();
      model.getAddVehicleType();
      model.getAnotherBtnText();
      model.getBackBtnLabel();
      model.getDuplicateVehicleError();
      model.getExportedType();
      model.getSelectModelLabel();
      model.getSelectYearLabel();
      model.getSuccessBtnText();
      model.getSuccessImage();
      model.getSuccessImgAltText();
      model.getSuccessMsg();
      model.getSuccessTitle();
      model.getVehicleDescription();
      model.getVehicleError();
      model.getVehicleMaxLimit();
      model.getVehicleModelDesc();
      model.getVinAltText();
      model.getVinDescription();
      model.getVinFieldLabel();
      model.getVinImage();
      model.getVinPrimaryBtnLabel();
      model.getVinSecondaryBtnLabel();
      model.getAddressValidations();
      model.getVinTitle();
      model.getVinCTALabel();
      assertEquals("Enter your 17 character VIN", model.getVinText());
    }

}
