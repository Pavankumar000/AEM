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
 * Defines the {@code Editvehiclesettingsview} Sling Model used for the {@code lexusdrivers/components/content/editvehiclesettingsview} component.
 * 
 */
@ConsumerType
public interface Editvehiclesettingsview
    extends ComponentExporter
{


    /**
     * Returns title of the component.
     * 
     * @return String
     * 
     */
    String getTitle();

}
