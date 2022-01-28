package com.toyota.tmna.lexusdrivers.core.search.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Lexus Drivers CloudSearch properties for rewards")
public @interface RewardsConfigs {
    @AttributeDefinition(name="rewards_searchEndpointURL", type= AttributeType.STRING)
    String rewardsSearchEndpointURL();

    @AttributeDefinition(name="rewards_uploadDocEndpointURL", type=AttributeType.STRING)
    String rewardsUploadDocEndpointURL();
}
