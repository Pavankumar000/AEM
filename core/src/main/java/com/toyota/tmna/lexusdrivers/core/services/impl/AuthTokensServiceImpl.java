package com.toyota.tmna.lexusdrivers.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import com.toyota.tmna.lexusdrivers.core.services.AuthTokensService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = AuthTokensService.class, immediate = true)
@Designate(ocd = AuthTokensServiceImpl.AuthPropertyService.class)

public class AuthTokensServiceImpl implements AuthTokensService {

	private String modelYear;
	private String manuals;
	private String masterPreferences;
	private String safetyCamapaigns;
	private String maintenanceScheduleVin;
	private String maintenanceScheduleDMY;
	private String maintenanceScheduleETD;
	private String vehicleSpecs;
	private String telematicsInfo;
	private String tenantId;
	private String tenantUrl;
	private String tenantPath;
	private String resourceUrl;
	private String clientId;
	private String clientSecret;
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthTokensServiceImpl.class);

	@Activate
	public void activate(AuthPropertyService config) {
		LOGGER.info("auth tokens activate :" + config);

		this.modelYear = config.getModelYear();
		this.masterPreferences = config.getMasterPreferences();
		this.manuals = config.getManuals();
		this.safetyCamapaigns = config.getSafetyCampaign();
		this.maintenanceScheduleVin = config.getMaintenanceScheduleVin();
		this.maintenanceScheduleDMY = config.getMaintenanceScheduleDMY();
		this.maintenanceScheduleETD = config.getMaintenanceScheduleETD();
		this.vehicleSpecs = config.getVehicleSpecs();
		this.telematicsInfo = config.getTelematicsInfo();
		this.tenantId = config.getTenantId();
		this.tenantUrl = config.getTenantUrl();
		this.tenantPath = config.getTenantPath();
		this.resourceUrl = config.getResourceUrl();
		this.clientId = config.getClientId();
		this.clientSecret = config.getClientSecret();

	}

	@Override
	public String getModelYear() {
		return modelYear;
	}

	@Override
	public String getMasterPreferences() {
		return masterPreferences;
	}

	@Override
	public String getManuals() {
		return manuals;
	}

	@Override
	public String getSafetyCampaign() {
		return safetyCamapaigns;
	}

	@Override
	public String getMaintenanceScheduleVin() {
		return maintenanceScheduleVin;
	}

	@Override
	public String getMaintenanceScheduleDMY() {
		return maintenanceScheduleDMY;
	}

	@Override
	public String getMaintenanceScheduleETD() {
		return maintenanceScheduleETD;
	}

	@Override
	public String getVehicleSpecs() {
		return vehicleSpecs;
	}

	@Override
	public String getTelematicsInfo() {
		return telematicsInfo;
	}

	@Override
	public String getTenantId() {
		return tenantId;
	}

	@Override
	public String getTenantUrl() {
		return tenantUrl;
	}

	@Override
	public String getTenantPath() {
		return tenantPath;
	}

	@Override
	public String getResourceUrl() {
		return resourceUrl;
	}

	@Override
	public String getClientId() {
		return clientId;
	}

	@Override
	public String getClientSecret() {
		return clientSecret;
	}

	@ObjectClassDefinition(name = "Lexus Drivers Public OAuth properties")
	public @interface AuthPropertyService {

		@AttributeDefinition(name = "Model Year", type = AttributeType.STRING)
		String getModelYear();

		@AttributeDefinition(name = "Master Preferences", type = AttributeType.STRING)
		String getMasterPreferences();

		@AttributeDefinition(name = "Manuals", type = AttributeType.STRING)
		String getManuals();

		@AttributeDefinition(name = "Safety Campaigns", type = AttributeType.STRING)
		String getSafetyCampaign();

		@AttributeDefinition(name = "Maintenance Schedule Vin", type = AttributeType.STRING)
		String getMaintenanceScheduleVin();

		@AttributeDefinition(name = "Maintenance Schedule DMY", type = AttributeType.STRING)
		String getMaintenanceScheduleDMY();

		@AttributeDefinition(name = "Maintenance Schedule ETD", type = AttributeType.STRING)
		String getMaintenanceScheduleETD();

		@AttributeDefinition(name = "Vehicle Specs", type = AttributeType.STRING)
		String getVehicleSpecs();

		@AttributeDefinition(name = "Telematics Info", type = AttributeType.STRING)
		String getTelematicsInfo();

		@AttributeDefinition(name = "Tenant Id", type = AttributeType.STRING)
		String getTenantId();

		@AttributeDefinition(name = "Tenant Url", type = AttributeType.STRING)
		String getTenantUrl();

		@AttributeDefinition(name = "Tenant Path", type = AttributeType.STRING)
		String getTenantPath();

		@AttributeDefinition(name = "Resource Url", type = AttributeType.STRING)
		String getResourceUrl();

		@AttributeDefinition(name = "Client Id", type = AttributeType.STRING)
		String getClientId();

		@AttributeDefinition(name = "Client Secret", type = AttributeType.STRING)
		String getClientSecret();

	}

} 