package com.toyota.tmna.lexusdrivers.core.search.dao;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.domain.Stories;

public interface StoriesDao {

	public SearchResponse getStoriesById(String id) throws IOException;

	public boolean uploadStories(Stories rewards) throws JsonProcessingException;
	
	public boolean deleteStories(String id) throws IOException;
	
	public SearchResponse getAllStoriesOrByCategory(String start, String size, String category) throws IOException;
	
	public SearchResponse getRelatedStories(String category, String id) throws IOException;
	
	public Long getStoriesCategoryCount(String category) throws Exception;

	public void init(String searchEndpointURL, String uploadDocEndpointURL);

}
