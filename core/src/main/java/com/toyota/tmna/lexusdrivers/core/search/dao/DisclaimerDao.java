package com.toyota.tmna.lexusdrivers.core.search.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.domain.Disclaimer;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;

public interface DisclaimerDao {

	public SearchResponse getDisclaimerById(String id) throws IOException;

	public boolean uploadDisclaimer(Disclaimer disclaimer) throws JsonProcessingException;
	
	public boolean deleteDisclaimer(String id) throws IOException;

	public void init(String searchEndpointURL, String uploadDocEndpointURL);

}
