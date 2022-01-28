package com.toyota.tmna.lexusdrivers.core.search.dao;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.domain.Rewards;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;

public interface RewardsDao {

	public SearchResponse getRewardsById(String id) throws IOException;

	public boolean uploadRewards(Rewards rewards) throws JsonProcessingException;
	
	public boolean deleteRewards(String id) throws IOException;
	
	public SearchResponse getRewardsExpiredUntilDaysBefore(String numDays) throws IOException;
	
	public SearchResponse getRewardsAndEvents(String state, String category, String type,  String latitude, String longitude, String startIndex, String size) throws IOException;

	public List<String> getAllRewardCategories(String state) throws Exception;
	
	public List<String> getAllRewardStates() throws Exception;
	
	public SearchResponse getRelatedRewards(String category, String id,  String latitude, String longitude) throws IOException;
	
	public void init(String searchEndpointURL, String uploadDocEndpointURL);

}
