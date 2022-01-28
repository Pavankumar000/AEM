/*

 * ***********************************************************************

 * Lexus CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus.

 * ***********************************************************************

 */


package com.toyota.tmna.lexusdrivers.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;


/**
 * Defines the {@code Listpanelcontent} Sling Model used for the {@code lexusdrivers/components/content/listpanelcontent} component.
 * 
 */
@ConsumerType
public interface Listpanelcontent
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
    String getIcon();

    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getIconList();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */
    String getnextgenIconText();
    /**
     * Get the showHr.
     * 
     * @return String
     * 
     */

    String getManualtype();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

    String getPanelType();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

    String getNoServiceDataMessage();
    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

    String getNoVehicleSelectedMessage();

     /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

    String getwarrantyServicesTitle();
     /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

    String getMultimediaManualTitle();

}
