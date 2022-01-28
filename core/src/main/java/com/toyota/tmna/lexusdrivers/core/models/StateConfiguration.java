package com.toyota.tmna.lexusdrivers.core.models;

import org.osgi.annotation.versioning.ConsumerType;

import com.adobe.cq.export.json.ComponentExporter;

@ConsumerType
public interface StateConfiguration extends ComponentExporter {

	String getComponenttype();
}
