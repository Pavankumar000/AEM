package com.toyota.tmna.lexusdrivers.core.search.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomainClient;
import com.toyota.tmna.lexusdrivers.core.search.domain.Stories;

@ExtendWith(MockitoExtension.class)
class StoriesDaoImplTest {

	
	@InjectMocks
	StoriesDaoImpl storiesDaoImpl;
	
	  @Mock 
	  AmazonCloudSearchDomainClient amazonCloudSearchUploadDomainClient;
	 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		storiesDaoImpl.init("https://search-hcc-stories-houqmdkknumxecjd7vtlpf6nja.us-east-1.cloudsearch.amazonaws.com/", "https://doc-hcc-stories-houqmdkknumxecjd7vtlpf6nja.us-east-1.cloudsearch.amazonaws.com/");
	}
	@Test
	void testgetStoriesById() throws Exception {
		storiesDaoImpl.getStoriesById("123");
	}
	@Test
	void testuploadStories() throws Exception{
		Stories stories=new Stories();
		List<String> ids=new ArrayList<String>();
		List<String> dates=new ArrayList<String>();
		List<String> desc=new ArrayList<String>();
		List<String> latLanList=new ArrayList<String>();
		latLanList.add("38.29269027709961,-122.2874984741211");
		ids.add("testDisc");
		desc.add("short desc");
		Date date = new Date();
		dates.add("2000-01-18T00:00:00Z");
		stories.setId(ids);
		stories.setTitle(ids);
		stories.setSection_type(ids);
		stories.setDescription(ids);
		stories.setDesktop_hero_image(ids);
		stories.setDesktop_thumbnail_image(ids);
		stories.setVideo_url(ids);
		stories.setMobile_thumbnail_image(ids);
		stories.setMobile_hero_image(ids);
		stories.setTablet_thumbnail_image(ids);
		stories.setTablet_hero_image(ids);
		stories.setSecondary_description(ids);
		stories.setLong_description(ids);
		stories.setRotational_banner_section(ids);
		stories.setClass_name(ids);
		stories.setSecondary_description(ids);
		stories.setRelated_section_title(ids);
		stories.setPartner_name(ids);
		stories.setCategory(ids);
		stories.setShort_description(ids);
		stories.setPublish_date(dates);
		stories.setEffective_start_date(dates);
		stories.setEffective_end_date(dates);
		stories.setIs_featured(ids);
		stories.setGlobal_featured(ids);
		stories.setDisplay_start_date(dates);
		stories.setMeta_tags(ids);
		stories.setSeo_title(ids);
		stories.setSeo_description(ids);
		stories.setSeo_key(ids);
		storiesDaoImpl.uploadStories(stories);
		
	}
	@Test
	void testdeleteById() throws Exception{
		  storiesDaoImpl.deleteStories("testDisc");
	}
	@Test
	void testGetAllStoriesOrByCategory() throws Exception {
		storiesDaoImpl.getAllStoriesOrByCategory("1","10","test");
	}
	/*
	@Test
	void testGetRelatedStories() throws Exception {
		storiesDaoImpl.getRelatedStories("test","story1");
	}

	 */
	@Test
	void getStoriesCategoryCountTest() throws Exception {
		storiesDaoImpl.getStoriesCategoryCount("category");
	}

}
