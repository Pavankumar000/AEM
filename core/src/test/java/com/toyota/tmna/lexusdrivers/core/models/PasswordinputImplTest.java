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
import com.toyota.tmna.lexusdrivers.core.models.impl.PasswordinputImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class PasswordinputImplTest {

	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private PasswordinputImpl passwordinputImpl;
	
	@BeforeEach
	void setUp() {
		context.addModelsForClasses(PasswordinputImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/PasswordinputImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		passwordinputImpl = context.request().adaptTo(PasswordinputImpl.class);
	}
	
   @Test
    void getConfirmPasswordLabel() {
	   String expected = "label";
		String actual = passwordinputImpl.getConfirmPasswordLabel();
		assertEquals(expected, actual);
    }

   @Test
    void getConfirmPasswordRequiredMessage() {
	   String expected = "confirmPasswordRequiredMessage";
		String actual = passwordinputImpl.getConfirmPasswordRequiredMessage();
		assertEquals(expected, actual);
    }

   @Test
    void getConfirmPasswordValidation() {
	   String expected = "confirmPasswordValidation";
		String actual = passwordinputImpl.getConfirmPasswordValidation();
		assertEquals(expected, actual);
    }

   @Test
    void getPasswordLabel() {
	   String expected = "passwordLabel";
		String actual = passwordinputImpl.getPasswordLabel();
		assertEquals(expected, actual);
    }

   @Test
    void getPasswordRequiredMessage() {
	   String expected = "passwordRequiredMessage";
		String actual = passwordinputImpl.getPasswordRequiredMessage();
		assertEquals(expected, actual);
    }

   @Test
    void getHideLabel() {
	   String expected = "hideLabel";
		String actual = passwordinputImpl.getHideLabel();
		assertEquals(expected, actual);
    }

   @Test
    void getShowLabel() {
	   String expected = "showLabel";
		String actual = passwordinputImpl.getShowLabel();
		assertEquals(expected, actual);
    }

	@Test
	void getPasswordValidations() {
		Resource expected = context.resourceResolver().getResource("/content/passwordValidations");
		passwordinputImpl = context.request().adaptTo(PasswordinputImpl.class);
		assert passwordinputImpl != null;
		Resource actual = passwordinputImpl.getPasswordValidations();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
   
   @Test
    void getExportedType() {
		String expected = "nt:unstructured";
		String actual = passwordinputImpl.getExportedType();
		assertEquals(expected, actual);
    }
}
