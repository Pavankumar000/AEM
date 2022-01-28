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

import java.util.List;

/**
 * Defines the {@code Breadcrumb} Sling Model used for the {@code lexusdrivers/components/content/breadcrumb} component.
 * 
 */
@ConsumerType
public interface Breadcrumb
    extends ComponentExporter
{


    
    /**
     * Returns a headerRibbon title item field value.
     * 
     * @return String
     * 
     */
    String getHeaderRibbon();

    /**
 * Returns a headerRibbon Link field value.
 *
 * @return String
 *
 */

    String getHeaderRibbonLink();

    /**
     * Returns a menuLabel field value.
     *
     * @return String
     *
     */
    Boolean getShowSubCategories();
    String getMenuLabel();

    Boolean getHideCurrent();

    String getStartLevel();

    Boolean getShowHiddenItems();

    List<String> getItems();

}
