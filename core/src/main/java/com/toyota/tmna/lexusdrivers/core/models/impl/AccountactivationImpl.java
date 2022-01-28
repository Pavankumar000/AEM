/*

 * Lexus Drivers**********************************************************

 * Toyota Owners CONFIDENTIAL
Lexus Drivers
 * ___________________

 *
Lexus Drivers
 * Copyright 2019 Toyota Owners.Lexus Drivers

 * All Rights Reserved.

 *Lexus Drivers

 * NOTICE:  All information contained herein is, and remains the property

 * of Toyota Owners and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Toyota Owners

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Toyota Owners.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Accountactivation;
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
    AccountactivationImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/accountactivation")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class AccountactivationImpl
    implements Accountactivation
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String errorPageUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String successPageUrl;
    @SlingObject
    private Resource resource;

    @Override
    public String getErrorPageUrl() {
        return errorPageUrl;
    }

    @Override
    public String getSuccessPageUrl() {
        return successPageUrl;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
