package com.toyota.tmna.lexusdrivers.core.models;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import com.toyota.tmna.lexusdrivers.core.util.AEMServletUtil;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;
import com.toyota.tmna.lexusdrivers.core.util.GlobalNavConstants;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

@Model(adaptables = { SlingHttpServletRequest.class,
		Resource.class }, resourceType = GlobalNavigationModel.RESOURCE_TYPE, adapters = { GlobalNavigationModel.class,
				ComponentExporter.class }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class GlobalNavigationModel implements ComponentExporter {

	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	protected static final String RESOURCE_TYPE = ConstantsUtil.GNAV_MESSAGE_RESOURCE;

	@ValueMapValue(name = "logoalt")
	private String logoalt;
	@ValueMapValue(name = "body")
	private String body;
	@ValueMapValue(name = "quickLabel")
	private String quickLabel;
	@ValueMapValue(name = "bottomText")
	private String bottomText;
	@ValueMapValue(name = "sectionDescription")
	private String sectionDescription;
	@ValueMapValue(name = "manageGarageText")
	private String manageGarageText;
	@ValueMapValue(name = "logoimage")
	private String logoimage;
	@ValueMapValue(name = "sectionLabel")
	private String sectionLabel;
	@ValueMapValue(name = "defaultImg")
	private String defaultImg;

	@ValueMapValue(name = "manageGarageName")
	private String manageGarageName;
	@ValueMapValue(name = "manageGarageValue")
	private String manageGarageValue;
	@ValueMapValue(name = "manageGarageLink")
	private String manageGarageLink;
	@ValueMapValue(name = "linktype")
	private String linktype;

	@ValueMapValue(name = "garageTitle")
	private String garageTitle;
	@ValueMapValue(name = "garageDescription")
	private String garageDescription;
	@ValueMapValue(name = "findDealerLabel")
	private String findDealerLabel;
	@ValueMapValue(name = "findDealerLink")
	private String findDealerLink;

	@ValueMapValue(name = "clearFormLabel")
	private String clearFormLabel;
	@ValueMapValue(name = "vehicleSelectText")
	private String vehicleSelectText;
	@ValueMapValue(name = "vehicleYearSelector")
	private String vehicleYearSelector;

	@ValueMapValue(name = "selectcarouselTitle")
	private String selectcarouselTitle;
	@ValueMapValue(name = "buttonLabel")
	private String buttonLabel;
	@ValueMapValue(name = "videoslide")
	private String videoslide;
	@ValueMapValue(name = "vINLabel")
	private String vINLabel;
	@ValueMapValue(name = "carousellinktype")
	private String carousellinktype;
	@ValueMapValue(name = "quicknavLabel")
	private String quicknavLabel;
	@ValueMapValue(name = "name")
	private String name;
	@ValueMapValue(name = "quicklinkURL")
	private String quicklinkURL;
	@ValueMapValue(name = "quickvalue")
	private String quickvalue;
	@ValueMapValue(name = "benefitsTitle")
	private String benefitsTitle;
	@ValueMapValue(name = "placeholdertext")
	private String placeholdertext;
	@ValueMapValue(name = "searchUrlPath")
	private String searchUrlPath;
	@ValueMapValue(name = "manageGarageIcon")
	private String manageGarageIcon;

	public String getManageGarageIcon() {
		return manageGarageIcon;
	}

	public String getPlaceholdertext() {
		return placeholdertext;
	}

	public String getSearchUrlPath() {
		return searchUrlPath;
	}

	public String getLogoalt() {
		return logoalt;
	}

	public String getBody() {
		return body;
	}

	public String getQuickLabel() {
		return quickLabel;
	}

	public String getBottomText() {
		return bottomText;
	}

	public String getSectionDescription() {
		return sectionDescription;
	}

	public String getManageGarageText() {
		return manageGarageText;
	}

	public String getClearFormLabel() {
		return clearFormLabel;
	}

	public String getLogoimage() {
		return logoimage;
	}

	public String getManageGarageLink() {
		return manageGarageLink;
	}

	public String getDefaultImg() {
		return defaultImg;
	}

	public String getSelectcarouselTitle() {
		return selectcarouselTitle;
	}

	public String getButtonLabel() {
		return buttonLabel;
	}

	public String getVideoslide() {
		return videoslide;
	}

	public String getvINLabel() {
		return vINLabel;
	}

	public String getCarousellinktype() {
		return carousellinktype;
	}

	public String getQuicknavLabel() {
		return quicknavLabel;
	}

	public String getName() {
		return name;
	}

	public String getQuicklinkURL() {
		return quicklinkURL;
	}

	public String getQuickvalue() {
		return quickvalue;
	}

	public String getBenefitsTitle() {
		return benefitsTitle;
	}

	public String getManageGarageName() {
		return manageGarageName;
	}

	public String getManageGarageValue() {
		return manageGarageValue;
	}

	public String getLinktype() {
		return linktype;
	}

	public String getSectionLabel() {
		return sectionLabel;
	}

	public String getVehicleSelectText() {
		return vehicleSelectText;
	}

	public String getVehicleYearSelector() {
		return vehicleYearSelector;
	}

	@Inject
	@Via("resource")
	private Resource quicklinks;

	public Resource getQuicklinks() {

		return quicklinks;
	}

	@Inject
	@Via("resource")
	private Resource tiles;

	public Resource getTiles() {

		return tiles;
	}

	@Inject
	@Via("resource")
	private Resource navigationLinks;

	public Resource getNavigationLinks() {

		return navigationLinks;
	}

	@Inject
	@Via("resource")
	private Resource navigationMessages;

	public Resource getNavigationMessages() {

		return navigationMessages;
	}

	@Inject
	@Via("resource")
	private Resource manageGarage;

	public Resource getManageGarage() {

		return manageGarage;
	}

	@Inject
	@Via("resource")
	private Resource loggedIn;

	public Resource getLoggedIn() {

		return loggedIn;
	}

	@Inject
	@Via("resource")
	private Resource loggedOut;

	public Resource getLoggedOut() {

		return loggedOut;
	}

	@Nonnull
	@Override
	public String getExportedType() {
		return RESOURCE_TYPE;
	}
	 
}
