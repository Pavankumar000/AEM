package com.toyota.tmna.lexusdrivers.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.StateConfiguration;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { ConfigurationComponentImpl.class,
		ComponentExporter.class }, resourceType = "lexusdrivers/components/content/stateconfiguration")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ConfigurationComponentImpl implements StateConfiguration {

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String componenttype;

	@SlingObject
	private Resource resource;

	@Override
	public String getExportedType() {
		return resource.getResourceType();
	}

	@Override
	public String getComponenttype() {
		return componenttype;
	}
	
	@ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource multilist;

	public Resource getMultilist() {
		return multilist;
	}
	
	

}
