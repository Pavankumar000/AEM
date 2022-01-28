package com.toyota.tmna.lexusdrivers.core.models.impl;

import java.util.Map;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.SearchPageContainer;
import com.toyota.tmna.lexusdrivers.core.util.ContainerUtil;
import org.jetbrains.annotations.NotNull;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { TilesContainerImpl.class,
		ComponentExporter.class }, resourceType = TilesContainerImpl.RESOURCETYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SearchPageContainerImpl extends ContainerUtil implements SearchPageContainer {
	
	protected static final String RESOURCETYPE = "lexusdrivers/components/structure/searchPageContainer";
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String title;
	@Override
	public String getTitle() {
		return title;
	}
	
}
