package com.toyota.tmna.lexusdrivers.core.search.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Lexus Drivers Waldo properties")
public @interface WaldoConfigs {

    @AttributeDefinition(name = "waldoReferer", type = AttributeType.STRING)
    String WaldoReferer() default "https://stg-ld.cdn.cepo-proxy.tms.aws.lexus.com/lexusdrivers";

    @AttributeDefinition(name = "waldoKey", type = AttributeType.STRING)
    String WaldoKey();

    @AttributeDefinition(name = "waldoZipEndPoint", type = AttributeType.STRING)
    String WaldoZipEndPoint() default "https://api.staging.waldo.toyota.com/zip/latlng";

    @AttributeDefinition(name = "waldoLatLangEndPoint", type = AttributeType.STRING)
    String WaldoLatLangEndPoint() default "https://api.staging.waldo.toyota.com/latlng/zip";

    @AttributeDefinition(name = "waldoZipCityStateEndPoint", type = AttributeType.STRING)
    String WaldoZipCityStateEndPoint() default "https://api.staging.waldo.toyota.com/zip/citystate";
}
