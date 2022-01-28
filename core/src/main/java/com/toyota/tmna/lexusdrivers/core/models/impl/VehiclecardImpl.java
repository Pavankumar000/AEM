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

package com.toyota.tmna.lexusdrivers.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Vehiclecard;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.fasterxml.jackson.annotation.JsonProperty;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { VehiclecardImpl.class,
		ComponentExporter.class }, resourceType = "lexusdrivers/components/content/vehiclecard")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class VehiclecardImpl implements Vehiclecard {

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String title;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String setPrimvehicle;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String primVehicle;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String managecta;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String manageVehicleCTALink;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String deletevehiclelabel;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String vinlabel;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String noVinLabel;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String noVinButtonLabel;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String othertitle;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String otherprimvehicle;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String otherdescription;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String selectvehiclelabel;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String otherVehicleButton;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String cardType;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String defaultImg;

	@SlingObject
	private Resource resource;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getDefaultImg() {
		return defaultImg;
	}

	@Override
	public String getExportedType() {
		return resource.getResourceType();
	}

	@Override
	public String getSetPrimvehicle() {
		return setPrimvehicle;
	}

	@Override
	public String getPrimVehicle() {
		return primVehicle;
	}

	@Override
	public String getManagecta() {
		return managecta;
	}
	@Override
	public String getManageVehicleCTALink() {
		return manageVehicleCTALink;
	}

	@Override
	public String getDeletevehiclelabel() {
		return deletevehiclelabel;
	}

	@Override
	public String getVinlabel() {
		return vinlabel;
	}

	@Override
	public String getNoVinLabel() {
		return noVinLabel;
	}

	@Override
	public String getNoVinButtonLabel() {
		return noVinButtonLabel;
	}

	@Override
	public String getOthertitle() {
		return othertitle;
	}

	@Override
	public String getOtherprimvehicle() {
		return otherprimvehicle;
	}

	@Override
	public String getOtherdescription() {
		return otherdescription;
	}

	@Override
	public String getSelectvehiclelabel() {
		return selectvehiclelabel;
	}

	@Override
	public String getOtherVehicleButton() {
		return otherVehicleButton;
	}


	@Override
	public String getCardType() {
		return cardType;
	}

}