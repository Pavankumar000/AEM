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
import com.toyota.tmna.lexusdrivers.core.models.Indicatorlightstile;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    IndicatorlightstileImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/indicatorlightstile")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class IndicatorlightstileImpl
    implements Indicatorlightstile
{
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String tiletitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String titleicon;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String iconerrormsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String erromsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String errorctalabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String errorctalink;
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Resource tilesList;
    @SlingObject
    private Resource resource;

    @Override
    public String getTiletitle() {
        return tiletitle;
    }
    
    @Override
    public String getTitleicon() {
        return titleicon;
    }

    @Override
	public String getIconerrormsg() {
        return iconerrormsg;
    }

    @Override
    public String getErromsg() {
        return erromsg;
    }

    @Override
    public String getErrorctalabel() {
        return errorctalabel;
    }

    @Override
    public String getErrorctalink() {
        return errorctalink;
    }

    public Resource getTilesList() {
		return tilesList;
		
	}

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }


}
