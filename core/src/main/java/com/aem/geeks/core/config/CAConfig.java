package com.aem.geeks.core.config;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;


@Configuration(label = "Geeks-Context Aware Configuration",
						description = "Context Aware Configuration for geeks.")
public @interface CAConfig {
	
	@Property(label = "Geeks Country Site",
					description = "Geeks Site Name")
		String siteCountry() default "us";
	@Property(label = "Geeks Country Locale",
			description = "Geeks Site for the different languages")
         String siteLocal() default "en";
	@Property(label = "Geeks  Site Admin",
			description = "Admin for updating country site.")
		 String siteAdmin() default "aem-geeks";
	@Property(label = "Site Section",
			description = "Geeks Site Name")
		 String siteSection() default "aem";
}
