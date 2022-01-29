package com.aem.geeks.core.models.impl;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.caconfig.ConfigurationResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import com.aem.geeks.core.config.CAConfig;
import com.aem.geeks.core.models.CAConfigmodel;
import com.day.cq.wcm.api.Page;

@Model(adaptables = { SlingHttpServletRequest.class },
adapters = {CAConfigmodel.class},
resourceType = {CAConfigmodelimpl.RESOURCE_TYPE},
 defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CAConfigmodelimpl implements CAConfigmodel{
protected static final String RESOURCE_TYPE="aemgeeks/components/content/card";

@SlingObject
ResourceResolver resourceresolver;

@ScriptVariable
Page currentPage;

@OSGiService
ConfigurationResolver configurationResolver;

private String siteCountry;
private String siteLocal;
private String siteAdmin;
private String siteSection;
private CAConfig caConfig;
@Override
public String getSiteCountry() {
	return siteCountry;
}
@Override
public String getSiteLocal() {
	return siteLocal;
}
@Override
public String getSiteAdmin() {
	return siteAdmin;
}
@Override
public String getSiteSection() {
	return siteSection;
}

@PostConstruct
public void postConstruct() {
	CAConfig caConfig=getContextAwareConfig(currentPage.getPath(),resourceresolver);
	siteCountry=caConfig.siteCountry();
	siteLocal=caConfig.siteLocal();
	siteAdmin=caConfig.siteAdmin();
	siteSection=caConfig.siteSection();
}
private CAConfig getContextAwareConfig(String currentPage, ResourceResolver resourceresolver2) {
	String currentPath=StringUtils.isNoneBlank(currentPage)?currentPage:StringUtils.EMPTY;
	Resource contenresource = resourceresolver.getResource(currentPath);
/*	if(contenresource !=null) {
	CofigurationBuilder configurationbuilder=contenresource.adaptTo(CofigurationBuilder.class);
			if(configurationbuilder !=null) {
				return configurationbuilder.as(CAConfig.class);
			}
	}*/
	return caConfig;
	
}
}
