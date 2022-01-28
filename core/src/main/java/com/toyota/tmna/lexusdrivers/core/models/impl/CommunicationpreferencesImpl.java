/*

 * ***********************************************************************

 *  Lexus Drivers CONFIDENTIAL

 * ___________________

 *

 * Copyright 2021  Lexus Drivers.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus Drivers and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to  Lexus Drivers

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from  Lexus Drivers.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Communicationpreferences;
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
        CommunicationpreferencesImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/communicationpreferences")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CommunicationpreferencesImpl
    implements Communicationpreferences
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String description;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String primaryCTA;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String secondaryCTA;
        @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String cancelIcon;
        @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String editIcon;

      @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String emailLabel;
      @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String editEmailLabel;
      @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String emailInfo;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String unsubscribeTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String unsubscribeDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String privacyCta;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String privacyCtaLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceConnectTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceConnectSubTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceConnectDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceEmailTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceNotificationTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceDealerTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String editEmailCtaLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String confirmationMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String successMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String preferenceCta;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String modalText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String modalDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subscriptionError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String saveError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String breadCrumbHeading;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String unsubscribeOK;
    
    
    
    

    @SlingObject
    private Resource resource;
 

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getPrimaryCTA() {
        return primaryCTA;
    }

    @Override
    public String getSecondaryCTA() {
        return secondaryCTA;
    }
    @Override
    public String getEditIcon() {
        return editIcon;
    }
    @Override
    public String getCancelIcon() {
        return cancelIcon;
    }

     @Override
    public String getEmailLabel() {
        return emailLabel;
    }
     @Override
    public String getEditEmailLabel() {
        return editEmailLabel;
    }
     @Override
    public String getEmailInfo() {
        return emailInfo;
    }
@ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource links;

	public Resource getLinks() {

		return links;
	}


    @Override
    public String getServiceConnectTitle() {
        return serviceConnectTitle;
    }

    @Override
    public String getServiceConnectSubTitle() {
        return serviceConnectSubTitle;
    }

    @Override
    public  String getVehicleTitle() {
        return vehicleTitle;
    }

    @Override
    public  String getServiceConnectDescription() {
        return serviceConnectDescription;
    }
    @Override
    public  String getServiceEmailTitle() {
        return serviceEmailTitle;
    }
    @Override
    public  String getServiceNotificationTitle() {
        return serviceNotificationTitle;
    }
    @Override
    public  String getServiceDealerTitle() {
        return serviceDealerTitle;
    }
    @Override
    public  String getUnsubscribeTitle() {
        return unsubscribeTitle;
    }
    @Override
    public  String getUnsubscribeDescription() {
        return unsubscribeDescription;
    }
    @Override
    public  String getPrivacyCta() {
        return privacyCta;
    }
    @Override
    public  String getPrivacyCtaLink() {
        return privacyCtaLink;
    }

    @Override
    public String getEditEmailCtaLink() {
        return editEmailCtaLink;
    }

    @Override
    public String getConfirmationMessage() {
        return confirmationMessage;
    }
    @Override
    public String getSuccessMessage() {
        return successMessage;
    }
    @Override
    public String getModalText() {
        return modalText;
    }
    @Override
    public String getModalDescription() {
        return modalDescription;
    }
    @Override
    public String getSubscriptionError() {
        return subscriptionError;
    }
    @Override
    public String getSaveError() {
        return saveError;
    }
    @Override
    public String getPreferenceCta() {
        return preferenceCta;
    }
    @Override
    public String getBreadCrumbHeading(){
        return breadCrumbHeading;
    }
    @Override
    public String getUnsubscribeOk(){
        return unsubscribeOK;
    }




    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
