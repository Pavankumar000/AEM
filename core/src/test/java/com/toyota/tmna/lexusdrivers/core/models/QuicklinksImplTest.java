package com.toyota.tmna.lexusdrivers.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.apache.sling.api.resource.Resource;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.toyota.tmna.lexusdrivers.core.models.impl.QuicklinksImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class QuicklinksImplTest {
	private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private QuicklinksImpl quicklinksImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(QuicklinksImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/QuicklinksImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		quicklinksImpl = context.request().adaptTo(QuicklinksImpl.class);
	}

	@Test
	void getTitle() {
		String expected = "QUICK LINKS";
		String actual = quicklinksImpl.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void getHeader() {
		String expected = "header";
		String actual = quicklinksImpl.getHeader();
		assertEquals(expected, actual);
	}

	@Test
	void getExportedType() {
		String expected = "nt:unstructured";
		String actual = quicklinksImpl.getExportedType();
		assertEquals(expected, actual);
	}

	@Test
	void getQuickLinks() {
		Resource expected = context.resourceResolver().getResource("/content/quickLinks");
		quicklinksImpl = context.request().adaptTo(QuicklinksImpl.class);
		assert quicklinksImpl != null;
		Resource actual = quicklinksImpl.getQuickLinks();
		assertNotNull(actual);
		assert expected != null;
		assertEquals(expected.getPath(), actual.getPath());
		assertEquals(expected.getValueMap().toString(), actual.getValueMap().toString());
	}

	@Test
	void getSignInUrl() {
		String expected = "signinurl";
		String actual = quicklinksImpl.getSignInUrl();
		assertEquals(expected, actual);

	}

	@Test
	void getSignInButtonText() {
		String expected = "signInButtonText";
		String actual = quicklinksImpl.getSignInButtonText();
		assertEquals(expected, actual);

	}

	@Test
	void getCreateAccountUrl() {
		String expected = "createAccountUrl";
		String actual = quicklinksImpl.getCreateAccountUrl();
		assertEquals(expected, actual);

	}

	@Test
	void getCreateAccountButtonText() {
		String expected = "CreateAccountButtonText";
		String actual = quicklinksImpl.getCreateAccountButtonText();
		assertEquals(expected, actual);

	}

}
