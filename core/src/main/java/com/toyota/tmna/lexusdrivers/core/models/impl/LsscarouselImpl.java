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
import com.toyota.tmna.lexusdrivers.core.models.Lsscarousel;
import com.toyota.tmna.lexusdrivers.core.models.impl.VideoplayerImpl;
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
    Lsscarousel.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/lsscarousel")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class LsscarouselImpl extends VideoplayerImpl implements Lsscarousel
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String defaultMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noLssMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String description;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String heading;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleEquipped;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String novehicleEquipped;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleEquippedImg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String novehicleEquippedImg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subtitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String modalcta;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String hidevideo;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String garageMsg;   


    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource carouselslides;

     @Override
    public String getDescription() {
        return description;
    }



    @Override
    public String getHeading() {
        return heading;
    }

    @Override
    public String getVehicleEquipped() {
        return vehicleEquipped;
    }

    @Override
    public String getNovehicleEquipped() {
        return novehicleEquipped;
    }
    @Override
    public String getHidevideo() {
        return hidevideo;
    }

    @Override
    public String getVehicleEquippedImg() {
        return vehicleEquippedImg;
    }
    @Override
    public String getNovehicleEquippedImg() {
        return novehicleEquippedImg;
    }
    @Override
    public String getModalcta() {
        return modalcta;
    }
    @Override
    public String getSubtitle() {
        return subtitle;
    }

    @Override
    public String getNoLssMsg() {
        return noLssMsg;
    }

    @Override
    public String getGarageMsg() {
        return garageMsg;
    }

     @Override
    public String getDefaultMsg() {
        return defaultMsg;
    }


    @SlingObject
    private Resource resource;
    public Resource getCarouselslides() {
        return carouselslides;
    }

   @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource bannerList;

	public Resource getBannerList() {

		return bannerList;
	}

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource ctaList;

	public Resource getCtaList() {

		return ctaList;
	}

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource descList;

	public Resource getDescList() {

		return descList;
	}

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
