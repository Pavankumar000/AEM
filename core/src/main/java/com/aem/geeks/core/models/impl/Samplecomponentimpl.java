package com.aem.geeks.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.geeks.core.models.Samplecomponent;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters =Samplecomponent.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL )
public class Samplecomponentimpl implements Samplecomponent {

	  private static final Logger LOG = LoggerFactory.getLogger(Samplecomponentimpl.class);
	  @ValueMapValue
	  String textfield;
	  
	  @ValueMapValue
	  String description;
	@Override
	public String getTextField() {
		return textfield;
	}

	@Override
	public String getDescriptionField() {
		return description;
	}

}
