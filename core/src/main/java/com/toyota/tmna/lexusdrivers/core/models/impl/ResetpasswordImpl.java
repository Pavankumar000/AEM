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
import com.toyota.tmna.lexusdrivers.core.models.Resetpassword;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { ResetpasswordImpl.class,
		ComponentExporter.class }, resourceType = "lexusdrivers/components/content/resetpassword")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ResetpasswordImpl extends PasswordinputImpl implements Resetpassword {

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String title;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String description;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String passwordLengthPattern;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String resetButtonText;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String needMoreHelp;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String successPage;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String name;

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getPasswordLabel() {
		return passwordLabel;
	}

	@Override
	public String getPasswordRequiredMessage() {
		return passwordRequiredMessage;
	}

	@Override
	public String getPasswordLengthPattern() {
		return passwordLengthPattern;
	}

	@Override
	public String getShowLabel() {
		return showLabel;
	}

	@Override
	public String getHideLabel() {
		return hideLabel;
	}

	@Override
	public String getResetButtonText() {
		return resetButtonText;
	}

	@Override
	public String getNeedMoreHelp() {
		return needMoreHelp;
	}

	@Override
	public String getSuccessPage() {
		return successPage;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getExportedType() {
		return resource.getResourceType();
	}

}
