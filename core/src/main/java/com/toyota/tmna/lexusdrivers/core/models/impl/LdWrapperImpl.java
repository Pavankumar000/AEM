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

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.day.cq.wcm.api.WCMMode;
import com.toyota.tmna.lexusdrivers.core.models.LdWrapper;
import com.toyota.tmna.lexusdrivers.core.services.AuthService;
import com.toyota.tmna.lexusdrivers.core.util.AEMServletUtil;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;
import com.toyota.tmna.lexusdrivers.core.util.ContainerUtil;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { LdWrapperImpl.class,
		ComponentExporter.class }, resourceType = LdWrapperImpl.RESOURCETYPE)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
@SuppressWarnings("CQRules:CQBP-84")
public class LdWrapperImpl extends ContainerUtil
implements LdWrapper {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LdWrapperImpl.class);
	protected static final String RESOURCETYPE = "lexusdrivers/components/structure/LdWrapper";
	private static final String TYPE_AUTH = "auth";
	private static final String TYPE_UNAUTH = "unauth";

	@ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource wrapper;
	
	@SlingObject
	private Resource resource;
	
	@SlingObject
	private SlingHttpServletRequest request;
	
	@OSGiService
	private AuthService authService;
	
	private Boolean show = Boolean.TRUE;

	public LdWrapperImpl(){

	}

	public LdWrapperImpl(SlingHttpServletRequest request, AuthService authService, Resource wrapper){
		this.request = request;
		this.authService = authService;
		this.wrapper = wrapper;
	}

	@PostConstruct
	public void init() {
		//LOGGER.info("Init method called : {}", resource.getPath());
		
		/*WCMMode mode = WCMMode.fromRequest(request);
		if (mode.compareTo(WCMMode.DISABLED) != 0) {
			if (Boolean.TRUE.equals(AEMServletUtil.isValidCookie(request, TYPE_AUTH))) {
				show = setShow(TYPE_AUTH);				
			} else {
				show = setShow(TYPE_UNAUTH);
			}
			return;
		}

		if (Boolean.TRUE.equals(AEMServletUtil.isValidCookie(request, ConstantsUtil.ID_TOKEN))) {
			show = setShow(TYPE_AUTH);
		} else {
			show = setShow(TYPE_UNAUTH);
		}
		LOGGER.info("Is Authenticated : {}",show);
	}

	private Boolean setShow(String typeAuth) {
		if (null == wrapper) {
			return Boolean.TRUE;
		}
		ValueMap properties = ResourceUtil.getValueMap(wrapper);
		String type = properties.get("type", String.class);
		
		if (typeAuth.equalsIgnoreCase(type)) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		} */
	}

	public String @NotNull [] getExportedItemsOrder() {
		if (Boolean.TRUE.equals(show)) {
			return super.getExportedItemsOrder();
		}
		return new String[] {};
	}

	public @NotNull Map<String, ? extends ComponentExporter> getExportedItems() {
		if (Boolean.TRUE.equals(show)) {
			return super.getExportedItems();
		}
		return new HashMap<>();
	}


}
