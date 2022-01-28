/*

 * ***********************************************************************

 * Lexusdriver CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexusdrivers.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexusdrivers and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexusdrivers

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexusdrivers.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Mypanel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    Mypanel.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/mypanel")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class MypanelImpl
    implements Mypanel
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String headerIcon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String description;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String ctaLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String ctaText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String order;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String myList;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String notApplicableMyList;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mypanelClassName;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String ctaClassName;

    @SlingObject
    private Resource resource;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getHeaderIcon() {
        return headerIcon;
    }

    @Override
    public String getMypanelClassName() {
        return mypanelClassName;
    }

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource ctaList;

	public Resource getCtaList() {
		return ctaList;
    }
    
    public String getMyList() {
		return myList;
    }

    public String getNotApplicableMyList() {
		return notApplicableMyList;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getCtaLink() {
        return ctaLink;
    }

    @Override
    public String getCtaText() {
        return ctaText;
    }

    @Override
    public String getOrder() {
        return order;
    }

     @Override
    public String getCtaClassName() {
        return ctaClassName;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
