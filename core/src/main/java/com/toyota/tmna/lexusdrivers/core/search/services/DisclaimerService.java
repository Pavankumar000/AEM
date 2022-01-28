package com.toyota.tmna.lexusdrivers.core.search.services;

import com.toyota.tmna.lexusdrivers.core.search.domain.Disclaimer;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;

import java.io.Serializable;

public interface DisclaimerService extends Serializable {

	public SearchResponse getDisclaimerById(String disclaimerId);

	public boolean uploadDisclaimer(Disclaimer disclaimer);
	
	public boolean deleteDisclaimerById(String disclaimerId);
}
