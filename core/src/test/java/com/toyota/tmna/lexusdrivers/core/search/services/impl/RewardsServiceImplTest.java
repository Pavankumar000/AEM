package com.toyota.tmna.lexusdrivers.core.search.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.services.RewardsConfigs;
import com.toyota.tmna.lexusdrivers.core.search.services.WaldoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.search.dao.RewardsDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.Rewards;

@ExtendWith({MockitoExtension.class})
class RewardsServiceImplTest {
	
	@InjectMocks
	RewardsServiceImpl rewardsServiceImpl;
	@Mock
	RewardsDao rewardsDao;
	@Mock
	RewardsConfigs config;
	@Mock
	WaldoService waldoService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(config.rewardsSearchEndpointURL()).thenReturn("https://search-hcc-disclaimers-4zyhcch7dp6cs7y7ulonmvoybi.us-east-1.cloudsearch.amazonaws.com/");
		when(config.rewardsUploadDocEndpointURL()).thenReturn("https://doc-hcc-disclaimers-4zyhcch7dp6cs7y7ulonmvoybi.us-east-1.cloudsearch.amazonaws.com/");
		rewardsServiceImpl.activate(config);
	}

	@Test
	void testGetRewardsById() {
		assertNull(rewardsServiceImpl.getRewardsById("test"));
	}

	@Test
	void testGetRewardsByIdException() throws IOException {
		when(rewardsDao.getRewardsById("test")).thenThrow(new IOException());
		assertNull(rewardsServiceImpl.getRewardsById("test"));
	}

	@Test
	void testUploadRewards() {
		Rewards rewards=new Rewards();
		List<String> ids=new ArrayList<String>();
		List<String> title=new ArrayList<String>();
		List<String> heading=new ArrayList<String>();
		ids.add("testDisc");
		title.add("short desc");
		heading.add("ESCOMPARISON");
		rewards.setId(ids);
		rewards.setTitle(title);
		assertFalse(rewardsServiceImpl.uploadRewards(rewards));
	}

	@Test
	void testUploadRewardsException() throws JsonProcessingException {
		Rewards rewards=new Rewards();
		List<String> ids=new ArrayList<String>();
		List<String> title=new ArrayList<String>();
		List<String> heading=new ArrayList<String>();
		ids.add("testDisc");
		title.add("short desc");
		heading.add("ESCOMPARISON");
		rewards.setId(ids);
		rewards.setTitle(title);
		when(rewardsDao.uploadRewards(rewards)).thenThrow(new JsonProcessingException(""){});
		assertFalse(rewardsServiceImpl.uploadRewards(rewards));
	}

	@Test
	void testDeleteRewardsById() {
		assertFalse(rewardsServiceImpl.deleteRewardsById("test"));
	}
	@Test
	void testDeleteRewardsByIdException() throws IOException {
		when(rewardsDao.deleteRewards("test")).thenThrow(new IOException());
		assertFalse(rewardsServiceImpl.deleteRewardsById("test"));
	}
	@Test
	void testGetRewardsExpiredUntilDaysBefore() {

		assertNull(rewardsServiceImpl.getRewardsExpiredUntilDaysBefore("10"));
	}
	@Test
	void testGetRewardsExpiredUntilDaysBeforeException() throws IOException {
		when(rewardsDao.getRewardsExpiredUntilDaysBefore("10")).thenThrow(new IOException());
		assertNull(rewardsServiceImpl.getRewardsExpiredUntilDaysBefore("10"));
	}
	@Test
	void testGetRewardsAndEvents() {

		assertNull(rewardsServiceImpl.getRewardsAndEvents("TN","Gold","test","","1","10"));
	}

	@Test
	void testGetRewardsAndEventsLatLang() throws IOException {
		when(waldoService.getLatlang("zip")).thenReturn("{latitude: 33.12, longitude: -96.88}");
		assertNull(rewardsServiceImpl.getRewardsAndEvents("TN","Gold","test","zip","1","10"));
	}

	@Test
	void testGetRewardsAndEventsLatLangStateBlank() throws IOException {
		when(waldoService.getLatlang("zip")).thenReturn("{latitude: 33.12, longitude: -96.88}");
		assertNull(rewardsServiceImpl.getRewardsAndEvents("","Gold","test","zip","1","10"));
	}

	@Test
	void testGetRewardsAndEventsLatLangZipZero() throws IOException {
		when(waldoService.getLatlang("0")).thenReturn("{latitude: 33.12, longitude: -96.88}");
		assertNull(rewardsServiceImpl.getRewardsAndEvents("state","Gold","test","0","1","10"));
	}


	@Test
	void testGetRewardsAndEventsException() throws IOException {
		when(waldoService.getLatlang("zip")).thenThrow(new IOException());
		assertNull(rewardsServiceImpl.getRewardsAndEvents("TN","Gold","test","zip", "1","10"));
	}
	@Test
	void testGetRelatedRewards() throws IOException {
		when(waldoService.getLatlang("zip")).thenReturn("{latitude: 33.12, longitude: -96.88}");
		assertNull(rewardsServiceImpl.getRelatedRewards("TN","Gold","zip"));
	}

	@Test
	void testGetRelatedRewardsBlankZip() throws IOException {
		assertNull(rewardsServiceImpl.getRelatedRewards("TN","Gold",""));
	}

	@Test
	void testGetRelatedRewardsException() throws IOException {
		when(waldoService.getLatlang("zip")).thenThrow(new IOException());
		//when(rewardsDao.getRelatedRewards("TN","Gold","-96.88","33.12")).thenThrow(new IOException());
		assertNull(rewardsServiceImpl.getRelatedRewards("TN","Gold","zip"));
	}

	@Test
	void getAllRewardStatesTest() {
		rewardsServiceImpl.getAllRewardStates();
		rewardsServiceImpl.getAllRewardCategories("state");
	}
   
}
