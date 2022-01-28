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
 * Defines the {@code Panelfilter} Sling Model used for the {@code lexusdrivers/components/content/panelfilter} component.
 * 
 */
@ConsumerType
public interface Panelfilter
    extends ComponentExporter
{

 /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getTitle();
    
    String getSelectAllLabel();

    String getViewLabel();

    String getSelectedLabel();

    String getFilterType();

    String getInvalidError();

    String getNonUsaError();

    String getListIcon();

    String getSearchIcon();

    String getGridIcon();

    String getAllTypes();

    String getSearchPlaceholder();

    String getAllVideoTypes();

  

}
