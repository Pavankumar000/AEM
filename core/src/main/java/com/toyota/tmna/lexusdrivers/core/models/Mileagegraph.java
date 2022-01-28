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
 * Defines the {@code Mileagegraph} Sling Model used for the {@code lexusdrivers/components/content/mileagegraph} component.
 * 
 */
@ConsumerType
public interface Mileagegraph
    extends ComponentExporter
{


    /**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */
    String getTitle();

     /**
     * Returns a error message field value.
     * 
     * @return String
     * 
     */

    String getErorMessage();

}
