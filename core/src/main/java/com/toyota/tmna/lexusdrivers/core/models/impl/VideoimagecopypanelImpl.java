package com.toyota.tmna.lexusdrivers.core.models.impl;


import com.toyota.tmna.lexusdrivers.core.models.Videoimagecopypanel;

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


@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { VideoimagecopypanelImpl.class,
		ComponentExporter.class }, resourceType = "lexusdrivers/components/content/videoimagecopypanel")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class VideoimagecopypanelImpl extends CopypanelImpl implements Videoimagecopypanel {

	

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String textplacement;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String assetType;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String articleType;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String assetsource;
	
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String myList;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String notApplicableMyList;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String showCTA;


	@ChildResource(injectionStrategy = InjectionStrategy.OPTIONAL)
	private Resource ctaLinks;

	public Resource getCtaLinks() {

		return ctaLinks;
	}
	
	public String getMyList() {
		return myList;
    }

	public String getNotApplicableMyList() {
		return notApplicableMyList;
    }

	@Override
	public String getAssetsource() {
		return assetsource;
	}

	@Override
	public String getTextplacement() {
		return textplacement;
	}

	@Override
	public String getAssetType() {
		return assetType;
	}
	@Override
	public String getArticleType() {
		return articleType;
	}

	@Override
	public String getShowCTA() {
		return showCTA;
	}

  
}
