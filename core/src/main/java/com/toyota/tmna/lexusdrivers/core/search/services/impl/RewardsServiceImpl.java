package com.toyota.tmna.lexusdrivers.core.search.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.toyota.tmna.lexusdrivers.core.search.dao.RewardsDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.Rewards;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.services.RewardsConfigs;
import com.toyota.tmna.lexusdrivers.core.search.services.RewardsService;
import com.toyota.tmna.lexusdrivers.core.search.services.WaldoService;
import com.toyota.tmna.lexusdrivers.core.util.SearchConstants;

@Component(service=RewardsService.class, immediate = true)
@Designate(ocd= RewardsConfigs.class)
public class RewardsServiceImpl implements RewardsService {

	private static final long serialVersionUID = 47704124791976357L;
	private String rewardsSearchEndpointURL;
	private String rewardsUploadDocEndpointURL;

	@Reference
	private transient RewardsDao rewardsDao;
	@Reference
    private transient WaldoService waldoService;
	private static final Logger LOGGER = LoggerFactory.getLogger(RewardsServiceImpl.class);

	@Override
	public SearchResponse getRewardsById(String rewardsId) {
		try {
			return rewardsDao.getRewardsById(rewardsId);
		} catch (IOException e) {
			LOGGER.error("Error while retrieving rewards::"+e.getMessage());
		}
		return null;
	}

	@Override
	public boolean uploadRewards(Rewards rewards) {
		try {
			return rewardsDao.uploadRewards(rewards);
		} catch (JsonProcessingException e) {
			LOGGER.error("Error while uploading rewards::"+e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteRewardsById(String rewardsId) {
		try {
			return rewardsDao.deleteRewards(rewardsId);
		} catch (IOException e) {
			LOGGER.error("Error while deleting rewards :: "+e.getMessage());
		}
		return false;
	}
	@Override
	public SearchResponse getRewardsExpiredUntilDaysBefore(String numDays) {
		try {
			return rewardsDao.getRewardsExpiredUntilDaysBefore(numDays);
		} catch (IOException e) {
			LOGGER.error("Error while retrieving rewards which are expiring :: "+e.getMessage());

		}
		return null;
	}
	@Override
	public SearchResponse getRewardsAndEvents(String state, String category, String type,  String zip, String startIndex, String size){
		try {
			String latitude = StringUtils.EMPTY;
			String longitude = StringUtils.EMPTY;
			if(StringUtils.isNotBlank(zip)) {
				String latLan = waldoService.getLatlang(zip);
				JsonElement jsonElement = new JsonParser().parse(latLan);
				latitude = jsonElement.getAsJsonObject().get(SearchConstants.LATITUDE).getAsString();
				longitude = jsonElement.getAsJsonObject().get(SearchConstants.LONGITUDE).getAsString();
				if(StringUtils.isBlank(state) && !"00000".equalsIgnoreCase(zip))
					state = waldoService.getState(zip);
			}
			return rewardsDao.getRewardsAndEvents(state, category, type, latitude, longitude, startIndex, size);
		} catch (IOException e) {
			LOGGER.error("Error while retrieving rewards:: "+e.getMessage());
		}
		return null;
	}
	@Override
	public List<String> getAllRewardCategories(String state){
		try {
			return rewardsDao.getAllRewardCategories(state);
		} catch (Exception e) {
			LOGGER.error("Error while retrieving rewards categories:: "+e.getMessage());
		}
		return null;
	}
	@Override
	public List<String> getAllRewardStates(){
		try {
			return rewardsDao.getAllRewardStates();
		} catch (Exception e) {
			LOGGER.error("Error while retrieving rewards states:: "+e.getMessage());
		}
		return null;
	}

	@Override
	public SearchResponse getRelatedRewards(String category, String id,  String zip){
		try {
			String latitude = StringUtils.EMPTY;
			String longitude = StringUtils.EMPTY;
			if(StringUtils.isNotBlank(zip)) {
				String latLan = waldoService.getLatlang(zip);
				JsonElement jsonElement = new JsonParser().parse(latLan);
				latitude = jsonElement.getAsJsonObject().get(SearchConstants.LATITUDE).getAsString();
				longitude = jsonElement.getAsJsonObject().get(SearchConstants.LONGITUDE).getAsString();
			}
			SearchResponse sr = rewardsDao.getRelatedRewards(category, id, latitude, longitude);
			//Below logic to pull rewards which are in proximity of 1000 miles.
			SearchResponse relatedRewardsResponse = new SearchResponse();
			if(sr != null && sr.getTotal_records() > 0) {
				List<Rewards> rewardsList = (List<Rewards>)sr.getData();
				List<Rewards> relatedRewardsList = new ArrayList<Rewards>();
				for(Rewards r: rewardsList) {
					if(r.getDistance() <= SearchConstants.PROXIMITY) {
						relatedRewardsList.add(r);
					}
				}
				relatedRewardsResponse.setData(relatedRewardsList);
				relatedRewardsResponse.setTotal_records((long) relatedRewardsList.size());
				return relatedRewardsResponse;
			}
		} catch (IOException e) {
			LOGGER.error("Error while retrieving related rewards:: "+e.getMessage());
		}
		return null;
	}

	@Activate
	public void activate(RewardsConfigs config) throws IOException {
		rewardsSearchEndpointURL = config.rewardsSearchEndpointURL();
		rewardsUploadDocEndpointURL= config.rewardsUploadDocEndpointURL();
		rewardsDao.init(rewardsSearchEndpointURL, rewardsUploadDocEndpointURL);
	}

}
