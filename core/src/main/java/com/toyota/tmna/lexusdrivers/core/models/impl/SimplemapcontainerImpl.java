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
import com.toyota.tmna.lexusdrivers.core.models.Simplemapcontainer;
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
    SimplemapcontainerImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/simplemapcontainer")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SimplemapcontainerImpl
    implements Simplemapcontainer
{

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String dealerTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String preferredText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String nearestText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String searchText;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String scheduleService;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String viewMore;
        
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String googleLanguage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String dealerwebsiteLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String serviceCenterLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String primaryLinkLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String primaryLinkURL;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String errorTitle;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String notFoundMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String dealerInfoNonUSA;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String hawaiiCTALabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String hawaiiCTAURL;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String puertoCTALabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String puertoCTAURL;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String searchIcon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String starIconFilled;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String starIcon;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mapMarkerIcon;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String selectedDealerIcon;


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String locationInfo;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String yourLocation;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String zipcodeLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String mapType;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String zipMarkerIcon;
    

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String dealerDetailsCTALabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String dealerDetailsCTALink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String findDifferentDealerLabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String findDifferentDealerCTALink;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleInventoryCTALink;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String vehicleInventoryLabel;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String popupTitle;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String description;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String coninueLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String continueLink;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  cancelLabel;


     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  eliteDealerTooltipText;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  eliteDealerTooltipDesc;
    
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  loadMoreLabel;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  eliteDealerTitle;


    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  yourPrefferedLexusDealerCTALabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  setPrefferedDealerCTALabel;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  setPrefferedDealerMessage;
    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  selectVehicleError;

     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  dealerInfoBoxMapIcon;
     @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String  yourDealerTitle;

    @SlingObject
    private Resource resource;

     @Override
    public String getYourPrefferedLexusDealerCTALabel() {
        return yourPrefferedLexusDealerCTALabel;
    }
     @Override
    public String getSetPrefferedDealerMessage() {
        return setPrefferedDealerMessage;
    }
     @Override
    public String getSetPrefferedDealerCTALabel() {
        return setPrefferedDealerCTALabel;
    }
     @Override
    public String getSelectVehicleError() {
        return selectVehicleError;
    }


    @Override
    public String getEliteDealerTitle() {
        return eliteDealerTitle;
    }
    @Override
    public String getLoadMoreLabel() {
        return loadMoreLabel;
    }
    
    @Override
    public String getEliteDealerTooltipDesc() {
        return eliteDealerTooltipDesc;
    }
    @Override
    public String getEliteDealerTooltipText() {
        return eliteDealerTooltipText;
    }

    @Override
    public String getDealerTitle() {
        return dealerTitle;
    }

    @Override
    public String getPreferredText() {
        return preferredText;
    }

    @Override
    public String getNearestText() {
        return nearestText;
    }

    @Override
    public String getSearchText() {
        return searchText;
    }

    @Override
    public String getScheduleService() {
        return scheduleService;
    }

    @Override
    public String getViewMore() {
        return viewMore;
    }

   

    @Override
    public String getGoogleLanguage() {
        return googleLanguage;
    }

    @Override
    public String getDealerwebsiteLabel() {
        return dealerwebsiteLabel;
    }

    @Override
    public String getServiceCenterLabel() {
        return serviceCenterLabel;
    }

    @Override
    public String getPrimaryLinkLabel() {
        return primaryLinkLabel;
    }

    @Override
    public String getPrimaryLinkURL() {
        return primaryLinkURL;
    }

    @Override
    public String getErrorTitle() {
        return errorTitle;
    }

     @Override
    public String getNotFoundMessage() {
        return notFoundMessage;
    }

    @Override
    public String getDealerInfoNonUSA() {
        return dealerInfoNonUSA;
    }

    @Override
    public String getHawaiiCTALabel() {
        return hawaiiCTALabel;
    }

    @Override
    public String getHawaiiCTAURL() {
        return hawaiiCTAURL;
    }

    @Override
    public String getPuertoCTALabel() {
        return puertoCTALabel;
    }

    @Override
    public String getPuertoCTAURL() {
        return puertoCTAURL;
    }

    @Override
    public String getSearchIcon() {
        return searchIcon;
    }
    @Override
    public String getStarIconFilled() {
        return starIconFilled;
    }
    @Override
    public String getStarIcon() {
        return starIcon;
    }
    @Override
    public String getMapMarkerIcon() {
        return mapMarkerIcon;
    }


     @Override
    public String getLocationInfo() {
        return locationInfo;
    }
     @Override
    public String getYourLocation() {
        return yourLocation;
    }
     @Override
    public String getZipcodeLabel() {
        return zipcodeLabel;
    }

     @Override
    public String getMapType() {
        return mapType;
    }

     @Override
    public String getZipMarkerIcon() {
        return zipMarkerIcon;
    }

    @Override
    public String getDealerDetailsCTALabel() {
        return dealerDetailsCTALabel;
    }
    @Override
    public String getDealerDetailsCTALink() {
        return dealerDetailsCTALink;
    }
    @Override
    public String getFindDifferentDealerLabel() {
        return findDifferentDealerLabel;
    }
    @Override
    public String getFindDifferentDealerCTALink() {
        return findDifferentDealerCTALink;
    }

     @Override
    public String getVehicleInventoryLabel() {
        return vehicleInventoryLabel;
    }
     @Override
    public String getVehicleInventoryCTALink() {
        return vehicleInventoryCTALink;
    }

   @Override
    public String getSelectedDealerIcon() {
        return selectedDealerIcon;
    }
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	public Resource zipCodeValidations;

	public Resource getZipCodeValidations() {
		return zipCodeValidations;
    }


     @Override
    public String getPopupTitle() {
        return popupTitle;
    }
     @Override
    public String getDescription() {
        return description;
    }
     @Override
    public String getConinueLabel() {
        return coninueLabel;
    }
     @Override
    public String getContinueLink() {
        return continueLink;
    }
     @Override
    public String getCancelLabel() {
        return cancelLabel;
    }

    @Override
    public String getDealerInfoBoxMapIcon() {
        return dealerInfoBoxMapIcon;
    }
    @Override
    public String getYourDealerTitle() {
        return yourDealerTitle;
    }

    @Override
    public String getExportedType() {
        return resource.getResourceType();
    }
    
     
}
