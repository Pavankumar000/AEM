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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class SimplemapcontainerImplTest {


  private final AemContext context = new AemContext();
	@Mock
	private ModelFactory modelFactory;
	private SimplemapcontainerImpl simplemapcontainerImpl;

	@BeforeEach
	void setUp() {
		context.addModelsForClasses(SimplemapcontainerImpl.class);
		context.load().json("/com/toyota/tmna/lexusdrivers/core/models/SimplemapcontainerImplTest.json", "/content");
		context.registerService(ModelFactory.class, modelFactory, org.osgi.framework.Constants.SERVICE_RANKING,
				Integer.MAX_VALUE);
		context.currentResource("/content");
		simplemapcontainerImpl = context.request().adaptTo(SimplemapcontainerImpl.class);
	}

    @Test
    void getDealerTitle() {
    String expected = "dealerTitle";
		String actual = simplemapcontainerImpl.getDealerTitle();
		assertEquals(expected, actual);
    }

    @Test
    void getPreferredText() {
    String expected = "preferredText";
		String actual = simplemapcontainerImpl.getPreferredText();
		assertEquals(expected, actual);
    }

    @Test
    void getNearestText() {
    String expected = "nearestText";
		String actual = simplemapcontainerImpl.getNearestText();
		assertEquals(expected, actual);
    }

    @Test
    void getSearchText() {
    String expected = "searchText";
		String actual = simplemapcontainerImpl.getSearchText();
		assertEquals(expected, actual);
    }

    @Test
    void getScheduleService() {
    String expected = "scheduleService";
		String actual = simplemapcontainerImpl.getScheduleService();
		assertEquals(expected, actual);
    }

    @Test
    void getViewMore() {
      String expected = "viewMore";
		String actual = simplemapcontainerImpl.getViewMore();
		assertEquals(expected, actual);
    }

   

    @Test
    void getGoogleLanguage() {
    String expected = "googleLanguage";
		String actual = simplemapcontainerImpl.getGoogleLanguage();
		assertEquals(expected, actual);
    }

    @Test
    void getDealerwebsiteLabel() {
    String expected = "dealerwebsiteLabel";
		String actual = simplemapcontainerImpl.getDealerwebsiteLabel();
		assertEquals(expected, actual);
    }

    @Test
    void getServiceCenterLabel() {
    String expected = "serviceCenterLabel";
		String actual = simplemapcontainerImpl.getServiceCenterLabel();
		assertEquals(expected, actual);
    }

    @Test
    void getPrimaryLinkLabel() {
    String expected = "primaryLinkLabel";
		String actual = simplemapcontainerImpl.getPrimaryLinkLabel();
		assertEquals(expected, actual);
    }

    @Test
    void getPrimaryLinkURL() {
    String expected = "primaryLinkURL";
		String actual = simplemapcontainerImpl.getPrimaryLinkURL();
		assertEquals(expected, actual);
    }

    @Test
    void getErrorTitle() {
    String expected = "errorTitle";
		String actual = simplemapcontainerImpl.getErrorTitle();
		assertEquals(expected, actual);
    }

    

    @Test
    void getHawaiiCTALabel() {
    String expected = "hawaiiCTALabel";
		String actual = simplemapcontainerImpl.getHawaiiCTALabel();
		assertEquals(expected, actual);
    }

    @Test
    void getHawaiiCTAURL() {
    String expected = "hawaiiCTAURL";
		String actual = simplemapcontainerImpl.getHawaiiCTAURL();
		assertEquals(expected, actual);
    }

    @Test
    void getPuertoCTALabel() {
      String expected = "puertoCTALabel";
		String actual = simplemapcontainerImpl.getPuertoCTALabel();
		assertEquals(expected, actual);
    }

    @Test
    void getPuertoCTAURL() {
      String expected = "puertoCTAURL";
		String actual = simplemapcontainerImpl.getPuertoCTAURL();
		assertEquals(expected, actual);
    }

    @Test
    void getDealerInfoNonUSA() {
        String expected = "dealerInfoNonUSA";
        String actual = simplemapcontainerImpl.getDealerInfoNonUSA();
        assertEquals(expected, actual);
    }

    @Test
    void getSearchIcon() {
        String expected = "searchIcon";
        String actual = simplemapcontainerImpl.getSearchIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getStarIconFilled() {
        String expected = "starIconFilled";
        String actual = simplemapcontainerImpl.getStarIconFilled();
        assertEquals(expected, actual);
    }

    @Test
    void getStarIcon() {
        String expected = "starIcon";
        String actual = simplemapcontainerImpl.getStarIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getMapMarkerIcon() {
        String expected = "mapMarkerIcon";
        String actual = simplemapcontainerImpl.getMapMarkerIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getNotFoundMessage() {
        String expected = "notFoundMessage";
        String actual = simplemapcontainerImpl.getNotFoundMessage();
        assertEquals(expected, actual);
    }
    
    @Test
    void getSelectedDealerIcon() {
        String expected = "selectedDealerIcon";
        String actual = simplemapcontainerImpl.getSelectedDealerIcon();
        assertEquals(expected, actual);
    }

    @Test
    void getLocationInfo() {
        String expected = "locationInfo";
        String actual = simplemapcontainerImpl.getLocationInfo();
        assertEquals(expected, actual);
    }

    @Test
    void getYourLocation() {
        String expected = "yourLocation";
        String actual = simplemapcontainerImpl.getYourLocation();
        assertEquals(expected, actual);
    }

    @Test
    void getZipcodeLabel() {
        String expected = "zipcodeLabel";
        String actual = simplemapcontainerImpl.getZipcodeLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getmapType() {
        String expected = "mapType";
        String actual = simplemapcontainerImpl.getMapType();
        assertEquals(expected, actual);
    }

    @Test
    void getZipMarkerIcon() {
        String expected = "zipMarkerIcon";
        String actual = simplemapcontainerImpl.getZipMarkerIcon();
        assertEquals(expected, actual);
    }
    
    @Test
    void getDealerDetailsCTALabel() {
        String expected = "dealerDetailsCTALabel";
        String actual = simplemapcontainerImpl.getDealerDetailsCTALabel();
        assertEquals(expected, actual);
    }

    @Test
    void getDealerDetailsCTALink() {
        String expected = "dealerDetailsCTALink";
        String actual = simplemapcontainerImpl.getDealerDetailsCTALink();
        assertEquals(expected, actual);
    }
    
    @Test
    void getfindDifferentDealerLabel() {
        String expected = "findDifferentDealerLabel";
        String actual = simplemapcontainerImpl.getFindDifferentDealerLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getFindDifferentDealerCTALink() {
        String expected = "findDifferentDealerCTALink";
        String actual = simplemapcontainerImpl.getFindDifferentDealerCTALink();
        assertEquals(expected, actual);
    }    
    
    @Test
    void getVehicleInventoryCTALink() {
        String expected = "vehicleInventoryCTALink";
        String actual = simplemapcontainerImpl.getVehicleInventoryCTALink();
        assertEquals(expected, actual);
    }

    @Test
    void getVehicleInventoryLabel() {
        String expected = "vehicleInventoryLabel";
        String actual = simplemapcontainerImpl.getVehicleInventoryLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getPopupTitle() {
        String expected = "popupTitle";
        String actual = simplemapcontainerImpl.getPopupTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getDescription() {
        String expected = "description";
        String actual = simplemapcontainerImpl.getDescription();
        assertEquals(expected, actual);
    }

    
    
    
    @Test
    void getConinueLabel() {
        String expected = "coninueLabel";
        String actual = simplemapcontainerImpl.getConinueLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getContinueLink() {
        String expected = "continueLink";
        String actual = simplemapcontainerImpl.getContinueLink();
        assertEquals(expected, actual);
    }
    
    @Test
    void getCancelLabel() {
        String expected = "cancelLabel";
        String actual = simplemapcontainerImpl.getCancelLabel();
        assertEquals(expected, actual);
    }

    @Test
    void getEliteDealerTooltipText() {
        String expected = "eliteDealerTooltipText";
        String actual = simplemapcontainerImpl.getEliteDealerTooltipText();
        assertEquals(expected, actual);
    }
    
    @Test
    void getEliteDealerTooltipDesc() {
        String expected = "eliteDealerTooltipDesc";
        String actual = simplemapcontainerImpl.getEliteDealerTooltipDesc();
        assertEquals(expected, actual);
    }
    
    @Test
    void getLoadMoreLabel() {
        String expected = "loadMoreLabel";
        String actual = simplemapcontainerImpl.getLoadMoreLabel();
        assertEquals(expected, actual);
    }
    
    @Test
    void getEliteDealerTitle() {
        String expected = "eliteDealerTitle";
        String actual = simplemapcontainerImpl.getEliteDealerTitle();
        assertEquals(expected, actual);
    }

    @Test
    void getExportedType() {
        String object = simplemapcontainerImpl.getExportedType();
        assertNotNull(object);
    }


    @Test
    void getZipCodeValidations() {
        Resource expected = context.resourceResolver().getResource("/content/zipCodeValidations");
        simplemapcontainerImpl = context.request().adaptTo(SimplemapcontainerImpl.class);
        assert simplemapcontainerImpl != null;
        Resource actual = simplemapcontainerImpl.getZipCodeValidations();
        assertNotNull(actual);
    }

    @Test
    void getSelectVehicleError() {
        String expected = "selectVehicleError";
        String actual = simplemapcontainerImpl.getSelectVehicleError();
        assertEquals(expected, actual);
    }

    @Test
    void getSetPrefferedDealerCTALabel() {
        String expected = "setPrefferedDealerCTALabel";
        String actual = simplemapcontainerImpl.getSetPrefferedDealerCTALabel();
        assertEquals(expected, actual);
    }

    @Test
    void getSetPrefferedDealerMessage() {
        String expected = "setPrefferedDealerMessage";
        String actual = simplemapcontainerImpl.getSetPrefferedDealerMessage();
        assertEquals(expected, actual);
    }

    @Test
    void getYourPrefferedLexusDealerCTALabel() {
        String expected = "yourPrefferedLexusDealerCTALabel";
        String actual = simplemapcontainerImpl.getYourPrefferedLexusDealerCTALabel();
        assertEquals(expected, actual);
    }

    @Test
    void getDealerInfoBoxMapIcon() {
        String expected = "dealerInfoBoxMapIcon";
        String actual = simplemapcontainerImpl.getDealerInfoBoxMapIcon();
        assertEquals(expected, actual);
    }
    @Test
    void getYourDealerTitle() {
        String expected = "yourDealerTitle";
        String actual = simplemapcontainerImpl.getYourDealerTitle();
        assertEquals(expected, actual);
    }



}
