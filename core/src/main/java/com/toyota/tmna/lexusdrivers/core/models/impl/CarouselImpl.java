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

import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.toyota.tmna.lexusdrivers.core.models.Carousel;
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
		CarouselImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/carousel")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CarouselImpl
    implements Carousel
{
    
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String id;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Boolean autoScroll;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String type;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Long timebetweenslides;
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Resource carouselslides;
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String disclaimer;    
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource ctaMultiField;

    @SlingObject
    private Resource resource;
    @Override
    public String getId() {
        
    if (id == null) {
            id = String.valueOf(Math.abs(resource.getPath().hashCode() - 1));
    }
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSubTitle() {
        return subTitle;
    }

    @Override
    public Boolean getAutoScroll() {
        return autoScroll;
    }

    @Override
    @JsonProperty("selection")
    public String getType() {
        return type;
    }

    @Override
    public Long getTimebetweenslides() {
        return timebetweenslides;
    }
    @Override
    public String getDisclaimer() {
        return disclaimer;
    }
    
    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }    

	public Resource getCarouselslides() {
		return carouselslides;
		
	}
    
public Resource getCtaMultiField() {
		return ctaMultiField;
	}

}
