package com.toyota.tmna.lexusdrivers.core.models.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.models.factory.ModelFactory;
import org.apache.sling.servlethelpers.MockSlingHttpServletRequest;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.adobe.cq.sightly.WCMBindings;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.scripting.WCMBindingsConstants;
import com.toyota.tmna.lexusdrivers.core.models.Breadcrumb;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({AemContextExtension.class,MockitoExtension.class})
class BreadcrumbImplTest {
	
	 private final AemContext context = new AemContext();
	 @Mock
		private ModelFactory modelFactory;
	 @Mock
	 private Page currentPage;
		BreadcrumbImpl breadcrumbImpl;
		MockSlingHttpServletRequest request;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context.addModelsForClasses(BreadcrumbImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/BreadcrumbImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		Resource resource =context.currentResource("/content");
		request=context.request();
		SlingBindings slingBindings=(SlingBindings)request.getAttribute(SlingBindings.class.getName());
		slingBindings.put(WCMBindingsConstants.NAME_CURRENT_PAGE, currentPage);
		breadcrumbImpl=request.adaptTo(BreadcrumbImpl.class);
	}

	@Test
	void testBreadCurmbProps() {
		assertNotNull(breadcrumbImpl);
		breadcrumbImpl.getItems();
		breadcrumbImpl.getExportedType();
		breadcrumbImpl.getSubcategories();
		assertEquals("1", breadcrumbImpl.getStartLevel());
		assertEquals("Home", breadcrumbImpl.getHeaderRibbon());
		assertEquals("#", breadcrumbImpl.getHeaderRibbonLink());
		assertEquals("Menu", breadcrumbImpl.getMenuLabel());
		assertEquals(true, breadcrumbImpl.getHideCurrent());
		assertEquals(false, breadcrumbImpl.getShowHiddenItems());
		assertEquals(true, breadcrumbImpl.getShowSubCategories());

	}

}
