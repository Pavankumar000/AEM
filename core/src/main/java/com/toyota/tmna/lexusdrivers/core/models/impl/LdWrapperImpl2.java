/*

 * ***********************************************************************

 * Lexus CONFIDENTIAL

 * ___________________

 *

 * Copyright 2019 Lexus.

 * All Rights Reserved.

 *

 * NOTICE:  All information contained herein is, and remains the property

 * of Lexus and its suppliers, if any. The intellectual and

 * technical concepts contained herein are proprietary to Lexus

 * and its suppliers and are protected by trade secret or copyright law.

 * Dissemination of this information or reproduction of this material

 * is strictly forbidden unless prior written permission is obtained

 * from Lexus.

 * ***********************************************************************

 */

package com.toyota.tmna.lexusdrivers.core.models.impl;


import java.util.Map;
import java.util.Objects;


import com.adobe.cq.export.json.ContainerExporter;
import com.day.cq.wcm.foundation.model.responsivegrid.ResponsiveGrid;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.LdWrapper;

import javax.inject.Inject;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { LdWrapperImpl2.class,ComponentExporter.class}, resourceType = LdWrapperImpl2.RESOURCETYPE,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@SuppressWarnings("CQRules:CQBP-84")
public class LdWrapperImpl2
		implements LdWrapper, ContainerExporter {

	protected static final String RESOURCETYPE = "lexusdrivers/components/structure/LdWrapper2";
	private static final String TYPE_AUTH = "auth";
	private static final String TYPE_UNAUTH = "unauth";
	private static final Logger LOGGER = LoggerFactory.getLogger(LdWrapperImpl2.class);


	@ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource wrapper;

	@SlingObject
	private Resource resource;

	@Inject
	@Self
	private ResponsiveGrid responsiveGrid;

	@JsonIgnore
	public Resource getWrapper() {
		return wrapper;
	}

	public void setWrapper(Resource wrapper) {
		this.wrapper = wrapper;
	}

	@JsonIgnore
	public Resource getResource() {
		return resource;
	}
	@JsonIgnore
	public void setResource(Resource resource) {
		this.resource = resource;
	}

	@JsonIgnore
	public SlingHttpServletRequest getRequest() {
		return request;
	}
	@JsonIgnore
	public void setRequest(SlingHttpServletRequest request) {
		this.request = request;
	}

	@SlingObject
	private SlingHttpServletRequest request;


	public LdWrapperImpl2(){

	}

	@JsonIgnore
	public LdWrapperImpl2(SlingHttpServletRequest request,Resource wrapper){
		this.request = request;
		this.wrapper = wrapper;
	}


	public String @NotNull [] getExportedItemsOrder() {
		return responsiveGrid.getExportedItemsOrder();
	}

	public @NotNull Map<String, ? extends ComponentExporter> getExportedItems() {
		return responsiveGrid.getExportedItems();
	}

	public @NotNull String getExportedType() {
		return resource.getResourceType();
	}

	public @NotNull String getGridClassNames(){
		return Objects.requireNonNull(responsiveGrid.getGridClassNames());
	}
	public int getColumnCount (){
		return responsiveGrid.getColumnCount();
	}

	public Map<String, String> getColumnClassNames (){
		return Objects.requireNonNull(responsiveGrid.getColumnClassNames());
	}

}
