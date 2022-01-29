package com.aem.geeks.core.models.impl;


import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL )
public class MultiFieldModel {
	  private static final Logger LOG = LoggerFactory.getLogger(AuthorImpl.class);
	@Inject
	private List<FirstMultiFieldModel>firstMF;

	public List<FirstMultiFieldModel> getFirstMF() {
		return firstMF;
	}

	public void setFirstMF(List<FirstMultiFieldModel> firstMF) {
		this.firstMF = firstMF;
	}
	
}
