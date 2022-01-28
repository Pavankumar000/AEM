package com.toyota.tmna.lexusdrivers.core.models.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

import com.day.cq.wcm.foundation.model.responsivegrid.ResponsiveGrid;
import com.toyota.tmna.lexusdrivers.core.models.ServiceLandingContainer;


@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { ServiceLandingContainerImpl.class,
		ComponentExporter.class }, resourceType = ServiceLandingContainerImpl.RESOURCETYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)

@SuppressWarnings({"CQRules:CQBP-84", "CQRules:CQBP-84-dependencies"})
public class ServiceLandingContainerImpl extends ResponsiveGrid implements ServiceLandingContainer {
	
	protected static final String RESOURCETYPE = "lexusdrivers/components/structure/serviceLandingcontainer";
	@SlingObject
	private Resource resource;

	@Override
	public String[] getExportedItemsOrder() {
		return super.getExportedItemsOrder();
	}

	@Override
	public Map<String, ? extends ComponentExporter> getExportedItems() {
		 return super.getExportedItems();
	}


	@Override
	public String getExportedType() {
		return resource.getResourceType();
	}

}
