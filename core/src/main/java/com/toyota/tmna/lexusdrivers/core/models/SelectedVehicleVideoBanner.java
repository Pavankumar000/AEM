package com.toyota.tmna.lexusdrivers.core.models;

import org.osgi.annotation.versioning.ConsumerType;

import com.adobe.cq.export.json.ComponentExporter;

@ConsumerType
public interface SelectedVehicleVideoBanner extends ComponentExporter {

	String getVinLabel();

	String getFuelTypeLabel();

	String getCapacityTypeLabel();

	String getViewSpecLink();

	String getViewSpecText();

	String getNickName();

	String getNickNameIcon();

	
	String getAddvinLabel();
  

	String getDefaultDesktopImage();
	String getDesktopAlt();

	String getDefaultTabletImage();
	String getTabletAlt();

	String getDefaultMobileImage();
	String getMobileAlt();

	String getDefaultVideoSource();

   String getDefaultImageSource();

   String getLegalCopy();

   String getAltDefaultImage();

}
