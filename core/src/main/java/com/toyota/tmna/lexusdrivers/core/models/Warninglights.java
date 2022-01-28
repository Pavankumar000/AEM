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
import org.apache.sling.api.resource.Resource;

/**
 * Defines the {@code Warninglights} Sling Model used for the {@code lexusdrivers/components/content/warninglights} component.
 * 
 */
@ConsumerType
public interface Warninglights
    extends ComponentExporter
{


    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getTitle();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getDisclaimer();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getScheduleServiceCTA();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getScheduleServiceLink();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getManualsCTA();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getManualsLink();

    Resource getwlDataSource();

}