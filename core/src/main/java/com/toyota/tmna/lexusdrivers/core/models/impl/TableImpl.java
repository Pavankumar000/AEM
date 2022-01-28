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
import com.toyota.tmna.lexusdrivers.core.models.Table;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
        TableImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/table")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class TableImpl
    implements Table
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String headerCSS;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String rowCSS;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String downLoadFullSpec;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String downloadIcon;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Boolean hideVehicleSpec;
    @SlingObject
    private Resource resource;

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Resource columnsList;


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getHeaderCSS() {
        return headerCSS;
    }

    @Override
    public String getRowCSS() {
        return rowCSS;
    }

    @Override
    public String getDownLoadFullSpec() {
        return downLoadFullSpec;
    }

    @Override
    public String getDownloadIcon() {
        return downloadIcon;
    }

    @Override
    public Boolean getHideVehicleSpec() {
        return hideVehicleSpec;
    }

    @Override
    public Resource getColumnsList() {
        return columnsList;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
