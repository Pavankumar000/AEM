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
import com.day.cq.wcm.api.Page;
import com.toyota.tmna.lexusdrivers.core.models.Breadcrumb;
import com.toyota.tmna.lexusdrivers.core.models.Herobannervideo;
import com.toyota.tmna.lexusdrivers.core.models.Videoplayer;
import com.toyota.tmna.lexusdrivers.core.util.CommonUtil;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
        HerobannervideoImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/herobannervideo")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HerobannervideoImpl
    implements Herobannervideo, Videoplayer
{
    private static final Logger log = LoggerFactory.getLogger(HerobannervideoImpl.class);

    @ScriptVariable
    private Page currentPage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String videoDesc;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String id;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String video_type;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String video_title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Boolean showInitialContent;
    @SlingObject
    private Resource resource;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getVideo_type() {
        return video_type;
    }

    @Override
    public String getVideo_title() {
        return video_title;
    }

    @Override
    public String getSubTitle() {
        return subTitle;
    }

    @Override
    public String getVideoDesc() {
        return videoDesc;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

    @Override
    public Boolean getShowInitialContent() {
        return showInitialContent;
    }

}
