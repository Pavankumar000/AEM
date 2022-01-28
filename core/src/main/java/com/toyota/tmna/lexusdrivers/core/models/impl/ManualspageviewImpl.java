
package com.toyota.tmna.lexusdrivers.core.models.impl;
import java.util.Map;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Manualspageview;
import com.toyota.tmna.lexusdrivers.core.util.ContainerUtil;
import org.jetbrains.annotations.NotNull;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { ManualspageviewImpl.class,
		ComponentExporter.class }, resourceType = ManualspageviewImpl.RESOURCETYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ManualspageviewImpl extends ContainerUtil  implements Manualspageview {
	
	protected static final String RESOURCETYPE = "lexusdrivers/components/structure/ManualsPageView";
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String title;

	public String @NotNull [] getExportedItemsOrder() {
		return super.getExportedItemsOrder();
	}

	public @NotNull Map<String, ? extends ComponentExporter> getExportedItems() {
		 return super.getExportedItems();
	}

	public @NotNull String getExportedType() {
		return super.getExportedType();
	}

	@Override
	public String getTitle() {
		return title;
	}

}