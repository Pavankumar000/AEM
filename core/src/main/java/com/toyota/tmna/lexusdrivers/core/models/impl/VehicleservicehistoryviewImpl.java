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
import java.util.Map;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Vehicleservicehistoryview;
import com.toyota.tmna.lexusdrivers.core.util.ContainerUtil;
import org.jetbrains.annotations.NotNull;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { VehicleservicehistoryviewImpl.class,
		ComponentExporter.class }, resourceType = VehicleservicehistoryviewImpl.RESOURCETYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@SuppressWarnings("CQRules:CQBP-84")
public class VehicleservicehistoryviewImpl extends ContainerUtil  implements Vehicleservicehistoryview {
	
	protected static final String RESOURCETYPE = "lexusdrivers/components/structure/VehicleServiceHistoryView";
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String title;

	@Override
	public String getTitle() {
		return title;
	}

}