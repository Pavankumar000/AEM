package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.StateinputImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class StateinputImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private StateinputImpl stateinputImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(StateinputImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/StateinputImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		stateinputImpl = context.request().adaptTo(StateinputImpl.class);
	}

	@Test
	void getStateInputLabel() {
		String expected = "stateInputLabel";
		String actual = stateinputImpl.getStateInputLabel();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = stateinputImpl.getExportedType();
		assertEquals(expected, actual);
	}
}
