package com.toyota.tmna.lexusdrivers.core.models;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.dam.cfm.ContentFragment;
import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.FragmentData;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AppConfig {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
    @Inject @Self
    private Resource resource;
    private Optional<ContentFragment> contentFragment;
    @PostConstruct
    public void init() {
        contentFragment = Optional.ofNullable(resource.adaptTo(ContentFragment.class));
    }

    private List<ServiceResponse> serviceResponses = new ArrayList<>();
    private List<String> legacyModelFilter = new ArrayList<>();
    private List<String> fuelGrade = new ArrayList<>();
    private List<String> myFilter = new ArrayList<>();
    private List<String> ldNavSearch = new ArrayList<>();
    private List<String> fsportFilter = new ArrayList<>();
    
	public List<ServiceResponse> getServiceResponses() {
		if(contentFragment != null) {
			serviceResponses = Arrays.asList((String[]) contentFragment.map(cf -> cf.getElement("service-responses"))
					.map(ContentElement::getValue).map(FragmentData::getValue).orElse(new String[0]))
					.stream()
					.map(serviceResponsePath -> resource.getResourceResolver().resolve(serviceResponsePath))
					.filter(Objects::nonNull)
					.map(srResource -> srResource.adaptTo(ServiceResponse.class))
					.collect(Collectors.toList());
		}
		return new ArrayList<>(serviceResponses);
	}
	
	public List<String> getLegacyModelFilter() {
		if(contentFragment != null) {
			legacyModelFilter = Arrays.asList((String[]) contentFragment.map(cf -> cf.getElement("legacy-model-filter"))
					.map(ContentElement::getValue).map(FragmentData::getValue).orElse(new String[0]));
		}
		return  new ArrayList<>(legacyModelFilter);
	}
	
	public List<String> getFuelGrades() {
		if(contentFragment != null) {
			fuelGrade = Arrays.asList((String[]) contentFragment.map(cf -> cf.getElement("fuel-grades"))
					.map(ContentElement::getValue).map(FragmentData::getValue).orElse(new String[0]));		
		}
		return new ArrayList<>(fuelGrade);
	}
	
	public List<String> getMyFilter() {
		if(contentFragment != null) {
			myFilter = Arrays.asList((String[]) contentFragment.map(cf -> cf.getElement("my-filter"))
					.map(ContentElement::getValue).map(FragmentData::getValue).orElse(new String[0]));		
		}
		return new ArrayList<>(myFilter);
	}
	
	public List<String> getLdNavSearch() {
		if(contentFragment != null) {
			ldNavSearch = Arrays.asList((String[]) contentFragment.map(cf -> cf.getElement("ld-nav-search"))
					.map(ContentElement::getValue).map(FragmentData::getValue).orElse(new String[0]));		
		}
		return new ArrayList<>(ldNavSearch);
	}
	
	public List<String> getFsportFilter() {
		if(contentFragment != null) {
			fsportFilter = Arrays.asList((String[]) contentFragment.map(cf -> cf.getElement("fsport-filter"))
					.map(ContentElement::getValue).map(FragmentData::getValue).orElse(new String[0]));		
		}
		return new ArrayList<>(fsportFilter);
	}
}