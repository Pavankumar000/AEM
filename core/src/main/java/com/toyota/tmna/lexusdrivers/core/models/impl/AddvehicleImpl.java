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
import com.toyota.tmna.lexusdrivers.core.models.Addvehicle;
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
    Addvehicle.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/addvehicle")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class AddvehicleImpl
    implements Addvehicle
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String title;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String addVehicleType;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleMaxLimit;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleError;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String selectYearLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String selectModelLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String addVehicleBtnLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String backBtnLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vinPrimaryBtnLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vinSecondaryBtnLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vinTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vinDescription;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vinImage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vinAltText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vinFieldLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vinCTALabel;
    
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String successMsg;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String successImage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String successImgAltText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String successBtnText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String anotherBtnText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String successTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleModelDesc;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vinText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String duplicateVehicleError;
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource vinValidations;
    @SlingObject
    private Resource resource;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAddVehicleType() {
        return addVehicleType;
    }

    @Override
    public String getVehicleMaxLimit() {
        return vehicleMaxLimit;
    }

    @Override
    public String getVehicleError() {
        return vehicleError;
    }

    @Override
    public String getSelectYearLabel() {
        return selectYearLabel;
    }

    @Override
    public String getSelectModelLabel() {
        return selectModelLabel;
    }

    @Override
    public String getAddVehicleBtnLabel() {
        return addVehicleBtnLabel;
    }

    @Override
    public String getBackBtnLabel() {
        return backBtnLabel;
    }

    @Override
    public String getVehicleDescription() {
        return vehicleDescription;
    }

    @Override
    public String getVinPrimaryBtnLabel() {
        return vinPrimaryBtnLabel;
    }

    @Override
    public String getVinSecondaryBtnLabel() {
        return vinSecondaryBtnLabel;
    }

    @Override
    public String getVinTitle() {
        return vinTitle;
    }

    @Override
    public String getVinDescription() {
        return vinDescription;
    }

    @Override
    public String getVinImage() {
        return vinImage;
    }

    @Override
    public String getVinAltText() {
        return vinAltText;
    }

    @Override
    public String getVinFieldLabel() {
        return vinFieldLabel;
    }
     @Override
    public String getVinCTALabel() {
        return vinCTALabel;
    }
    @Override
    public String getSuccessMsg() {
        return successMsg;
    }

    @Override
    public String getSuccessImage() {
        return successImage;
    }

    @Override
    public String getSuccessImgAltText() {
        return successImgAltText;
    }

    @Override
    public String getSuccessBtnText() {
        return successBtnText;
    }

    @Override
    public String getAnotherBtnText() {
        return anotherBtnText;
    }
    
    @Override
    public String getSuccessTitle() {
        return successTitle;
    }
     
    @Override
    public String getVehicleModelDesc() {
        return vehicleModelDesc;
    }
     @Override
    public String getVinText() {
        return vinText;
    }
    @Override
    public String getDuplicateVehicleError() {
        return duplicateVehicleError;
    }
    
    @Override
	public Resource getAddressValidations() {
		return vinValidations;
    }
    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }

}
