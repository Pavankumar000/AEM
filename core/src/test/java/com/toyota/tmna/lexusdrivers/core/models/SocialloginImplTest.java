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
import com.toyota.tmna.lexusdrivers.core.models.impl.SocialloginImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class SocialloginImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private SocialloginImpl socialloginImplTest;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(SocialloginImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/SocialloginImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		socialloginImplTest = context.request().adaptTo(SocialloginImpl.class);
	}

	@Test
	void getSocialtypedetails() {
		Resource expected = context.resourceResolver().getResource("/content/socialtypedetails");
		socialloginImplTest = context.request().adaptTo(SocialloginImpl.class);
		assert socialloginImplTest != null;
		Resource actual = socialloginImplTest.getSocialtypedetails();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = socialloginImplTest.getExportedType();
		assertEquals(expected, actual);
	}
	
	@Test
	void getDescription() {
		String expected = "description";
		String actual = socialloginImplTest.getDescription();
		assertEquals(expected, actual);
	}
}
