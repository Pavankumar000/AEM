package com.toyota.tmna.lexusdrivers.core.search.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Lexus Drivers CloudSearch properties for stories")
public @interface StoriesConfig {
    @AttributeDefinition(name="stories_searchEndpointURL", type= AttributeType.STRING)
        String stories_searchEndpointURL();
    @AttributeDefinition(name="stories_uploadDocEndpointURL", type=AttributeType.STRING)
        String stories_uploadDocEndpointURL();
    }
