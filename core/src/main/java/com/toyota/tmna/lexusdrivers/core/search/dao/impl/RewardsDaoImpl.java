package com.toyota.tmna.lexusdrivers.core.search.dao.impl;

import java.io.IOException;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.SearchTemplate;
import com.toyota.tmna.lexusdrivers.core.search.dao.RewardsDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.Rewards;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;

@Component(service=RewardsDao.class, immediate = true)
public class RewardsDaoImpl extends SearchTemplate<Rewards> implements RewardsDao {

	private static final long serialVersionUID = -1460008840997180153L;

	@Override
	public SearchResponse getRewardsById(String id) throws IOException {
		return (SearchResponse) this.findByArticleId(id, Rewards.class);
	}

	@Override
	public boolean uploadRewards(Rewards rewards) throws JsonProcessingException {
		return this.saveOrUpdateDocument(rewards);
	}

	@Override
	public boolean deleteRewards(String id) throws IOException {
		return this.deleteById(id);
	}
	@Override
	public SearchResponse getRewardsExpiredUntilDaysBefore(String numDays) throws IOException{
		return this.getArticlesExpiredUntilDaysBefore(numDays, Rewards.class);
	}
	@Override
	public SearchResponse getRewardsAndEvents(String state, String category, String type,  String latitude, String longitude, String startIndex, String size) throws IOException {
		return this.getAllRewardsAndEvents(state, category, type, latitude, longitude, startIndex, size, Rewards.class);
	}
	
	@Override
	public List<String> getAllRewardCategories(String state) throws Exception{
		return super.getAllRewardsCategories(state);
	}
	
	@Override
	public List<String> getAllRewardStates() throws Exception{
		return super.getAllRewardsState();
	}
	@Override
	public SearchResponse getRelatedRewards(String category, String id,  String latitude, String longitude) throws IOException{
		return super.getRelatedRewards(category, id, latitude, longitude, Rewards.class);
	}

	@Override
	public void init(String searchEndpointURL, String uploadDocEndpointURL) {
		super.init(searchEndpointURL, uploadDocEndpointURL);

	}

}
