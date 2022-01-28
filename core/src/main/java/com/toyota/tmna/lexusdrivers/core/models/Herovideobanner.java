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
 * Defines the {@code Herovideobanner} Sling Model used for the {@code lexusdrivers/components/content/herovideobanner} component.
 * 
 */
@ConsumerType
public interface Herovideobanner
    extends ComponentExporter
{


    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getVideoSource();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getVideoSourceAlt();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getImageSource();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getImageSourceAlt();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getId();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getDesktopImage();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getDesktopImageAlt();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getMobileImage();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getMobileImageAlt();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getTabletImage();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getTabletImageAlt();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getLegalCopy();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getNickNameText();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getVINText();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getViewSpecsLink();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getViewSpecsText();

}