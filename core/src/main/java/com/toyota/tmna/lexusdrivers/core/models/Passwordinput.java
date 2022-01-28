/*

 * Lexus Drivers**********************************************************

 * Toyota Owners CONFIDENTIAL
Lexus Drivers
 * ___________________

 *
Lexus Drivers
 * Copyright 2019 Toyota Owners.Lexus Drivers

 * All Rights Reserved.

 *Lexus Drivers

 * NOTICE:  All information contained herein is, and remains the property

 * of Toyota Owners and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Toyota Owners

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Toyota Owners.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;


/**
 * Defines the {@code Passwordinput} Sling Model used for the {@code lexusdrivers/components/content/passwordinput} component.
 * 
 */
@ConsumerType
public interface Passwordinput
    extends ComponentExporter
{


    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getConfirmPasswordLabel();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getConfirmPasswordRequiredMessage();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getConfirmPasswordValidation();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getPasswordLabel();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getPasswordRequiredMessage();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getHideLabel();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getShowLabel();

}
