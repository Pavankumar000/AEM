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
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Subnavigation;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.api.resource.Resource;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
        SubnavigationImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/subnavigation")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SubnavigationImpl
    implements Subnavigation
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String moduleName;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Boolean showActiveTab;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String nextIcon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String prevIcon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String moreLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subNavType;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String isStickyNav;


    @SlingObject
    private Resource resource;

    @Override
    public String getModuleName() {
        return moduleName;
    }

    @Override
    public Boolean getShowActiveTab() {
        return showActiveTab;
    }
   
    @Override
    public String getNextIcon() {
        return nextIcon;
    }

     @Override
    public String getPrevIcon() {
        return prevIcon;
    }
     @Override
    public String getMoreLabel() {
        return moreLabel;
    }
     @Override
    public String getSubNavType() {
        return subNavType;
    }

     @Override
    public String getIsStickyNav() {
        return isStickyNav;
    }


    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource navlinks;

	public Resource getnavlinks() {

		return navlinks;
	}

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
