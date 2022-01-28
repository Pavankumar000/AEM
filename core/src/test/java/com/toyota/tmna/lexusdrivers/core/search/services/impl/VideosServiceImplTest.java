package com.toyota.tmna.lexusdrivers.core.search.services.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.services.VideosConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.search.dao.VideosDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.Videos;

@ExtendWith({MockitoExtension.class})
class VideosServiceImplTest
 {
	
	@InjectMocks
	VideosServiceImpl videosServiceImpl;
	@Mock
	VideosDao videosDao;
	@Mock
	VideosConfig config;
	 private Object JsonProcessingException;

	 @BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(config.videos_searchEndpointURL()).thenReturn("https://search-hcc-disclaimers-4zyhcch7dp6cs7y7ulonmvoybi.us-east-1.cloudsearch.amazonaws.com/");
		when(config.videos_uploadDocEndpointURL()).thenReturn("https://doc-hcc-disclaimers-4zyhcch7dp6cs7y7ulonmvoybi.us-east-1.cloudsearch.amazonaws.com/");
		videosServiceImpl.activate(config);
	}

	@Test
	void testGetVideosById() {
		assertNotNull(videosServiceImpl.getVideosById("test"));
	}

	 @Test
	 void testGetVideosByIdException() throws IOException {
		when(videosDao.getVideosById("test")).thenThrow(new IOException());
		videosServiceImpl.getVideosById("test");
	 }

	@Test
	void testUploadVideos() {
		Videos videos=new Videos();
		List<String> ids=new ArrayList<String>();
		List<String> title=new ArrayList<String>();
		List<String> heading=new ArrayList<String>();
		ids.add("testDisc");
		title.add("short desc");
		heading.add("ESCOMPARISON");
		videos.setId(ids);
		videos.setTitle(title);
		assertFalse(videosServiceImpl.uploadVideos(videos));
	}

	 @Test
	 void testUploadVideosException() throws JsonProcessingException {
		 Videos videos=new Videos();
		 List<String> ids=new ArrayList<String>();
		 List<String> title=new ArrayList<String>();
		 List<String> heading=new ArrayList<String>();
		 ids.add("testDisc");
		 title.add("short desc");
		 heading.add("ESCOMPARISON");
		 videos.setId(ids);
		 videos.setTitle(title);
		 when(videosDao.uploadVideos(videos)).thenThrow(new JsonProcessingException("") {});
		 assertFalse(videosServiceImpl.uploadVideos(videos));
	 }

	 @Test
	 void getCategories() {
		 List<String> test = videosServiceImpl.getCategories("model","year","vTopic");
		 assertNotNull(test);
	 }

	 @Test
	 void getCategoriesModelInt() {
		 List<String> test = videosServiceImpl.getCategories("model9","year", "vTopic");
		 assertNotNull(test);
	 }

	 @Test
	 void getCategoriesModelSmallH() {
		 List<String> test = videosServiceImpl.getCategories("modelh","year","vTopic");
		 assertNotNull(test);
	 }

	 @Test
	 void getCategoriesModelSmallC() {
		 List<String> test = videosServiceImpl.getCategories("modelc","year","vTopic");
		 assertNotNull(test);
	 }

	 @Test
	 void getCategoriesModelCapHL() {
		 List<String> test = videosServiceImpl.getCategories("modehl","year","vTopic");
		 assertNotNull(test);
	 }


	@Test
	void testDeleteVideosById() {
		assertFalse(videosServiceImpl.deleteVideosById("test"));
	}

	 @Test
	 void testDeleteVideosByIdException() throws IOException {
		when(videosDao.deleteVideos("test")).thenThrow(new IOException());
		 assertFalse(videosServiceImpl.deleteVideosById("test"));
	 }

	@Test
	void testVideos() {
		videosServiceImpl.getVideos("model","2020","test","vtype","tagtype", "1","10");
	}

	 @Test
	 void testVideosException() throws IOException {
		 when(videosDao.getVideos("modell","2020","test","vtype","tagtype", "1","10")).thenThrow(new IOException());
		videosServiceImpl.getVideos("model","2020","test","vtype","tagtype", "1","10");
	 }

	@Test
	 void getRelatedVideosTest() throws IOException {
		SearchResponse sr = new SearchResponse();
		List<Videos> vid = new ArrayList<>();
		Videos vidItem = new Videos();
		vid.add(vidItem);
		sr.setData(vid);
		when(videosDao.getRelatedVideos("id","modell","yr")).thenReturn(sr);
		when(videosDao.getVideosById("id")).thenReturn(sr);
		videosServiceImpl.getRelatedVideos("id", "model", "yr");
	}

	 @Test
	 void getRelatedVideosException() throws IOException {
		 SearchResponse sr = new SearchResponse();
		 List<Videos> vid = new ArrayList<>();
		 Videos vidItem = new Videos();
		 vid.add(vidItem);
		 sr.setData(vid);
		 when(videosDao.getRelatedVideos("id","modell","yr")).thenThrow(new IOException());
		 videosServiceImpl.getRelatedVideos("id", "model", "yr");
	 }

	 @Test
	 void getRelatedVideosTestWithTopicTags() throws IOException {
		 SearchResponse sr = new SearchResponse();
		 List<Videos> vid = new ArrayList<>();
		 List<String> topictags = new ArrayList<>();
		 List<String> ids = new ArrayList<>();
		 ids.add("id");
		 topictags.add("tag 1");
		 topictags.add("tag 2");
		 Videos vidItem = new Videos();
		 vidItem.setTopic_tag(topictags);
		 vidItem.setId(ids);
		 vid.add(vidItem);
		 sr.setData(vid);
		 when(videosDao.getRelatedVideos("id","modell","yr")).thenReturn(sr);
		 when(videosDao.getVideosById("id")).thenReturn(sr);
		 videosServiceImpl.getRelatedVideos("id", "model", "yr");
	 }

	 @Test
	 void getRelatedVideosTestWithTopicTagsAll() throws IOException {
		 SearchResponse sr = new SearchResponse();
		 List<Videos> vid = new ArrayList<>();
		 List<String> topictags = new ArrayList<>();
		 List<String> ids = new ArrayList<>();
		 ids.add("id");
		 topictags.add("all");
		 topictags.add("all");
		 Videos vidItem = new Videos();
		 vidItem.setTopic_tag(topictags);
		 vidItem.setId(ids);
		 vid.add(vidItem);
		 sr.setData(vid);
		 when(videosDao.getRelatedVideos("id","modell","yr")).thenReturn(sr);
		 SearchResponse sr2 = new SearchResponse();
		 List<Videos> vid2 = new ArrayList<>();
		 List<String> topictags2 = new ArrayList<>();
		 List<String> ids2 = new ArrayList<>();
		 ids2.add("id2");
		 topictags2.add("all");
		 topictags2.add("all");
		 Videos vidItem2 = new Videos();
		 vidItem2.setTopic_tag(topictags2);
		 vidItem2.setId(ids2);
		 vid2.add(vidItem2);
		 sr2.setData(vid2);
		 when(videosDao.getVideosById("id")).thenReturn(sr2);
		 videosServiceImpl.getRelatedVideos("id", "model", "yr");
	 }

	 @Test
	 void getRelatedVideosTestWithTopicTagsNoPrecedence() throws IOException {
		 SearchResponse sr = new SearchResponse();
		 List<Videos> vid = new ArrayList<>();
		 List<String> topictags = new ArrayList<>();
		 List<String> ids = new ArrayList<>();
		 ids.add("id");
		 topictags.add("tag 1");
		 topictags.add("tag 2");
		 Videos vidItem = new Videos();
		 vidItem.setTopic_tag(topictags);
		 vidItem.setId(ids);
		 vid.add(vidItem);
		 sr.setData(vid);
		 when(videosDao.getRelatedVideos("id","modell","yr")).thenReturn(sr);
		 SearchResponse sr2 = new SearchResponse();
		 List<Videos> vid2 = new ArrayList<>();
		 List<String> topictags2 = new ArrayList<>();
		 List<String> ids2 = new ArrayList<>();
		 ids2.add("id2");
		 topictags2.add("tag 1");
		 topictags2.add("tag 1");
		 Videos vidItem2 = new Videos();
		 vidItem2.setTopic_tag(topictags2);
		 vidItem2.setId(ids2);
		 vid2.add(vidItem2);
		 sr2.setData(vid2);
		 when(videosDao.getVideosById("id")).thenReturn(sr2);
		 videosServiceImpl.getRelatedVideos("id", "model", "yr");
	 }

	@Test
	 void getVideosByIdTest() throws IOException {
		SearchResponse sr = new SearchResponse();
		List<Videos> vid = new ArrayList<>();
		Videos vidItem = new Videos();
		List<String> tags =  new ArrayList<String>();
		tags.add("tag1");
		tags.add("tag2");
		vidItem.setTopic_tag(tags);
		vid.add(vidItem);
		sr.setData(vid);
		when(videosDao.getVideosById("id")).thenReturn(sr);
		videosServiceImpl.getVideosById("id");
	}
   
}
