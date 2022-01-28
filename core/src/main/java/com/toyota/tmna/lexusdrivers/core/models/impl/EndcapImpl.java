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
import com.toyota.tmna.lexusdrivers.core.models.Endcap;
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
    Endcap.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/endcap")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class EndcapImpl
    implements Endcap
{

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String desktopimage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mobileimage;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mobileimagealt;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String desktopimagealt;
   


    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Resource icons;

    @SlingObject
    private Resource resource;

     @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDesktopimage() {
        return desktopimage;
    }

    @Override
    public String getMobileimage() {
        return mobileimage;
    }

    @Override
    public String getDesktopimagealt() {
        return desktopimagealt;
    }
    @Override
    public String getMobileimagealt() {
        return mobileimagealt;
    }



    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }


	public Resource getIcons() {
		return icons;
		
	}
}
