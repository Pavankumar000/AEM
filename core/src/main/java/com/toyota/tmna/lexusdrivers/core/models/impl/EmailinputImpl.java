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
import com.toyota.tmna.lexusdrivers.core.models.Emailinput;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.inject.Inject;

import org.apache.sling.models.annotations.Via;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
		EmailinputImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/emailinput")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class EmailinputImpl
    implements Emailinput
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String emailLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String emailUsedErrorMessage;
    @SlingObject
    private Resource resource;

    @Override
    public String getEmailLabel() {
        return emailLabel;
    }

    @Override
    public String getEmailUsedErrorMessage() {
        return emailUsedErrorMessage;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	public Resource emailValidations;

	public Resource getEmailValidations() {
		return emailValidations;
	}

}
