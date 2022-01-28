package com.toyota.tmna.lexusdrivers.core.models.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingBindings;
import org.apache.sling.models.factory.ModelFactory;
import org.apache.sling.servlethelpers.MockSlingHttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.scripting.WCMBindingsConstants;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
class HerobannervideoImplTest {

	private final AemContext context = new AemContext();
	 @Mock
		private ModelFactory modelFactory;
	 @Mock
	 private Page currentPage;
	 MockSlingHttpServletRequest request;
	 HerobannervideoImpl herobannervideoImpl;
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context.addModelsForClasses(HerobannervideoImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/HerobannervideoImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		request=context.request();
		SlingBindings slingBindings=(SlingBindings)request.getAttribute(SlingBindings.class.getName());
		slingBindings.put(WCMBindingsConstants.NAME_CURRENT_PAGE, currentPage);
		Resource resource =context.currentResource("/content");
		request.setResource(resource);
		herobannervideoImpl=request.adaptTo(HerobannervideoImpl.class);
	}

	@Test
	void testHeroBannerVideoProp() {
		assertNotNull(herobannervideoImpl);
		assertEquals("id", herobannervideoImpl.getId());
		assertEquals("video_type", herobannervideoImpl.getVideo_type());
		assertEquals("video_title", herobannervideoImpl.getVideo_title());
		assertEquals("title", herobannervideoImpl.getTitle());
		assertEquals("subTitle", herobannervideoImpl.getSubTitle());
		assertEquals(false, herobannervideoImpl.getShowInitialContent());
		assertEquals("videoDesc", herobannervideoImpl.getVideoDesc());
		herobannervideoImpl.getExportedType();
	}

}
