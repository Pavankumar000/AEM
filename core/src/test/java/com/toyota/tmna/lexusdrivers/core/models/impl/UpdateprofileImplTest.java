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


package com.toyota.tmna.lexusdrivers.core.models.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;


@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class UpdateprofileImplTest {

   private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private UpdateprofileImpl updateprofileImpl;
  

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(UpdateprofileImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/UpdateProfileImplTest.json", "/content");
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/UpdateProfileStateImplTest.json", 
				"/content/lexusdrivers/us/en/configuration/states/jcr:content/root/responsivegrid/stateconfiguration/multilist");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		updateprofileImpl = context.request().adaptTo(UpdateprofileImpl.class);
	}



    @Test
    void getFirstName() {
    String expected = "firstName";
		String actual = updateprofileImpl.getFirstName();
		assertEquals(expected, actual);
      
    }

    @Test
    void getBusinessUserName() {
       String expected = "businessUserName";
		String actual = updateprofileImpl.getBusinessUserName();
		assertEquals(expected, actual);
    }

    @Test
     void getlastName() {
      String expected = "lastName";
		String actual = updateprofileImpl.getlastName();
		assertEquals(expected, actual);
    }

    @Test
     void getReTypeNewPasswordLabel() {
    String expected = "reTypeNewPasswordLabel";
		String actual = updateprofileImpl.getReTypeNewPasswordLabel();
		assertEquals(expected, actual);
    }

    @Test
     void getNewPasswordLabel() {
    String expected = "newPasswordLabel";
		String actual = updateprofileImpl.getNewPasswordLabel();
		assertEquals(expected, actual);
    }

    

    @Test
     void getCancelLabel() {
      String expected = "cancelLabel";
		String actual = updateprofileImpl.getCancelLabel();
		assertEquals(expected, actual);
    }

	@Test
	void getComponentType() {
		String expected = "componenttype";
		String actual = updateprofileImpl.getComponenttype();
		assertEquals(expected, actual);
	}

	@Test
	void getSuccessMsg() {
		String expected = "successMsg";
		String actual = updateprofileImpl.getSuccessMsg();
		assertEquals(expected, actual);
	}

	@Test
	void getzipCityMismatch() {
		String expected = "zipCityMismatch";
		String actual = updateprofileImpl.getzipCityMismatch();
		assertEquals(expected, actual);
	}

	@Test
	void getSocialErrorMsg() {
		String expected = "socialErrorMsg";
		String actual = updateprofileImpl.getSocialErrorMsg();
		assertEquals(expected, actual);
	}

	@Test
	void getShowLabel() {
		String expected = "showLabel";
		String actual = updateprofileImpl.getShowLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getHideLabel() {
		String expected = "hideLabel";
		String actual = updateprofileImpl.getHideLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getBusinessUserNamerequiredMessage() {
		String expected = "businessUserNamerequiredMessage";
		String actual = updateprofileImpl.getBusinessUserNamerequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getLastNamerequiredMessage() {
		String expected = "lastNamerequiredMessage";
		String actual = updateprofileImpl.getLastNamerequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getPrimaryPhoneNumberLabel() {
		String expected = "primaryPhoneNumberLabel";
		String actual = updateprofileImpl.getPrimaryPhoneNumberLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getPhoneNumberLabel() {
		String expected = "phoneNumberLabel";
		String actual = updateprofileImpl.getPhoneNumberLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getAddress2Placeholder() {
		String expected = "address2Placeholder";
		String actual = updateprofileImpl.getAddress2Placeholder();
		assertEquals(expected, actual);
	}

	@Test
	void getAddress1Placeholder() {
		String expected = "address1Placeholder";
		String actual = updateprofileImpl.getAddress1Placeholder();
		assertEquals(expected, actual);
	}

	@Test
	void getPasswordHelpText() {
		String expected = "passwordHelpText";
		String actual = updateprofileImpl.getPasswordHelpText();
		assertEquals(expected, actual);
	}

	@Test
	void getCurrentPasswordLabel() {
		String expected = "currentPasswordLabel";
		String actual = updateprofileImpl.getCurrentPasswordLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getYourInformationLabel() {
		String expected = "yourInformationLabel";
		String actual = updateprofileImpl.getYourInformationLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getEditLabel() {
		String expected = "editLabel";
		String actual = updateprofileImpl.getEditLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getAddressValidations() {
		Resource object = updateprofileImpl.getAddressValidations();
		assertNotNull(object);
	}

	@Test
	void getCurrentPasswordReqMessage() {
		String expected = "currentPasswordReqMessage";
		String actual = updateprofileImpl.getCurrentPasswordReqMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getPasswordValidations() {
		Resource object = updateprofileImpl.getPasswordValidations();
		assertNotNull(object);
	}

	@Test
	void getReTypePasswordReqMessage() {
		String expected = "reTypePasswordReqMessage";
		String actual = updateprofileImpl.getReTypePasswordReqMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getLastNameRules() {
		Resource object = updateprofileImpl.getLastNameRules();
		assertNotNull(object);
	}

	@Test
	void getUserNameRules() {
		Resource object = updateprofileImpl.getUserNameRules();
		assertNotNull(object);
	}

	@Test
	void getStateList() {
		Resource object = updateprofileImpl.getStateList();
		assertNotNull(object);
	}

	@Test
	void getZipCodeValidations() {
		Resource object = updateprofileImpl.getZipCodeValidations();
		assertNotNull(object);
	}

	@Test
	void getPhoneNumberValidations() {
		Resource object = updateprofileImpl.getPhoneNumberValidations();
		assertNotNull(object);
	}

	@Test
	void getZipInputLabel() {
		String expected = "zipInputLabel";
		String actual = updateprofileImpl.getZipInputLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getEmailUsedErrorMessage() {
		String expected = "emailUsedErrorMessage";
		String actual = updateprofileImpl.getEmailUsedErrorMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getLabel() {
		String expected = "label";
		String actual = updateprofileImpl.getLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getEmailLabel() {
		String expected = "emailLabel";
		String actual = updateprofileImpl.getEmailLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getRequiredMessage() {
		String expected = "requiredMessage";
		String actual = updateprofileImpl.getRequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getSubmitLabel() {
		String expected = "submitLabel";
		String actual = updateprofileImpl.getSubmitLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getEmailValidations() {
		Resource object = updateprofileImpl.getEmailValidations();
		assertNotNull(object);
	}

	@Test
	void getRules() {
		Resource object = updateprofileImpl.getRules();
		assertNotNull(object);
	}

	@Test
	void getExported() {
		String object = updateprofileImpl.getExportedType();
		assertNotNull(object);
	}

	@Test
	void getAddressLabelLabel() {
		String expected = "addressLabel";
		String actual = updateprofileImpl.getAddressLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getCityLabel() {
		String expected = "cityLabel";
		String actual = updateprofileImpl.getCityLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getCityRequiredMessage() {
		String expected = "cityRequiredMessage";
		String actual = updateprofileImpl.getCityRequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getAddressRequiredMessage() {
		String expected = "addressRequiredMessage";
		String actual = updateprofileImpl.getAddressRequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getChangePasswordLabel() {
		String expected = "changePasswordLabel";
		String actual = updateprofileImpl.getChangePasswordLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getZipNotValid() {
		String expected = "zipNotValid";
		String actual = updateprofileImpl.getZipNotValid();
		assertEquals(expected, actual);
	}


	@Test
	void getSubmitReimbrusementLabel() {
		String expected = "submitReimbrusementLabel";
		String actual = updateprofileImpl.getSubmitReimbrusementLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getSubmitReimbrusementLink() {
		String expected = "submitReimbrusementLink";
		String actual = updateprofileImpl.getSubmitReimbrusementLink();
		assertEquals(expected, actual);
	}

	@Test
	void getZipStateMismatch() {
		String expected = "zipStateMismatch";
		String actual = updateprofileImpl.getZipStateMismatch();
		assertEquals(expected, actual);
	}

	@Test
	void getOrderHardCopyTitle() {
		String expected = "orderHardCopyTitle";
		String actual = updateprofileImpl.getOrderHardCopyTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getDisclaimerMessage() {
		String expected = "disclaimerMessage";
		String actual = updateprofileImpl.getDisclaimerMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getVinAssociatedError() {
		String expected = "vinAssociatedError";
		String actual = updateprofileImpl.getVinAssociatedError();
		assertEquals(expected, actual);
	}

	@Test
	void getUnknownError() {
		String expected = "unknownError";
		String actual = updateprofileImpl.getUnknownError();
		assertEquals(expected, actual);
	}

	@Test
	void getCloseIcon() {
		String expected = "closeIcon";
		String actual = updateprofileImpl.getCloseIcon();
		assertEquals(expected, actual);
	}
}
