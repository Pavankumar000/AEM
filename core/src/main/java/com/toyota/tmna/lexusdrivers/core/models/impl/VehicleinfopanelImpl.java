/*

 * ***********************************************************************

 * Lexus CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Vehicleinfopanel;
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
    Vehicleinfopanel.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/vehicleinfopanel")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class VehicleinfopanelImpl
    implements Vehicleinfopanel
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String jellytitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String defaultJelly;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String defaultTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String defaultDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String VINLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String IMEILabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String MEIDLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String hasCapabilityTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String hasCapabilityDesc;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noCapabilityTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noCapabilityDesc;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String buttontext;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String buttonlink;
    @SlingObject
    private Resource resource;

    @Override
    public String getJellytitle() {
        return jellytitle;
    }

    @Override
    public String getDefaultJelly() {
        return defaultJelly;
    }

    @Override
    public String getDefaultTitle() {
        return defaultTitle;
    }

    @Override
    public String getDefaultDescription() {
        return defaultDescription;
    }

    @Override
    public String getVehicleLabel() {
        return vehicleLabel;
    }

    @Override
    public String getVINLabel() {
        return VINLabel;
    }
     @Override
    public String getIMEILabel() {
        return IMEILabel;
    }
     @Override
    public String getMEIDLabel() {
        return MEIDLabel;
    }

    @Override
    public String getHasCapabilityTitle() {
        return hasCapabilityTitle;
    }

    @Override
    public String getHasCapabilityDesc() {
        return hasCapabilityDesc;
    }

    @Override
    public String getNoCapabilityTitle() {
        return noCapabilityTitle;
    }

    @Override
    public String getNoCapabilityDesc() {
        return noCapabilityDesc;
    }

    @Override
    public String getButtontext() {
        return buttontext;
    }

    @Override
    public String getButtonlink() {
        return buttonlink;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
