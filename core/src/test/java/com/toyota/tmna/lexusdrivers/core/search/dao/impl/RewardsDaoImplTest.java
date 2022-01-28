package com.toyota.tmna.lexusdrivers.core.search.dao.impl;

import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomainClient;
import com.toyota.tmna.lexusdrivers.core.search.services.WaldoService;
import com.toyota.tmna.lexusdrivers.core.search.domain.Rewards;

@ExtendWith(MockitoExtension.class)
class RewardsDaoImplTest {

	
	@InjectMocks
	RewardsDaoImpl rewardsDaoImpl;
	
	@Mock
	WaldoService waldoService;
	
	  @Mock 
	  AmazonCloudSearchDomainClient amazonCloudSearchUploadDomainClient;
	 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		rewardsDaoImpl.init("https://search-hcc-rewardss-w6dxnfz27yltgqldnc7jq2ukde.us-east-1.cloudsearch.amazonaws.com/", "https://doc-hcc-rewardss-w6dxnfz27yltgqldnc7jq2ukde.us-east-1.cloudsearch.amazonaws.com/");

	}
	@Test
	void testgetRewardsById() throws Exception {
		rewardsDaoImpl.getRewardsById("123");
	}
	@Test
	void testuploadRewards() throws Exception{
		Rewards rewards=new Rewards();
		List<String> ids=new ArrayList<String>();
		List<String> dates=new ArrayList<String>();
		List<String> desc=new ArrayList<String>();
		List<String> latLanList=new ArrayList<String>();
		latLanList.add("38.29269027709961,-122.2874984741211");
		ids.add("testDisc");
		desc.add("short desc");
		Date date = new Date();
		dates.add("2000-01-18T00:00:00Z");
		rewards.setId(ids);
		rewards.setTitle(ids);
		rewards.setRotational_banner_section(ids);
		rewards.setClaim_title(ids);
		rewards.setClaim_cta(ids);
		rewards.setClaim_msg(ids);
		rewards.setClass_name(ids);
		rewards.setClaim_link(ids);
		rewards.setClaims_icon(ids);
		rewards.setBenefit_type(ids);
		rewards.setSecondary_description(ids);
		rewards.setRelated_section_title(ids);
		rewards.setHeading(ids);
		rewards.setCategory_type(ids);
		rewards.setCategory_list(ids);
		rewards.setPartner_name(ids);
		rewards.setPartner_logo(ids);
		rewards.setShort_description(ids);
		rewards.setDetail_description(ids);
		rewards.setDesktop_hero_img(ids);
		rewards.setDesktop_thumb_img(ids);
		rewards.setMobile_hero_img(ids);
		rewards.setMobile_thumb_img(ids);
		rewards.setTab_hero_img(ids);
		rewards.setTab_thumb_img(ids);
		rewards.setDetail_description(desc);
		rewards.setThumbnail_video(ids);
		rewards.setAlt_text(ids);
		rewards.setPublish_date(dates);
		rewards.setEffective_start_date(dates);
		rewards.setEffective_end_date(dates);
		rewards.setIs_featured(ids);
		rewards.setGlobal_featured(ids);
		rewards.setDisplay_start_date(dates);
		rewards.setMeta_tags(ids);
		rewards.setSeo_title(ids);
		rewards.setSeo_description(ids);
		rewards.setSeo_key(ids);
		rewards.setAddress_line_one(ids);
		rewards.setAddress_line_two(ids);
		rewards.setCity(ids);
		rewards.setState(ids);
		rewards.setZip_code(ids);
		rewards.setPhone(ids);
		rewards.setWebsite(ids);
		rewards.setRewards_redemption(ids);
		rewards.setLat_lan(latLanList);
		rewards.setEmail(ids);
		rewardsDaoImpl.uploadRewards(rewards);
		
	}
	@Test
	void testdeleteById() throws Exception{
		  rewardsDaoImpl.deleteRewards("testDisc");
	}
	@Test 
	void testGetRewardsExpiredUntilDaysBefore() throws Exception{
		  rewardsDaoImpl.getRewardsExpiredUntilDaysBefore("10");
	}
	@Test
	void testGetAllRewardCategories() throws Exception{
		rewardsDaoImpl.getAllRewardCategories("CA");
	}
	@Test
	void testGetAllCategories() throws Exception{
		rewardsDaoImpl.getAllRewardCategories("CA");
	}

	@Test
	void getAllRewardsState() throws Exception{
		rewardsDaoImpl.getAllRewardsState();
	}

	@Test
	void getRelatedRewards() throws IOException {
		rewardsDaoImpl.getRelatedRewards("category", "id", "-96.88","33.12");
	}

	@Test
	void getAllRewardStates() throws Exception {
		rewardsDaoImpl.getAllRewardStates();
	}

	@Test
	void getRewardsAndEvents() throws IOException {
		rewardsDaoImpl.getRewardsAndEvents("state","category","type","-96.88", "33.12", "2", "10");
	}

	@Test
	void getRewardsAndEventsBlankState() throws IOException {
		rewardsDaoImpl.getRewardsAndEvents("","category","type","-96.88", "33.12", "2", "10");
	}

}
