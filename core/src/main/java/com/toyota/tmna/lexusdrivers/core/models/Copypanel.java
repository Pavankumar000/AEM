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
 * Defines the {@code Copypanel} Sling Model used for the {@code lexusdrivers/components/content/copypanel} component.
 * 
 */
@ConsumerType
public interface Copypanel
    extends ComponentExporter
{


    /**
     * Returns title of the setion
     * 
     * @return String
     * 
     */
    String getTitle();

    /**
     * Returns a optional richText
     * 
     * @return String
     * 
     */

    String getRichTextTitle();
    String getDescription();

    /**
     * Get the icon.
     * 
     * @return String
     * 
     */
    String getIcon();
    String getJoinDesc();

    /**
     * Returns link style
     * 
     * @return String
     * 
     */
    String getType();
    String getCtatype();


    /**
     * Returns a alt text
     * 
     * @return String
     * 
     */
    String getAlignment();

    /**
     * Returns a Button Link
     * 
     * @return String
     * 
     */
    String getCtaLink();

    /**
     * Returns a Button Label
     * 
     * @return String
     * 
     */
    String getCtatext();

	String getHasDividerLine();
	String getImage();
	String getVideo();
	String getExtrapadding();
	String getHeader();
	String getImagealt();
    String getShowTitleInasLink();
    String getShowHeaderasLink();
    String getCssClassName();

}
