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
import com.toyota.tmna.lexusdrivers.core.models.Herovideobanner;
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
		HerovideobannerImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/herovideobanner")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class HerovideobannerImpl
    implements Herovideobanner
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String videoSource;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String videoSourceAlt;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String imageSource;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String imageSourceAlt;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String id;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String desktopImage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String desktopImageAlt;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mobileImage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mobileImageAlt;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String tabletImage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String tabletImageAlt;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String legalCopy;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String nickNameText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vINText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String viewSpecsLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String viewSpecsText;
    @SlingObject
    private Resource resource;

    @Override
    public String getVideoSource() {
        return videoSource;
    }

    @Override
    public String getVideoSourceAlt() {
        return videoSourceAlt;
    }

    @Override
    public String getImageSource() {
        return imageSource;
    }

    @Override
    public String getImageSourceAlt() {
        return imageSourceAlt;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getDesktopImage() {
        return desktopImage;
    }

    @Override
    public String getDesktopImageAlt() {
        return desktopImageAlt;
    }

    @Override
    public String getMobileImage() {
        return mobileImage;
    }

    @Override
    public String getMobileImageAlt() {
        return mobileImageAlt;
    }

    @Override
    public String getTabletImage() {
        return tabletImage;
    }

    @Override
    public String getTabletImageAlt() {
        return tabletImageAlt;
    }

    @Override
    public String getLegalCopy() {
        return legalCopy;
    }

    @Override
    public String getNickNameText() {
        return nickNameText;
    }

    @Override
    public String getVINText() {
        return vINText;
    }

    @Override
    public String getViewSpecsLink() {
        return viewSpecsLink;
    }

    @Override
    public String getViewSpecsText() {
        return viewSpecsText;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
