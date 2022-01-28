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
 * Defines the {@code SearchPageView} Sling Model used for the {@code lexusdrivers/components/structure/searchpageview} component.
 * 
 */
@ConsumerType
public interface SearchPageView
    extends ComponentExporter
{


    /**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */
    String getTopsearch();
    String getPagination();
    String getSearchtip();
    String getNoresults();
    String getViewfewmodels();
    String getViewmoremodels();
    String getGallerytitle();
    String getSearchtipdescription();
    String getBaseurl();
    String getGeneralicon();
    String getPdficon();
    String getSearchurl();
    
    
    

}
