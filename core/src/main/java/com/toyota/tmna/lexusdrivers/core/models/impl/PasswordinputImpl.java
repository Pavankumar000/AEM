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

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Passwordinput;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
		PasswordinputImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/passwordinput")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class PasswordinputImpl
    implements Passwordinput
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String confirmPasswordLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String confirmPasswordRequiredMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String confirmPasswordValidation;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String passwordLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String passwordRequiredMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String hideLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    public String showLabel;
    @SlingObject
    public Resource resource;

    @Override
    public String getConfirmPasswordLabel() {
        return confirmPasswordLabel;
    }

    @Override
    public String getConfirmPasswordRequiredMessage() {
        return confirmPasswordRequiredMessage;
    }

    @Override
    public String getConfirmPasswordValidation() {
        return confirmPasswordValidation;
    }

    @Override
    public String getPasswordLabel() {
        return passwordLabel;
    }

    @Override
    public String getPasswordRequiredMessage() {
        return passwordRequiredMessage;
    }

    @Override
    public String getHideLabel() {
        return hideLabel;
    }

    @Override
    public String getShowLabel() {
        return showLabel;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	public Resource passwordValidations;

	public Resource getPasswordValidations() {
		return passwordValidations;
	}
}
