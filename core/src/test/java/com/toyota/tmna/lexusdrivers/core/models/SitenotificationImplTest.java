package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.sling.api.resource.Resource;
import com.toyota.tmna.lexusdrivers.core.models.impl.SitenotificationImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class SitenotificationImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private SitenotificationImpl sitenotificationImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(SitenotificationImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/SitenotificationImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		sitenotificationImpl = context.request().adaptTo(SitenotificationImpl.class);
	}
	
	@Test
	void getSitenotifications(){
		Resource expected = context.resourceResolver().getResource("/content/sitenotifications");
		sitenotificationImpl = context.request().adaptTo(SitenotificationImpl.class);
        assert sitenotificationImpl != null;
        Resource actual = sitenotificationImpl.getSitenotifications();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = sitenotificationImpl.getExportedType();
		assertEquals(expected, actual);
	}
}
