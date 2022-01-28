package com.toyota.tmna.lexusdrivers.core.models;

import org.osgi.annotation.versioning.ConsumerType;

import com.adobe.cq.export.json.ComponentExporter;

@ConsumerType
public interface NoVehicleImageBanner extends ComponentExporter {
	String getLabel();

	String getDesktop_banner_image();

	String getDesktop_alt_text();

	String getTablet_banner_image();

	String getTablet_alt_text();

	String getMobile_banner_image();

	String getMobile_alt_text();

	String getPrimarybutton();

	String getPrimarybuttonURL();
}
