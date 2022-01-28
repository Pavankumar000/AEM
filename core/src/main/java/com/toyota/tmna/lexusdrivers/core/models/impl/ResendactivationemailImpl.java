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
import com.toyota.tmna.lexusdrivers.core.models.Resendactivationemail;
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
    ResendactivationemailImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/resendactivationemail")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ResendactivationemailImpl
    implements Resendactivationemail
{

    // @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    // private String title;
    // @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    // private String description;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String sendEmailLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String needMoreHelp;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String successPage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String emailField;
    @SlingObject
    private Resource resource;

    // @Override
    // public String getTitle() {
    //     return title;
    // }

    // @Override
    // public String getDescription() {
    //     return description;
    // }
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource rules;

	public Resource getRules() {
		return rules;
	}
    @Override
    public String getSendEmailLabel() {
        return sendEmailLabel;
    }

    @Override
    public String getNeedMoreHelp() {
        return needMoreHelp;
    }

    @Override
    public String getSuccessPage() {
        return successPage;
    }

    @Override
    public String getEmailField() {
        return emailField;
    }

    

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
