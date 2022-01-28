/*

 * ***********************************************************************

 * Lexus CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;


/**
 * Defines the {@code Vehicleinfopanel} Sling Model used for the {@code lexusdrivers/components/content/vehicleinfopanel} component.
 * 
 */
@ConsumerType
public interface Vehicleinfopanel
    extends ComponentExporter
{


    /**
     * Returns title of the setion
     * 
     * @return String
     * 
     */
    String getJellytitle();

    /**
     * Returns a default jelly image
     * 
     * @return String
     * 
     */
    String getDefaultJelly();

    /**
     * Default Title of the Section 
     * 
     * @return String
     * 
     */
    String getDefaultTitle();

    /**
     * Get the defaultDescription.
     * 
     * @return String
     * 
     */
    String getDefaultDescription();

    /**
     * Get the vehicleLabel.
     * 
     * @return String
     * 
     */
    String getVehicleLabel();

    /**
     * Returns a label
     * 
     * @return String
     * 
     */
    String getVINLabel();

    /**
     * Returns a label
     * 
     * @return String
     * 
     */
    String getIMEILabel();
       /**
     * Returns a label
     * 
     * @return String
     * 
     */
    String getMEIDLabel();

    /**
     * Returns a Title
     * 
     * @return String
     * 
     */
    String getHasCapabilityTitle();

    /**
     * Returns a label
     * 
     * @return String
     * 
     */
    String getHasCapabilityDesc();

    /**
     * Returns a label
     * 
     * @return String
     * 
     */
    String getNoCapabilityTitle();

    /**
     * Returns a label
     * 
     * @return String
     * 
     */
    String getNoCapabilityDesc();

    /**
     * Returns a label
     * 
     * @return String
     * 
     */
    String getButtontext();

    /**
     * Returns link style
     * 
     * @return String
     * 
     */
    String getButtonlink();

}
