package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.models.impl.VehiclespecDetailsImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })

public class VehicalespecDetailsImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private VehiclespecDetailsImpl vehiclespecDetailsImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(VehiclespecDetailsImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/VehiclespecDetailsImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		vehiclespecDetailsImpl = context.request().adaptTo(VehiclespecDetailsImpl.class);
	}
}
