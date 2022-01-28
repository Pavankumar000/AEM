package com.toyota.tmna.lexusdrivers.core.models;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Source;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.factory.IFactory;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

@Model(adaptables = SlingHttpServletRequest.class, resourceType = HeaderConfiguration.RESOURCE_TYPE, adapters = {
		HeaderConfiguration.class,
		ComponentExporter.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HeaderConfiguration implements ComponentExporter {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	protected static final String RESOURCE_TYPE = ConstantsUtil.CONFIG_PATH;


    @Inject @Self
    private Resource resource;
    
    @Reference
    private ResourceResolverFactory resolverFactory;
    
    @Inject
    @Source("sling-object")
    private ResourceResolver resourceResolver;
    
    @OSGiService
    private IFactory headerFactory;
    
    private Map<String, Map<String, String>> endPointsMap = new HashMap<>();
    
    @PostConstruct
    protected void init() {
    	endPointsMap = headerFactory.getEndPointsMap();
    }
   
	public AppConfig getAppConfigs() {
		String resourcePath = "/content/dam/lexusdrivers/content-fragments/appconfig/app-config";
	    Resource SRMResource = resourceResolver.resolve(resourcePath);
	    AppConfig cfSRM = SRMResource.adaptTo(AppConfig.class);
	    return cfSRM;
	}
	
	public Map<String, Map<String, String>> getExternalService() {
		return endPointsMap;
	}

	@Override
	public String getExportedType() {
		return RESOURCE_TYPE;
	}
}
