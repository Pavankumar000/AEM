/*Lexus DriversLexus DriversLexus DriversLexus DriversLexus Drivers

 * ***********************************************************************

 * Toyota Owners CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Toyota Owners.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Toyota Owners and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Toyota Owners

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Toyota Owners.

 * ***********************************************************************

 */

package com.toyota.tmna.lexusdrivers.core.models.impl;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Sitenotification;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { SitenotificationImpl.class,
		ComponentExporter.class }, resourceType = "lexusdrivers/components/content/sitenotification")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SitenotificationImpl implements Sitenotification {

	@SlingObject
	private Resource resource;
	@ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource sitenotifications;

	@Override
	public String getExportedType() {
		return resource.getResourceType();
	}

	public Resource getSitenotifications() {
		return sitenotifications;
	}
}
