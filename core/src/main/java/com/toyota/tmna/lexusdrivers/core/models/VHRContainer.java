package com.toyota.tmna.lexusdrivers.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface VHRContainer extends ComponentExporter{
	
	String getTitle();

}
