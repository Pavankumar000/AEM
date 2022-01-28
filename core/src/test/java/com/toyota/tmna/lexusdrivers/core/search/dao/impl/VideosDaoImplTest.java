package com.toyota.tmna.lexusdrivers.core.search.dao.impl;

import java.io.IOException;
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
import com.toyota.tmna.lexusdrivers.core.search.domain.Videos;

@ExtendWith(MockitoExtension.class)
class VideosDaoImplTest {

	
	@InjectMocks
	VideosDaoImpl videosDaoImpl;
	
	  @Mock 
	  AmazonCloudSearchDomainClient amazonCloudSearchUploadDomainClient;
	 

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		videosDaoImpl.init("https://search-hcc-videos-hygoh4bwcgbyxwpn4ktatupg7m.us-east-1.cloudsearch.amazonaws.com/", "https://doc-hcc-videos-hygoh4bwcgbyxwpn4ktatupg7m.us-east-1.cloudsearch.amazonaws.com/");
	}
	@Test
	void testgetVideosById() throws Exception {
		videosDaoImpl.getVideosById("123");
	}
	@Test
	void testuploadVideos() throws Exception{
		Videos videos=new Videos();
		List<String> ids=new ArrayList<String>();
		List<String> desc=new ArrayList<String>();
		ids.add("testDisc");
		desc.add("short desc");
		videos.setId(ids);
		videos.setDescription(desc);
			 videosDaoImpl.uploadVideos(videos);
		
	}
	@Test
	void testdeleteById() throws Exception{
		  videosDaoImpl.deleteVideos("testDisc");
	}
	 @Test
	 void getCategories() throws Exception {
	 videosDaoImpl.getCategories("model","year","vTopic");
	}

	@Test
	void getRelatedVideos() throws IOException {
		videosDaoImpl.getRelatedVideos("id", "model", "year");
	}

	@Test
	void getVideos() throws IOException {
		videosDaoImpl.getVideos("model","year","category","keyword","vTopic","2","10");
	}



}
