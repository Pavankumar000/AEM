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
 * Defines the {@code Addvehicleservicehistory} Sling Model used for the {@code lexusdrivers/components/content/addvehicleservicehistory} component.
 * 
 */
@ConsumerType
public interface Addvehicleservicehistory
    extends ComponentExporter
{


    /**
     * Returns a text value tooltip used somewhere in the component
     * 
     * @return String
     * 
     */

    String getRepairOrderLabel();
    String getMileageLabel();
    String getServiceDate();
    String getEventLabel();
    String getServiceProviderLabel();
    String getServiceIncLabel();
    String getCommentsLabel();
    String getServiceDesc();
    String getServiceCategory();

    String getSaveLabel();
    String getCancelLabel();
    String getDeleteEventLabel();
    String getAddAnotherServiceLabel();
    String getEditHistoryDeleteModalTitle();
    String getEditHistoryCancelModalTitle();
    String getAddHistoryDeleteModalTitle();
    String getAddHistoryCancelModalTitle();
    String getCloseModalDescription();
    String getServiceLink();
    String getModalPrimaryButton();
    String getModalSecondaryButton();
    String getModalCancelDescription();
    String getDateError();
    String getProviderError();
    String getProviderNameError();
    String getMileageError();
    String getServiceCategoryError();
    String getServiceDescError();
    String getServiceFailError();
    String getAddRecordError();
    String getUpdateRecordError();
    String getDeleteRecordError();
    String getDescIcon();
    String getModalIcon();
}
