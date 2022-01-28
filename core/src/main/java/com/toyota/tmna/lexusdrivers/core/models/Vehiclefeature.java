/*

 * ***********************************************************************

 * Lexus drivers CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus drivers.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus drivers and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus drivers

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus drivers.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;


/**
 * Defines the {@code Vehiclefeature} Sling Model used for the {@code lexusdrivers/components/content/vehiclefeature} component.
 * 
 */
@ConsumerType
public interface Vehiclefeature
    extends ComponentExporter
{


    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getVehicleType();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

    String getDisplayDescription();

}
