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
import com.toyota.tmna.lexusdrivers.core.models.Redemptionbar;
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
    Redemptionbar.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/redemptionbar")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class RedemptionbarImpl
    implements Redemptionbar
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String icon;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String logoutDesc;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String signInLabel;


     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String signinLink;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String claimDesc;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String claimLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String claimLink;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String contactInfo;



    @SlingObject
    private Resource resource;

    @Override
    public String getTitle() {
        return title;
    }


@Override
    public String getIcon() {
        return icon;
    }
    @Override
    public String getLogoutDesc() {
        return logoutDesc;
    }
    @Override
    public String getSignInLabel() {
        return signInLabel;
    }
    @Override
    public String getSignInLink() {
        return signinLink;
    }
    @Override
    public String getClaimDesc() {
        return claimDesc;
    }
    @Override
    public String getClaimLabel() {
        return claimLabel;
    }

 @Override
    public String getClaimLink() {
        return claimLink;
    }
     @Override
    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
