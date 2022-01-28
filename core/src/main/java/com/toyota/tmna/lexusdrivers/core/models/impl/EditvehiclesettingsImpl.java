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
import com.toyota.tmna.lexusdrivers.core.models.Editvehiclesettings;
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
    Editvehiclesettings.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/editvehiclesettings")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class EditvehiclesettingsImpl
    implements Editvehiclesettings
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String errMessageDesc;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String saveLabel;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String editIcon;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String trashIcon;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String removeIcon;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String removeLabel;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String cancelLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String manageLink;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String manageLinkLabel;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String nonEnrolledUserMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String enrolledUserMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String enformLabel;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String dealerDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String selectDealerLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String selectDealerLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String selectPreferredDealerLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String preferredDealerLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String sellerDealerLabel;


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String editLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleCTALink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleCTALabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String nicknameLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vinLabel;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String confirmLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String deleteVehicleMessage;


     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String inActiveSubscription;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String activeSubscription;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subscriptionMsg;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String redirectionLink;


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String preferredDealerError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String internalError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String saveAllMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String allVehicleSuccessMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String singleVehicleSuccessMsg;





    @SlingObject
    private Resource resource;

     @Override
    public String getRedirectionLink() {
        return redirectionLink;
    }
 
  @Override
    public String getSubscriptionMsg() {
        return subscriptionMsg;
    }
     @Override
    public String getInActiveSubscription() {
        return inActiveSubscription;
    }
     @Override
    public String getActiveSubscription() {
        return activeSubscription;
    }

    @Override
    public String getErrMessageDesc() {
        return errMessageDesc;
    }
    @Override
    public String getSaveLabel() {
        return saveLabel;
    }

     @Override
    public String getRemoveLabel() {
        return removeLabel;
    }
     @Override
    public String getRemoveIcon() {
        return removeIcon;
    }
     @Override
    public String getEditIcon() {
        return editIcon;
    }

     @Override
    public String getTrashIcon() {
        return trashIcon;
    }

     @Override
    public String getCancelLabel() {
        return cancelLabel;
    }
     @Override
    public String getManageLink() {
        return manageLink;
    }
     @Override
    public String getManageLinkLabel() {
        return manageLinkLabel;
    }


     @Override
    public String getNonEnrolledUserMsg() {
        return nonEnrolledUserMsg;
    }
     @Override
    public String getEnrolledUserMsg() {
        return enrolledUserMsg;
    }
     @Override
    public String getEnformLabel() {
        return enformLabel;
    }

     @Override
    public String getDealerDescription() {
        return dealerDescription;
    }
    @Override
    public String getSelectDealerLink() {
        return selectDealerLink;
    }


    @Override
    public String getSelectDealerLabel() {
        return selectDealerLabel;
    }
    @Override
    public String getSellerDealerLabel() {
        return sellerDealerLabel;
    }
    @Override
    public String getPreferredDealerLabel() {
        return preferredDealerLabel;
    }
    @Override
    public String getSelectPreferredDealerLabel() {
        return selectPreferredDealerLabel;
    }

     @Override
    public String getVehicleCTALabel() {
        return vehicleCTALabel;
    }
     @Override
    public String getVehicleCTALink() {
        return vehicleCTALink;
    }
     @Override
    public String getEditLabel() {
        return editLabel;
    }

    @Override
    public String getNicknameLabel() {
        return nicknameLabel;
    }
    @Override
    public String getVinLabel() {
        return vinLabel;
    }

    @Override
    public String getConfirmLabel() {
        return confirmLabel;
    }
    @Override
    public String getDeleteVehicleMessage() {
        return deleteVehicleMessage;
    }


    @Override
    public String getSingleVehicleSuccessMsg() {
        return singleVehicleSuccessMsg;
    }
     @Override
    public String getAllVehicleSuccessMsg() {
        return allVehicleSuccessMsg;
    }
     @Override
    public String getSaveAllMessage() {
        return saveAllMessage;
    }
     @Override
    public String getInternalError() {
        return internalError;
    }
     @Override
    public String getPreferredDealerError() {
        return preferredDealerError;
    }


    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
