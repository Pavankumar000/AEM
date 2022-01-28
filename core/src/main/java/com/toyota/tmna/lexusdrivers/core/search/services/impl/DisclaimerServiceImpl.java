package com.toyota.tmna.lexusdrivers.core.search.services.impl;

import java.io.IOException;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.dao.DisclaimerDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.Disclaimer;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.services.DisclaimerService;
import com.toyota.tmna.lexusdrivers.core.search.services.DisclaimerConfigs;


@Component(service=DisclaimerService.class, immediate = true)
@Designate(ocd=DisclaimerConfigs.class)
public class DisclaimerServiceImpl implements DisclaimerService {
	private static final long serialVersionUID = 1L;

	private String disclaimerSearchEndpointURL;
	private String disclaimerUploadDocEndpointURL;

	@Reference
	private transient DisclaimerDao disclaimerDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(DisclaimerServiceImpl.class);


	@Override
	public SearchResponse getDisclaimerById(String disclaimerId) {
		try {
			return disclaimerDao.getDisclaimerById(disclaimerId);
		} catch (IOException e) {
			LOGGER.error("Error while retrieving disclaimer::"+e.getMessage());
		}
		return null;
	}

	@Override
	public boolean uploadDisclaimer(Disclaimer disclaimer) {
		try {
			return disclaimerDao.uploadDisclaimer(disclaimer);
		} catch (JsonProcessingException e) {
			LOGGER.error("Error while uploading disclaimer::"+e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteDisclaimerById(String disclaimerId) {
		try {
			return disclaimerDao.deleteDisclaimer(disclaimerId);
		} catch (IOException e) {
			LOGGER.error("Error while deleting disclaimer :: "+e.getMessage());
		}
		return false;
	}
	
	@Activate
	public void activate(DisclaimerConfigs config) throws IOException {
		disclaimerSearchEndpointURL = config.disclaimersSearchEndpointURL();
		disclaimerUploadDocEndpointURL= config.disclaimersUploadDocEndpointURL();
		disclaimerDao.init(disclaimerSearchEndpointURL, disclaimerUploadDocEndpointURL);
	}

	
}
