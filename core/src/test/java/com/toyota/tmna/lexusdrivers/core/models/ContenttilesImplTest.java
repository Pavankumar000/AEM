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
import com.toyota.tmna.lexusdrivers.core.models.impl.ContenttilesImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ContenttilesImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private ContenttilesImpl contenttilesImp;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(ContenttilesImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ContentTilesImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		contenttilesImp = context.request().adaptTo(ContenttilesImpl.class);
	}

	@Test
	void getTitle() {
		String expected = "This is title";
		String actual = contenttilesImp.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = contenttilesImp.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getTiles() {
		Resource expected = context.resourceResolver().getResource("/content/tiles");
		contenttilesImp = context.request().adaptTo(ContenttilesImpl.class);
        assert contenttilesImp != null;
        Resource actual = contenttilesImp.getTiles();
        assertNotNull(actual);
        assert expected != null;
        assertEquals(expected.getPath(), actual.getPath());
        assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}
}
