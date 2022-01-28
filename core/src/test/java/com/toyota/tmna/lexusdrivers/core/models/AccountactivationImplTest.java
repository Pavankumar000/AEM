package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.AccountactivationImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class AccountactivationImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private AccountactivationImpl accountactivationImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(AccountactivationImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/AccountactivationImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		accountactivationImpl = context.request().adaptTo(AccountactivationImpl.class);

	}

	@Test
	void getErrorPageUrl() {
		String expected = "error url";
		String actual = accountactivationImpl.getErrorPageUrl();
		assertEquals(expected, actual);
	}

	@Test
	void getSuccessPageUrl() {
		String expected = "success url";
		String actual = accountactivationImpl.getSuccessPageUrl();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = accountactivationImpl.getExportedType();
		assertEquals(expected, actual);
	}
}
