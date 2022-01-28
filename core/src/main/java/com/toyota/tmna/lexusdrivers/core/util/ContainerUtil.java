package com.toyota.tmna.lexusdrivers.core.util;

import com.adobe.cq.export.json.ComponentExporter;
import com.day.cq.wcm.foundation.model.responsivegrid.ResponsiveGrid;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@SuppressWarnings({"CQRules:CQBP-84", "CQRules:CQBP-84-dependencies"})
public class ContainerUtil extends ResponsiveGrid {

    @SlingObject
    private volatile Resource resource;

    @Override
    public String @NotNull [] getExportedItemsOrder() {
        return super.getExportedItemsOrder();
    }

    @Override
    public @NotNull Map<String, ? extends ComponentExporter> getExportedItems() {
        return super.getExportedItems();
    }
    @Override
    public @NotNull String getExportedType() {
        return resource.getResourceType();
    }

}
