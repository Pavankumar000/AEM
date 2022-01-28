package com.toyota.tmna.lexusdrivers.core.search.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;


@ObjectClassDefinition(name = "Lexus Drivers CloudSearch properties for videos")
    public @interface VideosConfig {

        @AttributeDefinition(name="videos_searchEndpointURL", type= AttributeType.STRING)
        String videos_searchEndpointURL();

        @AttributeDefinition(name="videos_uploadDocEndpointURL", type=AttributeType.STRING)
        String videos_uploadDocEndpointURL();
    }
