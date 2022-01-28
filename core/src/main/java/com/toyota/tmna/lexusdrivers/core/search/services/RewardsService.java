package com.toyota.tmna.lexusdrivers.core.search.services;

import java.io.Serializable;
import java.util.List;

import com.toyota.tmna.lexusdrivers.core.search.domain.Rewards;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;

public interface RewardsService extends Serializable {

	public SearchResponse getRewardsById(String rewardsId);

	public boolean uploadRewards(Rewards rewards);
	
	public boolean deleteRewardsById(String rewardsId);
	
	public SearchResponse getRewardsExpiredUntilDaysBefore(String numDays);
	
	public SearchResponse getRewardsAndEvents(String state, String category, String type,  String zip, String startIndex, String size);
	
	public List<String> getAllRewardCategories(String state);
	
	public List<String> getAllRewardStates();
	
	public SearchResponse getRelatedRewards(String category, String id, String zip);
}
