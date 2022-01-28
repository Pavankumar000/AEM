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
import com.toyota.tmna.lexusdrivers.core.models.Vehiclesettingscommon;
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
    Vehiclesettingscommon.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/vehiclesettingscommon")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class VehiclesettingscommonImpl
    implements Vehiclesettingscommon
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String section;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String subSection;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String addVehicleLabel;

    

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String delelteMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String deletePrimaryLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String deleteSecondaryLabel;


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String confirmationMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String confirmationLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String setPrimaryLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String setPrimaryMsg;

      @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String addVehicleIcon;
      @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String noVehicleMsg;
      @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String activeSubscription;

 @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String inActiveSubscription;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleError;
       @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleSpecError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String cardType;

    @SlingObject
    private Resource resource;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getSection() {
        return section;
    }

    @Override
    public String getSubSection() {
        return subSection;
    }

    @Override
    public String getAddVehicleLabel() {
        return addVehicleLabel;
    }


    @Override
    public String getDelelteMsg() {
        return delelteMsg;
    }
    @Override
    public String getDeletePrimaryLabel() {
        return deletePrimaryLabel;
    }
    @Override
    public String getVehicleError() {
        return vehicleError;
    }
    @Override
    public String getVehicleSpecError() {
        return vehicleSpecError;
    }
    
	@Override
	public String getCardType() {
		return cardType;
	}
    @Override
    public String getDeleteSecondaryLabel() {
        return deleteSecondaryLabel;
    }

    @Override
    public String getConfirmationMsg() {
        return confirmationMsg;
    }
    @Override
    public String getConfirmationLabel() {
        return confirmationLabel;
    }
    @Override
    public String getSetPrimaryLabel() {
        return setPrimaryLabel;
    }
    @Override
    public String getSetPrimaryMsg() {
        return setPrimaryMsg;
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
    public String getNoVehicleMsg() {
        return noVehicleMsg;
    }
 @Override
    public String getAddVehicleIcon() {
        return addVehicleIcon;
    }

   

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
