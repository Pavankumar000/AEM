package com.toyota.tmna.lexusdrivers.core.configs;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
		name = "HeaderFactory EndPoints Configuration",
		description = "This is Configuration for  Header Factory")
public @interface HeaderFactoryEndPointsConfig {

	@AttributeDefinition(
			name = "Analytics",
			description = "This is Configuration for analytics",
			type = AttributeType.STRING
	)
	String analytics();
	
	@AttributeDefinition(
			name = "Dcs1 Private",
			description = "This is Configuration for dcs1Private",
			type = AttributeType.STRING
	)
	String dcs1Private();
	
	@AttributeDefinition(
			name = "Dcs1 Public",
			description = "This is Configuration for dcs1Public",
			type = AttributeType.STRING
	)
	String dcs1Public();
	
	@AttributeDefinition(
			name = "Dcs3",
			description = "This is Configuration for dcs3",
			type = AttributeType.STRING
	)
	String dcs3();

	@AttributeDefinition(
			name = "waldo",
			description = "This is Configuration for dcs3",
			type = AttributeType.STRING
	)
	String waldo();
	
	@AttributeDefinition(
			name = "DisRest",
			description = "This is Configuration for disRest",
			type = AttributeType.STRING
	)
	String disRest();
	
	@AttributeDefinition(
			name = "Disclaimers",
			description = "This is Configuration for disclaimers",
			type = AttributeType.STRING
	)
	String disclaimers();
	
	@AttributeDefinition(
			name = "GlobalSettings",
			description = "This is Configuration for globalSettings",
			type = AttributeType.STRING
	)
	String globalSettings();
	
	@AttributeDefinition(
			name = "Google Map",
			description = "This is Configuration for googleMap",
			type = AttributeType.STRING
	)
	String googleMap();
	
	@AttributeDefinition(
			name = "Google Map Directions",
			description = "This is Configuration for googleMapDirections",
			type = AttributeType.STRING
	)
	String googleMapDirections();
	
	@AttributeDefinition(
			name = "Google Region Map",
			description = "This is Configuration for googleRegionMap",
			type = AttributeType.STRING
	)
	String googleRegionMap();
	
	@AttributeDefinition(
			name = "Hand Raisers",
			description = "This is Configuration for handraisers",
			type = AttributeType.STRING
	)
	String handraisers();
	
	@AttributeDefinition(
			name = "IPerceptions",
			description = "This is Configuration for iPerceptions",
			type = AttributeType.STRING
	)
	String iPerceptions();
	
	@AttributeDefinition(
			name = "Social Login",
			description = "This is Configuration for sociallogin",
			type = AttributeType.STRING
	)
	String sociallogin();
}