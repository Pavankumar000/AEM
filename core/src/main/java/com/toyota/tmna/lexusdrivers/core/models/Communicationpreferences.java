/*

 * ***********************************************************************

 *  Lexus Drivers CONFIDENTIAL

 * ___________________

 *

 * Copyright 2021  Lexus Drivers.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus Drivers and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to  Lexus Drivers

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
 * Defines the {@code Communicationpreferences} Sling Model used for the {@code lexusdrivers/components/content/communicationpreferences} component.
 * 
 */
@ConsumerType
public interface Communicationpreferences
    extends ComponentExporter
{

    /**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */
    String getDescription();

    /**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */
    String getPrimaryCTA();

    /**
     * Returns a vehicle message field value.
     * 
     * @return String
     * 
     */
    String getSecondaryCTA();

    String getEditIcon();

    String getCancelIcon();
    String getEditEmailCtaLink();
    String getEmailLabel();
    String getEditEmailLabel();
    String getEmailInfo();

    String getBreadCrumbHeading();
    String getServiceConnectTitle();
    String getServiceConnectSubTitle();
    String getVehicleTitle();
    String getServiceConnectDescription();
    String getServiceEmailTitle();
    String getServiceNotificationTitle();
    String getServiceDealerTitle();

    String getUnsubscribeTitle();
    String getUnsubscribeDescription();
    String getPrivacyCta();
    String getPrivacyCtaLink();
    String getConfirmationMessage();
    String getSuccessMessage();
    String getPreferenceCta();
    String getModalText();
    String getModalDescription();
    String getSubscriptionError();
    String getSaveError();
    String getUnsubscribeOk();

}
