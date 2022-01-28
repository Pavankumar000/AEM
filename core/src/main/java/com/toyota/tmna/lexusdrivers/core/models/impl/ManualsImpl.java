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
import com.toyota.tmna.lexusdrivers.core.models.Manuals;
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
        ManualsImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/manuals")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ManualsImpl extends TileComponentImpl
    implements Manuals
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String icon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String iconList;  
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String type;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String manualtype;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noServiceDataMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noVehicleSelectedMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String nextgenIconText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String warrantyPeriod;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String milesText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String warrantyMessage;
    @SlingObject
    private Resource resource;

    @Override
    public String getTitle() {
        return title;
    }
    @Override
    public String getnextgenIconText() {
        return nextgenIconText;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public String getIconList() {
        return iconList;
    }

    @Override
    public String getManualtype() {
        return manualtype;
    }

    @Override
    public String getNoVehicleSelectedMessage() {
        return noVehicleSelectedMessage;
    }

    @Override
    public String getNoServiceDataMessage() {
        return noServiceDataMessage;
    }

     @Override
    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

     @Override
    public String getMilesText() {
        return milesText;
    }

    @Override
    public String getwarrantyMessage() {
        return warrantyMessage;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
