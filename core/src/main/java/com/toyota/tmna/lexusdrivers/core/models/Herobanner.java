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
 * Defines the {@code Herobanner} Sling Model used for the {@code lexusdrivers/components/content/herobanner} component.
 * 
 */
@ConsumerType
public interface Herobanner
    extends ComponentExporter
{


    /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getDisclaimer();
     /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */

    String getLegalCopy();
     /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getPrimaryCTA();
     /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getMakePrimaryCTA();
     /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */
    String getSuccessMessage();
    String getJoinDesc();
     /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */

    String getmyList();
     /**
     * Returns a disclaimer field value.
     * 
     * @return String
     * 
     */

    String getShowInEditor();

    String getNotApplicableMyList();
}
