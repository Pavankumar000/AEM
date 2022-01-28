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
 * Defines the {@code Vehiclehealthreport} Sling Model used for the {@code lexusdrivers/components/content/vehiclehealthreport} component.
 * 
 */
@ConsumerType
public interface Vehiclehealthreport
    extends ComponentExporter
{


    /**
     * Returns a title field value.
     * 
     * @return String
     * 
     */
    String getTitle();

    /**
     * Returns a label field value.
     * 
     * @return String
     * 
     */
    String getHealthReportLabel();

    /**
     * Returns a label field value.
     * 
     * @return String
     * 
     */
    String getHealthHistoryLabel();

    /**
     * Returns a label field value.
     * 
     * @return String
     * 
     */
    String getTransmissionMsg();

    /**
     * Returns a label field value.
     * 
     * @return String
     * 
     */
    String getNoTransmissionMsg();
  /**
     * Returns a label field value.
     * 
     * @return String
     * 
     */

    String getCountLabel();
      /**
     * Returns a label field value.
     * 
     * @return String
     * 
     */
    String getAlertTitle();
    
/**
     * Returns a label field value.
     * 
     * @return String
     * 
     */

  String getCaption();
  /**
     * Returns a label field value.
     * 
     * @return String
     * 
     */

  String getResultsLabel();
  /**
     * Returns a label field value.
     * 
     * @return String
     * 
     */

  String getMilesDrivenDate();


  String getHealthReportTitle();
  String getPdfLabel();

  String getRefreshLabel();
  String getTimeStampMsg();

  String getInfoDisclaimer();


  String getZeroAlerts();
  String getVhrImage();
  String getQuestionData();

  

}
