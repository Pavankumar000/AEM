package com.toyota.tmna.lexusdrivers.core.search.services.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.services.StoriesConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.search.dao.DisclaimerDao;
import com.toyota.tmna.lexusdrivers.core.search.dao.RewardsDao;
import com.toyota.tmna.lexusdrivers.core.search.dao.StoriesDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.Disclaimer;
import com.toyota.tmna.lexusdrivers.core.search.domain.Rewards;
import com.toyota.tmna.lexusdrivers.core.search.domain.Stories;

@ExtendWith({MockitoExtension.class})
class StoriesServiceImplTest
 {
	
	@InjectMocks
	StoriesServiceImpl storiesServiceImpl;
	@Mock
	StoriesDao storiesDao;
	@Mock
	StoriesConfig config;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(config.stories_searchEndpointURL()).thenReturn("https://search-hcc-disclaimers-4zyhcch7dp6cs7y7ulonmvoybi.us-east-1.cloudsearch.amazonaws.com/");
		when(config.stories_uploadDocEndpointURL()).thenReturn("https://doc-hcc-disclaimers-4zyhcch7dp6cs7y7ulonmvoybi.us-east-1.cloudsearch.amazonaws.com/");
		storiesServiceImpl.activate(config);
	}

	@Test
	void testGetStoriesById() {
		assertNull(storiesServiceImpl.getStoriesById("test"));
	}

	@Test
	void testUploadStories() {
		Stories stories=new Stories();
		List<String> ids=new ArrayList<String>();
		List<String> title=new ArrayList<String>();
		List<String> heading=new ArrayList<String>();
		ids.add("testDisc");
		title.add("short desc");
		heading.add("ESCOMPARISON");
		stories.setId(ids);
		stories.setTitle(title);
		assertFalse(storiesServiceImpl.uploadStories(stories));
	}

	 @Test
	 void testUploadStoriesException() throws JsonProcessingException {
		 Stories stories=new Stories();
		 List<String> ids=new ArrayList<String>();
		 List<String> title=new ArrayList<String>();
		 List<String> heading=new ArrayList<String>();
		 ids.add("testDisc");
		 title.add("short desc");
		 heading.add("ESCOMPARISON");
		 stories.setId(ids);
		 stories.setTitle(title);
		 when(storiesDao.uploadStories(stories)).thenThrow(new JsonProcessingException(""){});
		 assertFalse(storiesServiceImpl.uploadStories(stories));
	 }

	@Test
	void testDeleteStoriesById() {
		assertFalse(storiesServiceImpl.deleteStoriesById("test"));
	}

	 @Test
	 void testDeleteStoriesByIdException() throws IOException {
		when(storiesDao.deleteStories("test")).thenThrow(new IOException());
		assertFalse(storiesServiceImpl.deleteStoriesById("test"));
	 }

	 @Test
	 void getAllStoriesOrByCategoryException() throws IOException {
		 when(storiesDao.getAllStoriesOrByCategory("1","10","test")).thenThrow(new IOException());
		 storiesServiceImpl.getAllStoriesOrByCategory("1","10","test");
	 }

	@Test
	void testGetAllStoriesOrByCategory() {
		storiesServiceImpl.getAllStoriesOrByCategory("1","10","test");
	}
	@Test
	void testGetRelatedStories() {
		storiesServiceImpl.getRelatedStories("test","story1");
	}
	@Test
	void testGetRelatedStoriesException() throws IOException {
		when(storiesDao.getRelatedStories("test","story1")).thenThrow(new IOException());
		storiesServiceImpl.getRelatedStories("test","story1");
	}

	 @Test
	 void testGetRelatedStoriesData() throws IOException {
		 SearchResponse sr = new SearchResponse();
		 List<Stories> storiesList = new ArrayList<>();
		 Stories stories = new Stories();
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
		 storiesList.add(stories);
		 sr.setData(storiesList);
		when(storiesDao.getRelatedStories("test","story1")).thenReturn(sr);
		storiesServiceImpl.getRelatedStories("test","story1");
	 }

	 @Test
	 void testGetRelatedStoriesDataCount() throws IOException {
		 SearchResponse sr = new SearchResponse();
		 List<Stories> storiesList = new ArrayList<>();
		 Stories story = new Stories();
		 story.setCategory_count(1L);
		 storiesList.add(story);
		 sr.setData(storiesList);
		 when(storiesDao.getRelatedStories("test","story1")).thenReturn(sr);
		 storiesServiceImpl.getRelatedStories("test","story1");
	 }

	@Test
	 void getStoriesByIdException() throws IOException {
		when(storiesDao.getStoriesById("id")).thenThrow(new IOException());
		storiesServiceImpl.getStoriesById("id");
	}
   
}
