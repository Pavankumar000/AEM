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
 * Defines the {@code Subnavigation} Sling Model used for the {@code lexusdrivers/components/content/subnavigation} component.
 * 
 */
@ConsumerType
public interface Subnavigation
    extends ComponentExporter
{


    /**
     * Returns a title field value.
     * 
     * @return String
     * 
     */
    String getModuleName();
     /**
     * Returns a title field value.
     * 
     * @return String
     * 
     */
    String getNextIcon();
     /**
     * Returns a title field value.
     * 
     * @return String
     * 
     */
    String getPrevIcon();
     /**
     * Returns a title field value.
     * 
     * @return String
     * 
     */
    String getMoreLabel();
     /**
     * Returns a title field value.
     * 
     * @return String
     * 
     */
    String getSubNavType();

    String getIsStickyNav();

    Boolean getShowActiveTab();

}
