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
import com.toyota.tmna.lexusdrivers.core.models.SelectedVehicleVideoBanner;

@Model(adaptables = { SlingHttpServletRequest.class }, adapters = { SelectedVehicleVideoBannerImpl.class,
		ComponentExporter.class }, resourceType = "lexusdrivers/components/content/selectedvehiclevideobanner")
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class SelectedVehicleVideoBannerImpl implements SelectedVehicleVideoBanner {

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String vinLabel;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String fuelTypeLabel;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String capacityTypeLabel;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String viewSpecLink;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String viewSpecText;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String nickName;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String nickNameIcon;

	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String defaultDesktopImage;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String altDesktop;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String defaultTabletImage;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String altTablet;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String defaultMobileImage;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String altMobile;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String defaultVideoSource;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String defaultImageSource;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String legalCopy;
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String altDefaultImage;

	
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	private String addvinLabel;

	@SlingObject
	private Resource resource;

	@Override
	public String getExportedType() {

		return resource.getResourceType();
	}

	@Override
	public String getVinLabel() {

		return vinLabel;
	}

	@Override
	public String getFuelTypeLabel() {

		return fuelTypeLabel;
	}

	@Override
	public String getCapacityTypeLabel() {

		return capacityTypeLabel;
	}

	@Override
	public String getViewSpecLink() {

		return viewSpecLink;
	}

	@Override
	public String getViewSpecText() {

		return viewSpecText;
	}

	@Override
	public String getNickName() {

		return nickName;
	}

	@Override
	public String getNickNameIcon() {

		return nickNameIcon;
	}

		

	@Override
	public String getAddvinLabel() {
		return addvinLabel;
	}

	
	@Override
	public String getDefaultDesktopImage() {
		return defaultDesktopImage;
	}
	
	@Override
	public String getDesktopAlt() {
		return altDesktop;
	}
	
	@Override
	public String getDefaultTabletImage() {
		return defaultTabletImage;
	}
	
	@Override
	public String getTabletAlt() {
		return altTablet;
	}
	
	@Override
	public String getDefaultMobileImage() {
		return defaultMobileImage;
	}
	
	@Override
	public String getMobileAlt() {
		return altMobile;
	}
	
	@Override
	public String getDefaultVideoSource() {
		return defaultVideoSource;
	}
	@Override
	public String getDefaultImageSource() {
		return defaultImageSource;
	}
	@Override
	public String getLegalCopy() {
		return legalCopy;
	}
	@Override
	public String getAltDefaultImage() {
		return altDefaultImage;
	}

}
