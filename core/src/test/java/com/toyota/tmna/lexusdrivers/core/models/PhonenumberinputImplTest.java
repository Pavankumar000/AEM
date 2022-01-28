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
import com.toyota.tmna.lexusdrivers.core.models.impl.PhonenumberinputImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class PhonenumberinputImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private PhonenumberinputImpl phonenumberinputImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(PhonenumberinputImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/PhonenumberinputImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		phonenumberinputImpl = context.request().adaptTo(PhonenumberinputImpl.class);
	}
	
	@Test
	public void getPhoneNumberValidations() {
		Resource expected = context.resourceResolver().getResource("/content/phoneNumberValidations");
		phonenumberinputImpl = context.request().adaptTo(PhonenumberinputImpl.class);
		assert phonenumberinputImpl != null;
		Resource actual = phonenumberinputImpl.getPhoneNumberValidations();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
    }
    
	@Test
	public void getExportedType() {
		String expected = "nt:unstructured";
		String actual = phonenumberinputImpl.getExportedType();
		assertEquals(expected, actual);
    }
    
    @Test
	public void getPhoneNumberLabel() {
    	String expected = "phoneNumberLabel";
		String actual = phonenumberinputImpl.getPhoneNumberLabel();
		assertEquals(expected, actual);
    }

}
