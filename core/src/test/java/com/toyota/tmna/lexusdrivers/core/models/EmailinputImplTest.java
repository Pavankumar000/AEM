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
import com.toyota.tmna.lexusdrivers.core.models.impl.EmailinputImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class EmailinputImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private EmailinputImpl emailinputImpl;
	
	@BeforeEach
	void setUp() {
		context.addModelsForClasses(EmailinputImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/EmailinputImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		emailinputImpl = context.request().adaptTo(EmailinputImpl.class);
	}
	@Test
	void getLabel(){
		String expected = "emailLabel";
		String actual = emailinputImpl.getEmailLabel();
		assertEquals(expected, actual);
	}
	
	@Test
	void getEmailUsedErrorMessage(){
		String expected = "email error message";
		String actual = emailinputImpl.getEmailUsedErrorMessage();
		assertEquals(expected, actual);
	}
	
	@Test
	void getEmailValidationsRules() {
		Resource expected = context.resourceResolver().getResource("/content/emailValidations");
		emailinputImpl = context.request().adaptTo(EmailinputImpl.class);
        assert emailinputImpl != null;
        Resource actual = emailinputImpl.getEmailValidations();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
	
	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = emailinputImpl.getExportedType();
		assertEquals(expected, actual);
	}

}
