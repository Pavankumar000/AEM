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
import com.toyota.tmna.lexusdrivers.core.models.Quicktips;
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
    QuicktipsImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/quicktips")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class QuicktipsImpl
    implements Quicktips
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String description;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String image;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String opacity;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String largeTileImage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mediumTileImage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String smallTileImage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String tileImageOpacity;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String videoUrl;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String videoId;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String primaryLinkText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String primaryLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String secondaryLinkText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String secondaryLink;
    @SlingObject
    private Resource resource;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSubTitle() {
        return subTitle;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getOpacity() {
        return opacity;
    }

    @Override
    public String getLargeTileImage() {
        return largeTileImage;
    }

    @Override
    public String getMediumTileImage() {
        return mediumTileImage;
    }

    @Override
    public String getSmallTileImage() {
        return smallTileImage;
    }

    @Override
    public String getTileImageOpacity() {
        return tileImageOpacity;
    }

    @Override
    public String getVideoUrl() {
        return videoUrl;
    }

    @Override
    public String getVideoId() {
        return videoId;
    }

    @Override
    public String getPrimaryLinkText() {
        return primaryLinkText;
    }

    @Override
    public String getPrimaryLink() {
        return primaryLink;
    }

    @Override
    public String getSecondaryLinkText() {
        return secondaryLinkText;
    }

    @Override
    public String getSecondaryLink() {
        return secondaryLink;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
