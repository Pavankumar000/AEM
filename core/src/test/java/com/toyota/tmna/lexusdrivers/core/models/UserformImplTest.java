package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.NameinputImpl;
import com.toyota.tmna.lexusdrivers.core.models.impl.UserformImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class UserformImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private UserformImpl userformImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(UserformImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/UserformImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		userformImpl = context.request().adaptTo(UserformImpl.class);
	}

	@Test
	void getSuccessPageUrl() {
		String expected = "successPageUrl";
		String actual = userformImpl.getSuccessPageUrl();
		assertEquals(expected, actual);
	}

	@Test
	void getAccountTypeBusinessLabel() {
		String expected = "accountTypeBusinessLabel";
		String actual = userformImpl.getAccountTypeBusinessLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getSubmitButtonLabel() {
		String expected = "submitButtonLabel";
		String actual = userformImpl.getSubmitButtonLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getAccountTypeIndividualLabel() {
		String expected = "accountTypeIndividualLabel";
		String actual = userformImpl.getAccountTypeIndividualLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getTitle() {
		String expected = "title";
		String actual = userformImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getForgotPasswordText() {
		String expected = "forgotPasswordText";
		String actual = userformImpl.getForgotPasswordText();
		assertEquals(expected, actual);
	}

	@Test
	void getAccountTypeLabel() {
		String expected = "accountTypeLabel";
		String actual = userformImpl.getAccountTypeLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getDescription() {
		String expected = "description";
		String actual = userformImpl.getDescription();
		assertEquals(expected, actual);
	}

	@Test
	void getEmailField() {
		String expected = "emailField";
		String actual = userformImpl.getEmailField();
		assertEquals(expected, actual);
	}
	@Test
	void getPhoneNumberLabel() {
		String expected = "phoneNumberLabel";
		String actual = userformImpl.getPhoneNumberLabel();
		assertEquals(expected, actual);
	}
	@Test
	void getBusinessNameLabel() {
		String expected = "businessNameLabel";
		String actual = userformImpl.getBusinessNameLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getBusinessNameLengthPattern() {
		String expected = "businessNameLengthPattern";
		String actual = userformImpl.getBusinessNameLengthPattern();
		assertEquals(expected, actual);
	}

	@Test
	void getBusinessNameLengthMessage() {
		String expected = "businessNameLengthMessage";
		String actual = userformImpl.getBusinessNameLengthMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getBusinessNameRequiredMessage() {
		String expected = "businessNameRequiredMessage";
		String actual = userformImpl.getBusinessNameRequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getFirstNameLabel() {
		String expected = "firstNameLabel";
		String actual = userformImpl.getFirstNameLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getFirstNameLengthPattern() {
		String expected = "firstNameLengthPattern";
		String actual = userformImpl.getFirstNameLengthPattern();
		assertEquals(expected, actual);
	}

	@Test
	void getFirstNameLengthMessage() {
		String expected = "firstNameLengthMessage";
		String actual = userformImpl.getFirstNameLengthMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getFirstNameRequiredMessage() {
		String expected = "firstNameRequiredMessage";
		String actual = userformImpl.getFirstNameRequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getLastNameLabel() {
		String expected = "lastNameLabel";
		String actual = userformImpl.getLastNameLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getLastNameLengthPattern() {
		String expected = "lastNameLengthPattern";
		String actual = userformImpl.getLastNameLengthPattern();
		assertEquals(expected, actual);
	}

	@Test
	void getLastNameLengthMessage() {
		String expected = "lastNameLengthMessage";
		String actual = userformImpl.getLastNameLengthMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getLastNameRequiredMessage() {
		String expected = "lastNameRequiredMessage";
		String actual = userformImpl.getLastNameRequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getConfirmPasswordLabel() {
		String expected = "confirmPasswordLabel";
		String actual = userformImpl.getConfirmPasswordLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getConfirmPasswordRequiredMessage() {
		String expected = "confirmPasswordRequiredMessage";
		String actual = userformImpl.getConfirmPasswordRequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getConfirmPasswordValidation() {
		String expected = "confirmPasswordValidation";
		String actual = userformImpl.getConfirmPasswordValidation();
		assertEquals(expected, actual);
	}

	@Test
	void getPasswordLabel() {
		String expected = "passwordLabel";
		String actual = userformImpl.getPasswordLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getPasswordRequiredMessage() {
		String expected = "passwordRequiredMessage";
		String actual = userformImpl.getPasswordRequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getHideLabel() {
		String expected = "hideLabel";
		String actual = userformImpl.getHideLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getShowLabel() {
		String expected = "showLabel";
		String actual = userformImpl.getShowLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getAgreementText() {
		String expected = "agreementText";
		String actual = userformImpl.getAgreementText();
		assertEquals(expected, actual);
	}
	
	@Test
	void getFirstNameValidations(){
		Resource expected = context.resourceResolver().getResource("/content/firstNameValidations");
		userformImpl = context.request().adaptTo(UserformImpl.class);
		assert userformImpl != null;
		Resource actual = userformImpl.getFirstNameValidations();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
	@Test
	void getLastNameValidations(){
		Resource expected = context.resourceResolver().getResource("/content/lastNameValidations");
		userformImpl = context.request().adaptTo(UserformImpl.class);
		assert userformImpl != null;
		Resource actual = userformImpl.getLastNameValidations();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
	@Test
	void getBusinessNameValidations(){
		Resource expected = context.resourceResolver().getResource("/content/businessNameValidations");
		userformImpl = context.request().adaptTo(UserformImpl.class);
		assert userformImpl != null;
		Resource actual = userformImpl.getBusinessNameValidations();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
	@Test
	void getPasswordValidations(){
		Resource expected = context.resourceResolver().getResource("/content/passwordValidations");
		userformImpl = context.request().adaptTo(UserformImpl.class);
		assert userformImpl != null;
		Resource actual = userformImpl.getPasswordValidations();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
	@Test
	void getEmailValidations(){
		Resource expected = context.resourceResolver().getResource("/content/emailValidations");
		userformImpl = context.request().adaptTo(UserformImpl.class);
		assert userformImpl != null;
		Resource actual = userformImpl.getEmailValidations();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = userformImpl.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getphoneNumberValidations() {
		Resource actual = userformImpl.getPhoneNumberValidations();
		assertNotNull(actual);
	}

}
