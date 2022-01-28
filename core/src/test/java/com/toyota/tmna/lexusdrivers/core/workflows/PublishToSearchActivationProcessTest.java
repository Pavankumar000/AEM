package com.toyota.tmna.lexusdrivers.core.workflows;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Property;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.adobe.granite.workflow.metadata.SimpleMetaDataMap;
import com.day.cq.wcm.api.Page;
import com.toyota.tmna.lexusdrivers.core.search.services.DisclaimerService;
import com.toyota.tmna.lexusdrivers.core.search.services.RewardsService;
import com.toyota.tmna.lexusdrivers.core.search.services.StoriesService;
import com.toyota.tmna.lexusdrivers.core.search.services.VideosService;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
class PublishToSearchActivationProcessTest {
/*	
	private final AemContext context = new AemContext();
	
	@InjectMocks
    PublishToSearchActivationProcess publishToSearchActivationProcess;
	
	@Mock
	DisclaimerService disclaimerService;
	@Mock
	private RewardsService rewardsService;
	@Mock
	private StoriesService storiesService;
	@Mock
	private VideosService videosService;
	@Mock
	WorkflowSession workflowSession;
	@Mock
	WorkflowData workflowData;
	@Mock
	ResourceResolver resolver;
	@Mock
	Node node,masternode;
	@Mock
	Property prop1,prop2,prop3,prop4;
	
	  @Mock 
	  WorkItem item;
	  MetaDataMap metaDataMap;
	  @Mock
	 Resource resource,bannerres;
	  @Mock
	  Page page;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		metaDataMap=new SimpleMetaDataMap();
		when(item.getWorkflowData()).thenReturn(workflowData);
	}

	@Test
	void testDisclaimerExecute() throws Exception {
		String disclamierPath="/content/dam/lexusdrivers/content-fragments/disclaimers/ESCOMPARISON";
		when(workflowData.getPayload()).thenReturn(disclamierPath);
		when(workflowSession.adaptTo(ResourceResolver.class)).thenReturn(resolver);
		when(resolver.getResource(disclamierPath+"/jcr:content/data/master")).thenReturn(resource);
		Map<String, Object> properties = new HashMap<>();
		properties.put("Name", "Test Disclaimer");
		properties.put("Description", "Test Description");
		properties.put("delete", true);
		 ValueMap valueMap = new ValueMapDecorator(properties);
		when(resource.adaptTo(ValueMap.class)).thenReturn(valueMap);
		publishToSearchActivationProcess.execute(item, workflowSession, metaDataMap);
	}
	@Test
	void testStoriesExecute() throws Exception {
		String path="/content/lexusdrivers/us/en/lexusdrivers/benefits/experiences/ART1681";
		String storiesWrapperResPath = path + "/jcr:content/root/responsivegrid/ExperiencePageview/wrapper";
		//String storiesHeroBannerResPath = path + "/jcr:content/root/responsivegrid/herobanner/tiles/item0";
		when(workflowData.getPayload()).thenReturn(path);
		when(workflowSession.adaptTo(ResourceResolver.class)).thenReturn(resolver);
		when(resolver.getResource(storiesWrapperResPath)).thenReturn(resource);
		//when(resolver.getResource(storiesHeroBannerResPath)).thenReturn(bannerres);
		Map<String, Object> properties = new HashMap<>();
		properties.put("articleID", "Test articleID");
		properties.put("title", "Test Title");
		properties.put("metaTags", "tag");
		 ValueMap valueMap = new ValueMapDecorator(properties);
		when(resource.adaptTo(ValueMap.class)).thenReturn(valueMap);
		Map<String, Object> bannerprop = new HashMap<>();
		bannerprop.put("desktopImg", "/content/dam/lexusdrivers/desktop.jpg");
		bannerprop.put("MobileImage", "/content/dam/lexusdrivers/mobile.jpg");
		bannerprop.put("tabletImage", "/content/dam/lexusdrivers/tablet.jpg");
		 ValueMap bannervalueMap = new ValueMapDecorator(bannerprop);
		when(bannerres.adaptTo(ValueMap.class)).thenReturn(bannervalueMap);
		publishToSearchActivationProcess.execute(item, workflowSession, metaDataMap);
	}
	@Test
	void testRewardsExecute() throws Exception {
		String path="/content/lexusdrivers/us/en/lexusdrivers/benefits/rewards/ART2079";
		String rewardActualRes = path + "/jcr:content/root/responsivegrid/rewardspageview/wrapper";
		when(workflowData.getPayload()).thenReturn(path);
		when(workflowSession.adaptTo(ResourceResolver.class)).thenReturn(resolver);
		when(resolver.getResource(rewardActualRes)).thenReturn(resource);
		Map<String, Object> properties = new HashMap<>();
		properties.put("articleID", "Test articleID");
		properties.put("title", "Test Title");
		properties.put("metaTags", "tag");
		 ValueMap valueMap = new ValueMapDecorator(properties);
		when(resource.adaptTo(ValueMap.class)).thenReturn(valueMap);
		publishToSearchActivationProcess.execute(item, workflowSession, metaDataMap);
	}


	@Test
	void testVideosExecute() throws Exception {
		String path="/content/lexusdrivers/us/en/lexusdrivers/resources/videos";
		String rewardActualRes = path + "/jcr:content/root/responsivegrid/videospageview/wrapper";
		when(workflowData.getPayload()).thenReturn(path);
		when(workflowSession.adaptTo(ResourceResolver.class)).thenReturn(resolver);
		when(resolver.getResource("/content/lexusdrivers/us/en/lexusdrivers/resources/videos")).thenReturn(resource);
		when(resolver.getResource(rewardActualRes)).thenReturn(resource);

		when(resource.adaptTo(Page.class)).thenReturn(page);
		Iterator<Page> mockIterator = Mockito.mock(Iterator.class);
		when(page.listChildren()).thenReturn(mockIterator);
		//when(mockIterator.hasNext()).thenReturn(true);
		when(mockIterator.next()).thenReturn(page);
		when(mockIterator.next().getPath()).thenReturn(path);
		when(mockIterator.hasNext()).thenReturn(false);
		Map<String, Object> properties = new HashMap<>();
		properties.put("section_type", "Test Video");
		properties.put("description", "Test description");
		properties.put("rank", "5");
		 ValueMap valueMap = new ValueMapDecorator(properties);
		when(resource.adaptTo(ValueMap.class)).thenReturn(valueMap);
		publishToSearchActivationProcess.execute(item, workflowSession, metaDataMap);
	}
	 
*/
}
