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
import com.toyota.tmna.lexusdrivers.core.models.Warninglights;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.inject.Inject;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
		WarninglightsImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/warninglights")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class WarninglightsImpl
    implements Warninglights
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String disclaimer;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String scheduleServiceCTA;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String scheduleServiceLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String manualsCTA;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String manualsLink;
    @SlingObject
    private Resource resource;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDisclaimer() {
        return disclaimer;
    }

    @Override
    public String getScheduleServiceCTA() {
        return scheduleServiceCTA;
    }

    @Override
    public String getScheduleServiceLink() {
        return scheduleServiceLink;
    }

    @Override
    public String getManualsCTA() {
        return manualsCTA;
    }

    @Override
    public String getManualsLink() {
        return manualsLink;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

    @Inject
    @Optional
	@Via("resource")
	private Resource wldataSource;
	
	public Resource getwlDataSource() {
		
		return wldataSource;
	}


}
