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
import com.toyota.tmna.lexusdrivers.core.models.Genericmodal;
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
		GenericmodalImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/genericmodal")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class GenericmodalImpl
    implements Genericmodal
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String body;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String modaltype;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String modalbackground;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String size;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String footer;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String closeIcon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String className;
    @SlingObject
    private Resource resource;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getCloseIcon() {
        return closeIcon;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public String getFooter() {
        return footer;
    }

    @Override
    public String getModaltype() {
        return modaltype;
    }

    @Override
    public String getModalbackground() {
        return modalbackground;
    }

    @Override
    public String getSize() {
        return size;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

    @Override
    public String getClassName() {
        return className;
    }

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource ctaMultiField;
    @Override
	public Resource getCtaMultiField() {
		return ctaMultiField;
	}

}
