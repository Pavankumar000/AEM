

package com.toyota.tmna.lexusdrivers.core.models.impl;

import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Vehiclesettings;
import com.toyota.tmna.lexusdrivers.core.util.ContainerUtil;
import org.jetbrains.annotations.NotNull;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { VehiclesettingsImpl.class,
		ComponentExporter.class }, resourceType = VehiclesettingsImpl.RESOURCETYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class VehiclesettingsImpl extends ContainerUtil  implements Vehiclesettings {
	
	protected static final String RESOURCETYPE = "lexusdrivers/components/structure/VehicleSettings";
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String section;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
     private String subSection;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
     private String addVehicleLabel;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
   public String getSection() {
        return section;
    }

     @Override
     public String getSubSection() {
         return subSection;
     }

     @Override
     public String getAddVehicleLabel() {
         return addVehicleLabel;
     }

}