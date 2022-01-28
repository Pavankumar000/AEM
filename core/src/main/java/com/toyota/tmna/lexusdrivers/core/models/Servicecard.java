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
import org.apache.sling.api.resource.Resource;
import org.osgi.annotation.versioning.ConsumerType;

/**
 * Defines the {@code Servicecard} Sling Model used for the {@code lexusdrivers/components/content/servicecard} component.
 * 
 */
@ConsumerType
public interface Servicecard
    extends ComponentExporter
{

    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getServiceCardTitle();

    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getServiceCardDateLabel();

    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getServiceCardType();
    String getLinkType();

    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getServiceCardIcon();

    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getServiceCardAltText();

    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getServiceCardMessage();

    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getServiceCardDescription();

    String getServiceCardCTALabel();
    String getServiceCardURL();
    String getBorder();
    Resource getLinks();
    String getVhrLabel();
    String getAlertsLabel();
    String getServiceCardImg();
    String getNoRecords();
    String getNoVin();
    String getNoMileage();
    String getServiceCardClassName();

}
