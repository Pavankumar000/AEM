/*

 * ***********************************************************************

 * Lexus drivers CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus drivers .

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus drivers  and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus drivers 

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus drivers .

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;


/**
 * Defines the {@code Mypanel} Sling Model used for the {@code lexusdrivers/components/content/mypanel} component.
 * 
 */
@ConsumerType
public interface Mypanel
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

    String getHeaderIcon();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getDescription();
    String getMypanelClassName();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getCtaLink();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getCtaText();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getOrder();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

    String getNotApplicableMyList();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

    String getCtaClassName();

}
