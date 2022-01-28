package com.toyota.tmna.lexusdrivers.core.models;

import com.toyota.tmna.lexusdrivers.core.factory.HeaderFactoryEndPoints;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Node;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Source;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.dam.cfm.ContentFragment;
import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.FragmentTemplate;
import com.adobe.cq.dam.cfm.FragmentData;
import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.annotation.JsonGetter;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.resource.ValueMap;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ServiceResponse {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
    public static final String MODEL_TITLE = "ServiceResponse";
    @Inject @Self
    private Resource resource;
    private Optional<ContentFragment> contentFragment;
    @PostConstruct
    public void init() {
        contentFragment = Optional.ofNullable(resource.adaptTo(ContentFragment.class));
    }
    public String getModelTitle() {
        return contentFragment	
            .map(ContentFragment::getTemplate)
            .map(FragmentTemplate::getTitle)
            .orElse(StringUtils.EMPTY);
    }
    public String getEndPoint() {
        return contentFragment
            //.map(cf -> cf.getElement("end-point"))
            .map(cf -> cf.getElement("end-point"))
            .map(ContentElement::getContent)
            .orElse(StringUtils.EMPTY);
    }

    public String getRequestType() {
        return contentFragment
            //.map(cf -> cf.getElement("request-type"))
        	.map(cf -> cf.getElement("request-type"))
            .map(ContentElement::getContent)
            .orElse(StringUtils.EMPTY);
    }
    public String getResponseCode() {
        return contentFragment
            //.map(cf -> cf.getElement("response-code"))
            .map(cf -> cf.getElement("response-code"))
            .map(ContentElement::getContent)
            .orElse(StringUtils.EMPTY);
    }
    public String getMessage() {
        return contentFragment
            //.map(cf -> cf.getElement("message"))
            .map(cf -> cf.getElement("message"))
            .map(ContentElement::getContent)
            .orElse(StringUtils.EMPTY);
    }
    
    public String getPurpose() {
        return contentFragment
        	//.map(cf -> cf.getElement("purpose"))
            .map(cf -> cf.getElement("purpose"))
            .map(ContentElement::getContent)
            .orElse(StringUtils.EMPTY);
    }
}

