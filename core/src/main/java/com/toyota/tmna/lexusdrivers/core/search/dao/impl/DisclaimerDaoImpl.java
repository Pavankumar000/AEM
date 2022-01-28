package com.toyota.tmna.lexusdrivers.core.search.dao.impl;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.SearchTemplate;
import com.toyota.tmna.lexusdrivers.core.search.dao.DisclaimerDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.Disclaimer;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;


@Component(service=DisclaimerDao.class, immediate = true)
public class DisclaimerDaoImpl extends SearchTemplate<Disclaimer> implements DisclaimerDao {

	private static final long serialVersionUID = 261258823498211974L;


	@Override
	public SearchResponse getDisclaimerById(String id) throws IOException {
		return (SearchResponse) this.findById(id, Disclaimer.class);
	}

	@Override
	public boolean uploadDisclaimer(Disclaimer disclaimer) throws JsonProcessingException {
		return this.saveOrUpdateDocument(disclaimer);

	}
	
	@Override
	public boolean deleteDisclaimer(String id) throws IOException {
		return this.deleteById(id);
	}
	
	@Override
	public void init(String searchEndpointURL, String uploadDocEndpointURL) {
		super.init(searchEndpointURL, uploadDocEndpointURL);
	}
	
	
}
