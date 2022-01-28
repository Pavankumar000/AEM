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
 * Defines the {@code Vehiclesettingscommon} Sling Model used for the {@code lexusdrivers/components/content/vehiclesettingscommon} component.
 * 
 */
@ConsumerType
public interface Vehiclesettingscommon
    extends ComponentExporter
{


    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getTitle();

    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getSection();

    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getSubSection();

    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getAddVehicleLabel();
/**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */

    String getDelelteMsg();
    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getDeletePrimaryLabel();
    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getDeleteSecondaryLabel();
    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getConfirmationMsg();
    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getConfirmationLabel();
    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getSetPrimaryLabel();
    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getSetPrimaryMsg();
    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getInActiveSubscription();
    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getActiveSubscription();
    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getNoVehicleMsg();
    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getAddVehicleIcon();
    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */   
    String getVehicleError(); 

    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */   
    String getVehicleSpecError(); 
/**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */ 
    String getCardType();
}
