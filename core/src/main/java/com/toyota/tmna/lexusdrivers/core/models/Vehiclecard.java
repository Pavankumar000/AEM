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
 * Defines the {@code Vehiclecard} Sling Model used for the
 * {@code lexusdrivers/components/content/vehiclecard} component.
 * 
 */
@ConsumerType
public interface Vehiclecard extends ComponentExporter {

	String getTitle();

	String getSetPrimvehicle();

	String getPrimVehicle();

	String getManagecta();

	String getDeletevehiclelabel();

	String getVinlabel();

	String getNoVinLabel();

	String getNoVinButtonLabel();

	String getOthertitle();

	String getOtherprimvehicle();

	String getOtherdescription();

	String getSelectvehiclelabel();

	String getOtherVehicleButton();

	String getCardType();
	String getDefaultImg();
	String getManageVehicleCTALink();

}