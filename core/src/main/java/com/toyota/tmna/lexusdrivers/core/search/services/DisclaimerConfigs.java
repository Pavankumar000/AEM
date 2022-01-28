package com.toyota.tmna.lexusdrivers.core.search.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

    @ObjectClassDefinition(name = "Lexus Drivers CloudSearch properties for disclaimers")
    public @interface DisclaimerConfigs {

        @AttributeDefinition(name="disclaimersSearchEndpointURL", type= AttributeType.STRING)
        String disclaimersSearchEndpointURL();

        @AttributeDefinition(name="disclaimersUploadDocEndpointURL", type=AttributeType.STRING)
        String disclaimersUploadDocEndpointURL();
    }
