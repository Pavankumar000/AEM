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
import com.toyota.tmna.lexusdrivers.core.models.Endcapcopypanel;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class }, 
adapters = { EndcapcopypanelImpl.class,
		ComponentExporter.class }, resourceType = "lexusdrivers/components/content/endcapcopypanel")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class EndcapcopypanelImpl implements Endcapcopypanel {

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String title;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String titleStyle;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String tagline;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String taglineStyle;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String description;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String componentStyle;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String enableCustomCSS;

	@SlingObject
	private Resource resource;

	@ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource ctaMultiField;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getTitleStyle() {
		return titleStyle;
	}

	@Override
	public String getTagline() {
		return tagline;
	}

	@Override
	public String getTaglineStyle() {
		return taglineStyle;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getComponentStyle() {
		return componentStyle;
	}
	@Override
	public String getEnableCustomCSS() {
		return enableCustomCSS;
	}

	@Override
	public String getExportedType() {
		return resource.getResourceType();
	}

	public Resource getCtaMultiField() {
		return ctaMultiField;
	}

}
