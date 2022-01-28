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
import com.toyota.tmna.lexusdrivers.core.models.Addvehicleservicehistory;
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
    Addvehicleservicehistory.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/addvehicleservicehistory")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class AddvehicleservicehistoryImpl
    implements Addvehicleservicehistory
{


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String repairOrderLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mileageLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceDate;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String eventLabel;

  
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String commentsLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceDesc;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCategory;


     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String saveLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String cancelLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String deleteEventLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String addAnotherServiceLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceIncLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String editHistoryDeleteModalTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String addHistoryDeleteModalTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String editHistoryCancelModalTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String addHistoryCancelModalTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String modalDescription;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String modalSecondaryLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String modalPrimaryLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  serviceProviderLabel;
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
    private Resource errorsList;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  deleteRecordError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  updateRecordError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  addRecordError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  serviceFailError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  serviceDescError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  serviceCategoryError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  mileageError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  providerNameError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  providerError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  dateError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  descIcon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  cancelDesc;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  modalIcon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  modalCancelTitle;
    @SlingObject
    private Resource resource;

    
    @Override
    public String getSaveLabel() {
        return saveLabel;
    }

    @Override
    public String getCancelLabel() {
        return cancelLabel;
    }
    @Override
    public String getDeleteEventLabel() {
        return deleteEventLabel;
    }

    @Override
    public String getAddAnotherServiceLabel() {
        return addAnotherServiceLabel;
    }
    @Override
    public String getServiceIncLabel() {
        return serviceIncLabel;
    }

    @Override
    public String getRepairOrderLabel() {
        return repairOrderLabel;
    }

    @Override
    public String getMileageLabel() {
        return mileageLabel;
    }
    @Override
    public String getServiceDate() {
        return serviceDate;
    }
    @Override
    public String getEventLabel() {
        return eventLabel;
    }

   

    @Override
    public String getCommentsLabel() {
        return commentsLabel;
    }
    @Override
    public String getServiceDesc() {
        return serviceDesc;
    }
    @Override
    public String getServiceCategory() {
        return serviceCategory;
    }

    @Override
    public String getEditHistoryDeleteModalTitle() {
        return editHistoryDeleteModalTitle;
    }
    @Override
    public String getEditHistoryCancelModalTitle() {
        return editHistoryCancelModalTitle;
    }
    @Override
    public String getAddHistoryDeleteModalTitle() {
        return addHistoryDeleteModalTitle;
    }
    @Override
    public String getAddHistoryCancelModalTitle() {
        return addHistoryCancelModalTitle;
    }

    @Override
    public String getCloseModalDescription() {
        return modalDescription;
    }

    @Override
    public String getModalPrimaryButton() {
        return modalPrimaryLabel;
    }

    @Override
    public String getModalSecondaryButton() {
        return modalSecondaryLabel;
    }
    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

    @Override
    public String getServiceProviderLabel() {
        return serviceProviderLabel;
    }
    public Resource getErrorsList() {
        return errorsList;
    }

    @Override
    public String getDateError() {
        return dateError;
    }
    @Override
    public String getProviderError() {
        return providerError;
    }
    @Override
    public String getProviderNameError() {
        return providerNameError;
    }
    @Override
    public String getMileageError() {
        return mileageError;
    }
    @Override
    public String getServiceCategoryError() {
        return serviceCategoryError;
    }
    @Override
    public String getServiceDescError() {
        return serviceDescError;
    }
    @Override
    public String getServiceFailError() {
        return serviceFailError;
    }
    @Override
    public String getAddRecordError() {
        return addRecordError;
    }
    @Override
    public String getUpdateRecordError() {
        return updateRecordError;
    }

    @Override
    public String getDeleteRecordError() {
        return deleteRecordError;
    }

    @Override
    public String getServiceLink() {
        return serviceLink;
    }

    @Override
    public String getDescIcon() {
        return descIcon;
    }
    @Override
    public String getModalIcon() {
        return modalIcon;
    }

    @Override
    public String getModalCancelDescription() {
        return cancelDesc;
    }

 
}
