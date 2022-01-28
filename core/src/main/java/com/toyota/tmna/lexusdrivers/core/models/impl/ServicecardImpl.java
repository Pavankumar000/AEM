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
import com.toyota.tmna.lexusdrivers.core.models.Servicecard;
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
    ServicecardImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/servicecard")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ServicecardImpl
    implements Servicecard
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCardTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCardDateLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCardType;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String linkType;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCardIcon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCardAltText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCardMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCardDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCardImg;
    @SlingObject
    private Resource resource;

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Resource links;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCardCTALabel;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCardURL;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vhrLabel;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String alertsLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String border;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noVin;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noMileage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noRecords;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCardClassName;

    
    @Override
    public String getServiceCardTitle() {
        return serviceCardTitle;
    }

    @Override
    public String getServiceCardDateLabel() {
        return serviceCardDateLabel;
    }

    @Override
    public String getVhrLabel() {
        return vhrLabel;
    }

    @Override
    public String getAlertsLabel() {
        return alertsLabel;
    }
    @Override
    public String getBorder() {
        return border;
    }

    @Override
    public String getNoRecords(){
        return noRecords;
    }
    @Override
    public String getNoVin(){
        return noVin;
    }
    @Override
    public String getNoMileage(){
        return noMileage;
    }

    @Override
    public String getServiceCardType() {
        return serviceCardType;
    }

    
    @Override
    public String getLinkType() {
        return linkType;
    }

    @Override
    public String getServiceCardIcon() {
        return serviceCardIcon;
    }

    @Override
    public String getServiceCardImg() {
        return serviceCardImg;
    }

    @Override
    public String getServiceCardAltText() {
        return serviceCardAltText;
    }

    @Override
    public String getServiceCardMessage() {
        return serviceCardMessage;
    }

    @Override
    public String getServiceCardDescription() {
        return serviceCardDescription;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

    @Override
    public Resource getLinks() {
        return links;
    }

    @Override
    public String getServiceCardCTALabel() {
        return serviceCardCTALabel;
    }

    @Override
    public String getServiceCardURL() {
        return serviceCardURL;
    }

    @Override
    public String getServiceCardClassName() {
        return serviceCardClassName;
    }

    }
