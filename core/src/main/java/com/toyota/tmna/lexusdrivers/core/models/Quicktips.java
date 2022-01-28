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
 * Defines the {@code Quicktips} Sling Model used for the {@code lexusdrivers/components/content/quicktips} component.
 * 
 */
@ConsumerType
public interface Quicktips
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
    String getSubTitle();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getDescription();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getImage();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getOpacity();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getLargeTileImage();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getMediumTileImage();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getSmallTileImage();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getTileImageOpacity();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getVideoUrl();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getVideoId();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getPrimaryLinkText();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getPrimaryLink();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getSecondaryLinkText();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return pathbrowser
     * 
     */
    String getSecondaryLink();

}
