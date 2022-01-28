package com.toyota.tmna.lexusdrivers.core.models.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.models.factory.ModelFactory;
import org.apache.sling.servlethelpers.MockSlingHttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.designer.Style;
import com.day.cq.wcm.scripting.WCMBindingsConstants;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
class HerobannerImplTest {
	private final AemContext context = new AemContext();
	 @Mock
		private ModelFactory modelFactory;
	 @Mock
	 private Page currentPage;
	 HerobannerImpl herobannerImpl;
		MockSlingHttpServletRequest request;
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context.addModelsForClasses(HerobannerImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/HerobannerImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		request=context.request();
		SlingBindings slingBindings=(SlingBindings)request.getAttribute(SlingBindings.class.getName());
		slingBindings.put(WCMBindingsConstants.NAME_CURRENT_PAGE, currentPage);
		Resource resource =context.currentResource("/content");
		request.setResource(resource);
		herobannerImpl=request.adaptTo(HerobannerImpl.class);
	}

	@Test
	void testHeroBannerProp() {
		assertNotNull(herobannerImpl);
		assertEquals("notApplicableMyList", herobannerImpl.getNotApplicableMyList());
		assertEquals("myList", herobannerImpl.getmyList());
		assertEquals("showInEditor", herobannerImpl.getShowInEditor());
		assertEquals("primaryCTA", herobannerImpl.getPrimaryCTA());
		assertEquals("makePrimaryCTA", herobannerImpl.getMakePrimaryCTA());
		assertEquals("successMessage", herobannerImpl.getSuccessMessage());
		assertEquals("legalCopy", herobannerImpl.getLegalCopy());
		assertEquals("id", herobannerImpl.getId());
		assertEquals("video_type", herobannerImpl.getVideo_type());
		assertEquals("video_title", herobannerImpl.getVideo_title());
		assertEquals("disclaimer", herobannerImpl.getDisclaimer());
		assertEquals("joinDesc", herobannerImpl.getJoinDesc());
		herobannerImpl.getExportedType();
		herobannerImpl.getTiles();
	}

}
