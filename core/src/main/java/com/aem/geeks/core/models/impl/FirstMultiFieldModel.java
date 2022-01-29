package com.aem.geeks.core.models.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables =  Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class FirstMultiFieldModel {
	@Inject
	private String heading;

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}
	
	@Inject
	private List<SecondMultiFieldModel> secondMF;

	public List<SecondMultiFieldModel> getSecondMF() {
		return secondMF;
	}

	public void setSecondMF(List<SecondMultiFieldModel> secondMF) {
		this.secondMF = secondMF;
	}

}
