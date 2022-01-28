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
import com.toyota.tmna.lexusdrivers.core.models.Networkretirement;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    Networkretirement.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/networkretirement")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class NetworkretirementImpl
    implements Networkretirement
{
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  vehicleType;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;

      @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String ctaLink;
      @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String ctaLabel;
      @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String displayDescription;

    @SlingObject
    private Resource resource;

    @Override
    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDisplayDescription() {
        return displayDescription;
    }
    @Override
    public String getCtaLabel() {
        return ctaLabel;
    }
    @Override
    public String getCtaLink() {
        return ctaLink;
    }


    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
