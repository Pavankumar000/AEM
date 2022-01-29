package com.aem.geeks.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.aem.geeks.core.models.Task3;

@Model(adaptables = SlingHttpServletRequest.class,
adapters =Task3.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL )


public class Task3impl implements Task3 {

	@ValueMapValue
	String name;
	
	@ValueMapValue
	String country;

	@Override
	public String getNameField() {
		return name;
	}

	@Override
	public String getCountryField() {
		return country;
	}
}
