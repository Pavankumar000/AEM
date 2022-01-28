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

import com.toyota.tmna.lexusdrivers.core.models.Editvehiclesettingsview;
import com.toyota.tmna.lexusdrivers.core.util.ContainerUtil;
import org.jetbrains.annotations.NotNull;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { Editvehiclesettingsview.class,
		ComponentExporter.class }, resourceType = VehiclesettingsImpl.RESOURCETYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class EditvehiclesettingsviewImpl extends ContainerUtil  implements Editvehiclesettingsview {
	
	protected static final String RESOURCETYPE = "lexusdrivers/components/structure/EditVehicleSettingsView";
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String title;

	@Override
	public String getTitle() {
		return title;
	}

	

}