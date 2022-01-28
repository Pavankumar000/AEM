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


package com.toyota.tmna.lexusdrivers.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;


/**
 * Defines the {@code Simplemapcontainer} Sling Model used for the {@code lexusdrivers/components/content/simplemapcontainer} component.
 * 
 */
@ConsumerType
public interface Simplemapcontainer
    extends ComponentExporter
{


    /**
     * Returns a text value tooltip used in the component
     * 
     * @return String
     * 
     */
    String getDealerTitle();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getPreferredText();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

     String getYourDealerTitle();
     /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getNearestText();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getSearchText();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getScheduleService();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getViewMore();

    
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getGoogleLanguage();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getDealerwebsiteLabel();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getServiceCenterLabel();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getPrimaryLinkLabel();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getPrimaryLinkURL();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getErrorTitle();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getDealerInfoNonUSA();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getHawaiiCTALabel();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getHawaiiCTAURL();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getPuertoCTALabel();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getPuertoCTAURL();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getSearchIcon();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getStarIconFilled();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getStarIcon();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getMapMarkerIcon();    

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getDealerInfoBoxMapIcon();

 /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getNotFoundMessage();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */

    String getMapType();
    
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getZipcodeLabel();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getYourLocation();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getLocationInfo();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */

    String getZipMarkerIcon();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */

    String getDealerDetailsCTALabel();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getDealerDetailsCTALink();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getFindDifferentDealerLabel();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
   String getFindDifferentDealerCTALink();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getSelectedDealerIcon();

    String getVehicleInventoryLabel();

    String getVehicleInventoryCTALink();

    String getPopupTitle();
    String getDescription();
    String getConinueLabel();
    String getContinueLink();
    String getCancelLabel();

     String getEliteDealerTitle();
     String getLoadMoreLabel();
    
     String getEliteDealerTooltipDesc();
     String getEliteDealerTooltipText();

     String getYourPrefferedLexusDealerCTALabel();
     String getSetPrefferedDealerMessage();
     String getSetPrefferedDealerCTALabel();
     String getSelectVehicleError();

}
