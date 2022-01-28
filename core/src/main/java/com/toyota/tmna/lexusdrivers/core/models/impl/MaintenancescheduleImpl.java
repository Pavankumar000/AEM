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
import com.toyota.tmna.lexusdrivers.core.models.Maintenanceschedule;
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
    Maintenanceschedule.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/maintenanceschedule")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class MaintenancescheduleImpl
    implements Maintenanceschedule
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noVehicleMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String unAuthInfo;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String authwithVIN;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String authWithoutVIN;


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String modelYear;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleVIN;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String engine;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String transmission;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String drive;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String currentMileage;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noInfo;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String reccomendMsg;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String dealerCTA;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String findDealerCTA;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String findDealerCTALink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String scheduleServiceCTALink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String scheduleServiceCTA;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String resultsTitle;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subTitle;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String recommendText;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String printLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String printIcon;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String ctaLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String ctaLink;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String headingErrorMessage;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subHeadingErrorMessage;
    
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String specialConditions;

    @SlingObject
    private Resource resource;

    @Override
    public String getNoVehicleMessage() {
        return noVehicleMessage;
    }
    @Override
    public String getUnAuthInfo() {
        return unAuthInfo;
    }
    @Override
    public String getAuthwithVIN() {
        return authwithVIN;
    }
    @Override
    public String getAuthWithoutVIN() {
        return authWithoutVIN;
    }

    @Override
    public String getModelYear() {
        return modelYear;
    }
    @Override
    public String getvehicleVIN() {
        return vehicleVIN;
    }
    @Override
    public String getEngine() {
        return engine;
    }

    

    @Override
    public String getTransmission() {
        return transmission;
    }
    @Override
    public String getDrive() {
        return drive;
    }
    @Override
    public String getCurrentMileage() {
        return currentMileage;
    }
    @Override
    public String getNoInfo() {
        return noInfo;
    }
    @Override
    public String getReccomendMsg() {
        return reccomendMsg;
    }
    @Override
    public String getDealerCTA() {
        return dealerCTA;
    }
    @Override
    public String getFindDealerCTA() {
        return findDealerCTA;
    }
    @Override
    public String getFindDealerCTALink() {
        return findDealerCTALink;
    }

    
    @Override
    public String getResultsTitle() {
        return resultsTitle;
    }
    @Override
    public String getSubTitle() {
        return subTitle;
    }
    @Override
    public String getRecommendText() {
        return recommendText;
    }
    @Override
    public String getPrintLabel() {
        return printLabel;
    }
    @Override
    public String getPrintIcon() {
        return printIcon;
    }
    @Override
    public String getCTALabel() {
        return ctaLabel;
    }
    @Override
    public String getCTALink() {
        return ctaLink;
    }


    @Override
    public String getHeadingErrorMessage() {
        return headingErrorMessage;
    }
    @Override
    public String getSubHeadingErrorMessage() {
        return subHeadingErrorMessage;
    }
    @Override
    public String getSpecialConditons() {
        return specialConditions;
    }

    @Override
    public String getScheduleServiceCTALink() {
        return scheduleServiceCTALink;
    }

    @Override
    public String getscheduleServiceCTA() {
        return scheduleServiceCTA;
    }


    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
