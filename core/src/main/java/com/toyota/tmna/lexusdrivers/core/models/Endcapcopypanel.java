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
 * Defines the {@code Endcapcopypanel} Sling Model used for the
 * {@code lexusdrivers/components/content/endcapcopypanel} component.
 * 
 */
@ConsumerType
public interface Endcapcopypanel extends ComponentExporter {

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

	String getTitleStyle();
	
	 /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

	String getTagline();
	
	 /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

	String getTaglineStyle();
	
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
     * @return String
     * 
     */

	String getComponentStyle();
     /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

     String getEnableCustomCSS();
}
