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

import java.util.List;

import com.toyota.tmna.lexusdrivers.core.util.CommonUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.day.cq.wcm.api.Page;
import com.toyota.tmna.lexusdrivers.core.models.Breadcrumb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    BreadcrumbImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/breadcrumb")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class BreadcrumbImpl
    implements Breadcrumb
{
    private static final Logger log = LoggerFactory.getLogger(BreadcrumbImpl.class);

    @ScriptVariable
    private Page currentPage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String headerRibbon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String headerRibbonLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String menuLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Boolean showSubCategories;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String startLevel;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Boolean hideCurrent;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Boolean showHiddenItems;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private List<String> items;
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource subcategories;

     @SlingObject
    private Resource resource;
    public Resource getSubcategories() {
        return subcategories;
    }

    @Override
    public String getStartLevel() {
        return startLevel;
    }

    @Override
    public Boolean getHideCurrent() {
        return hideCurrent;
    }
    @Override
    public Boolean getShowHiddenItems() {
        return showHiddenItems;
    }
    @Override
    public Boolean getShowSubCategories() {
        return showSubCategories;    }


    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

    @Override
    public String getHeaderRibbon() {
        return headerRibbon;
    }
    @Override
    public String getHeaderRibbonLink() {
        return headerRibbonLink;
    }
    @Override
    public String getMenuLabel() {
        return menuLabel;
    }

    @Override
    public List<String> getItems() {
        CommonUtil commonUtil = new CommonUtil();
        log.info("Retrieving data for following breadcrumbs", startLevel , currentPage, showHiddenItems);
        return commonUtil.getItems(startLevel, currentPage,  showHiddenItems);
    }
}

