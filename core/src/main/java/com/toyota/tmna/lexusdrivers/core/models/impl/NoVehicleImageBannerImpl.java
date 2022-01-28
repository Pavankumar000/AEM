package com.toyota.tmna.lexusdrivers.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.toyota.tmna.lexusdrivers.core.models.NoVehicleImageBanner;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { NoVehicleImageBannerImpl.class,
		ComponentExporter.class }, resourceType = "lexusdrivers/components/content/novehicleimagebanner")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class NoVehicleImageBannerImpl implements NoVehicleImageBanner {

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String label;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String desktop_banner_image;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String desktop_alt_text;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String tablet_banner_image;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String tablet_alt_text;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String mobile_banner_image;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String mobile_alt_text;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String primarybutton;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String primarybuttonURL;	
   
		
	@SlingObject
	private Resource resource;

	@Override
	public String getExportedType() {

		return resource.getResourceType();
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public String getDesktop_banner_image() {
		return desktop_banner_image;
	}

	@Override
	public String getDesktop_alt_text() {
		return desktop_alt_text;
	}

	@Override
	public String getTablet_banner_image() {
		return tablet_banner_image;
	}

	@Override
	public String getTablet_alt_text() {
		return tablet_alt_text;
	}

	@Override
	public String getMobile_banner_image() {
		return mobile_banner_image;
	}

	@Override
	public String getMobile_alt_text() {
		return mobile_alt_text;
	}

	@Override
	public String getPrimarybutton() {
		return primarybutton;
	}

	@Override
	public String getPrimarybuttonURL() {
		return primarybuttonURL;
	}
	
}
