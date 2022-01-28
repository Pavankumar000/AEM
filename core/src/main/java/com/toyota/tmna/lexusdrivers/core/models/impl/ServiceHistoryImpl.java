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
import com.toyota.tmna.lexusdrivers.core.models.ServiceHistory;
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
        ServiceHistoryImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/servicehistory")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ServiceHistoryImpl extends TileComponentImpl
    implements ServiceHistory
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String milage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String servicingDealer;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String service;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String description;
    @SlingObject
    private Resource resource;

    @Override
    public String getMilage() {
        return milage;
    }

    @Override
    public String getServicingDealer() {
        return servicingDealer;
    }

    @Override
    public String getService() {
        return service;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}