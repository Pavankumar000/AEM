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
 * Defines the {@code Maintenanceschedule} Sling Model used for the {@code lexusdrivers/components/content/maintenanceschedule} component.
 * 
 */
@ConsumerType
public interface Maintenanceschedule
    extends ComponentExporter
{


    /**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */
    String getNoVehicleMessage();
    String getUnAuthInfo();
    String getAuthwithVIN();
    String getAuthWithoutVIN();

     /**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */

    String getModelYear();
    /**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */
    String getvehicleVIN();
    /**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */

    String getEngine();
    /**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */

    String getTransmission();
    String getDrive();
    String getCurrentMileage();
    String getNoInfo();
    String getReccomendMsg();
    String getDealerCTA();
    String getFindDealerCTA();
    String getFindDealerCTALink();

/**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */
    String getResultsTitle();
    String getSubTitle();
    String getRecommendText();
    String getPrintLabel();
    String getPrintIcon();
    String getCTALabel();
    String getCTALink();
    /**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */

    String getHeadingErrorMessage();
    String getSubHeadingErrorMessage();
    String getSpecialConditons();
    String getScheduleServiceCTALink();
    String getscheduleServiceCTA();



}
