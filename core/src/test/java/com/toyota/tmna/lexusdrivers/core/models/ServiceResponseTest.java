package com.toyota.tmna.lexusdrivers.core.models;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class ServiceResponseTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private ServiceResponse serviceResponse;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(ServiceResponse.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/ServiceResponseTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		serviceResponse = Objects.requireNonNull(context.currentResource()).adaptTo(ServiceResponse.class);
	}

	@Test
	void getTitle() {
		String actual = serviceResponse.getModelTitle();
		assertNotNull(actual);
	}

	@Test
	void getEndPoint() {
		String actual = serviceResponse.getEndPoint();
		assertNotNull(actual);
	}


	@Test
	void getRequestType() {
		String expected = "request-type";
		String actual = this.serviceResponse.getResponseCode();
		assertNotNull(actual);
	}

	@Test
	void getResponseCode() {
		String expected = "response-code";
		String actual = serviceResponse.getResponseCode();
		assertNotNull(actual);
	}

	@Test
	void getMessage() {
		String expected = "message";
		String actual = serviceResponse.getMessage();
		assertNotNull(actual);
	}

	@Test
	void getPurpose() {
		String expected = "purpose";
		String actual = serviceResponse.getPurpose();
		assertNotNull(actual);
	}



}
