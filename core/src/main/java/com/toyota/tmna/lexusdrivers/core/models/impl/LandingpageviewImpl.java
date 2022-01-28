/*

 * ***********************************************************************

 * Lexus Drivers CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus Drivers.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus Drivers and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus Drivers

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus Drivers.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Landingpageview;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.toyota.tmna.lexusdrivers.core.util.ContainerUtil;
import org.jetbrains.annotations.NotNull;
import java.util.Map;


@Model(adaptables = { SlingHttpServletRequest.class}, adapters = {LandingpageviewImpl.class, ComponentExporter.class}, resourceType = "lexusdrivers/components/structure/LandingPageView")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@SuppressWarnings("CQRules:CQBP-84")
public class LandingpageviewImpl  extends  ContainerUtil   implements Landingpageview
{
 @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

    @SlingObject
    private Resource resource;

	@Override
	public String @NotNull [] getExportedItemsOrder() {
		return super.getExportedItemsOrder();
	}

	@Override
	public @NotNull Map<String, ? extends ComponentExporter> getExportedItems() {
		 return super.getExportedItems();
	}


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public @NotNull String getExportedType() {
        return resource.getResourceType();
    }


}
