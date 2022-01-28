package com.toyota.tmna.lexusdrivers.core.models;

import org.osgi.annotation.versioning.ConsumerType;

import com.adobe.cq.export.json.ComponentExporter;

@ConsumerType
public interface TileComponent extends ComponentExporter {

	String getTiletitle();

	String getTitleicon();

	String getIconerrormsg();

	String getErromsg();

	String getErrorctalabel();

	String getErrorctalink();
	
	String getType();

	String getMediumTileMessage();
	
	String getSmallTileMessage();
}
