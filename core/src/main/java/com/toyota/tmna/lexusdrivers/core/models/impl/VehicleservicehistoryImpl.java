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
import com.toyota.tmna.lexusdrivers.core.models.Vehicleservicehistory;
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
    Vehicleservicehistory.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/vehicleservicehistory")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class VehicleservicehistoryImpl
    implements Vehicleservicehistory
{

    
    @SlingObject
    private Resource resource;

    
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String printIcon;
    
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String printLabel;
    
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String addServiceLink;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String addServiceLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String showLessLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String readMoreLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String descriptionLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String editLink;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String editLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String reportedByLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String repairLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String dateLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String milesLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String filterHistoryByYear;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vinLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceHistoryForLabel;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String displaytitle;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String errorTitleLabel;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String errorDescLabel;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String printLink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String termsTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String termsDescription;

    @Override
    public String getDisplaytitle() {
        return displaytitle;
    }
    @Override
    public String getFilterHistoryByYear() {
        return filterHistoryByYear;
    }

     @Override
    public String getVinLabel() {
        return vinLabel;
    }
    @Override
    public String getPrintIcon() {
        return printIcon;
    }

    @Override
    public String getPrintLabel() {
        return printLabel;
    }
    @Override
    public String getAddServiceLink() {
        return addServiceLink;
    }
    @Override
    public String getAddServiceLabel() {
        return addServiceLabel;
    }
    @Override
    public String getShowLessLabel() {
        return showLessLabel;
    }
    @Override
    public String getReadMoreLabel() {
        return readMoreLabel;
    }
    @Override
    public String getDescriptionLabel() {
        return descriptionLabel;
    }
    @Override
    public String getServiceLabel() {
        return serviceLabel;
    }
    @Override
    public String getEditLink() {
        return editLink;
    }
    @Override
    public String getEditLabel() {
        return editLabel;
    }
    @Override
    public String getReportedByLabel() {
        return reportedByLabel;
    }
    @Override
    public String getRepairLabel() {
        return repairLabel;
    }

    ///

    @Override
    public String getDateLabel() {
        return dateLabel;
    }
    @Override
    public String getMiles() {
        return milesLabel;
    }
     @Override
    public String getServiceHistoryForLabel() {
        return serviceHistoryForLabel;
    }
    @Override
    public String  getPrintLink() {
        return printLink;
    }

    @Override
    public String getErrorDescLabel() {
        return errorDescLabel;
    }

    @Override
    public String getErrorTitleLabel() {
        return errorTitleLabel;
    }

    @Override
    public String getTermsDescription() {
        return termsDescription;
    }

    @Override
    public String getTermsTitle() {
        return termsTitle;
    }
    //
    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
