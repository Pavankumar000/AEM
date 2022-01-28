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
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.Quicklinks;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import javax.inject.Inject;
import org.apache.sling.models.annotations.Via;

@Model(adaptables = {
    SlingHttpServletRequest.class
}, adapters = {
    QuicklinksImpl.class,
    ComponentExporter.class
}, resourceType = "lexusdrivers/components/content/quicklinks")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class QuicklinksImpl
    implements Quicklinks
{
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String header;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String title;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String signInUrl;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String signInButtonText;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String createAccountUrl;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String createAccountButtonText;
	@SlingObject
	private Resource resource;

	@Override
	public String getHeader() {
		return header;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getSignInUrl() {
		return signInUrl;
	}

	@Override
	public String getSignInButtonText() {
		return signInButtonText;
	}

	@Override
	public String getCreateAccountUrl() {
		return createAccountUrl;
	}

	@Override
	public String getCreateAccountButtonText() {
		return createAccountButtonText;
	}

	@Override
	public String getExportedType() {
		return resource.getResourceType();
	}

	
    @ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource quickLinks;

	public Resource getQuickLinks() {

		return quickLinks;
	}

}
