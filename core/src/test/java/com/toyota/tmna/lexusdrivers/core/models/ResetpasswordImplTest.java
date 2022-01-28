package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.models.impl.ResetpasswordImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ResetpasswordImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private ResetpasswordImpl resetpasswordImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(ResetpasswordImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ResetpasswordImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		resetpasswordImpl = context.request().adaptTo(ResetpasswordImpl.class);
	}

	@Test
	void getTitle() {
		String expected = "RESET YOUR PASSWORD";
		String actual = resetpasswordImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getDescription() {
		String expected = "show";
		String actual = resetpasswordImpl.getDescription();
		assertEquals(expected, actual);
	}

	@Test
	void getPasswordLabel() {
		String expected = "Password";
		String actual = resetpasswordImpl.getPasswordLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getPasswordRequiredMessage() {
		String expected = "Make sure that your password meets the following requirements.";
		String actual = resetpasswordImpl.getPasswordRequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getPasswordLengthPattern() {
		String expected = "length";
		String actual = resetpasswordImpl.getPasswordLengthPattern();
		assertEquals(expected, actual);
	}

	@Test
	void getConfirmPasswordLabel() {
		String expected = "Confirm password";
		String actual = resetpasswordImpl.getConfirmPasswordLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getConfirmPasswordRequiredMessage() {
		String expected = "Passwords do not match. Please try again.";
		String actual = resetpasswordImpl.getConfirmPasswordRequiredMessage();
		assertEquals(expected, actual);
	}

	@Test
	void getConfirmPasswordValidation() {
		String expected = "Passwords do not match. Please try again.";
		String actual = resetpasswordImpl.getConfirmPasswordValidation();
		assertEquals(expected, actual);
	}

	@Test
	void getShowLabel() {
		String expected = "show";
		String actual = resetpasswordImpl.getShowLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getHideLabel() {
		String expected = "hide";
		String actual = resetpasswordImpl.getHideLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getResetButtonText() {
		String expected = "Reset";
		String actual = resetpasswordImpl.getResetButtonText();
		assertEquals(expected, actual);
	}

	@Test
	void getNeedMoreHelp() {
		String expected = "Need More Help";
		String actual = resetpasswordImpl.getNeedMoreHelp();
		assertEquals(expected, actual);
	}

	@Test
	void getSuccessPage() {
		String expected = "Success Page";
		String actual = resetpasswordImpl.getSuccessPage();
		assertEquals(expected, actual);
	}

	@Test
	void getName() {
		String expected = "name";
		String actual = resetpasswordImpl.getName();
		assertEquals(expected, actual);
	}
	
	@Test
	void getPasswordValidations() {
		Resource expected = context.resourceResolver().getResource("/content/passwordValidations");
		resetpasswordImpl = context.request().adaptTo(ResetpasswordImpl.class);
        assert resetpasswordImpl != null;
        Resource actual = resetpasswordImpl.getPasswordValidations();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = resetpasswordImpl.getExportedType();
		assertEquals(expected, actual);
	}
}
