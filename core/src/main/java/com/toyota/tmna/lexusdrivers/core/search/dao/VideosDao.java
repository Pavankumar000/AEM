package com.toyota.tmna.lexusdrivers.core.search.dao;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.domain.Videos;

public interface VideosDao {

	public SearchResponse getVideosById(String id) throws IOException;

	public boolean uploadVideos(Videos stories) throws JsonProcessingException;
	
	public boolean deleteVideos(String id) throws IOException;
	
	public SearchResponse getVideos(String baseModel, String year, String category, String keyword, String vTopic, String startIndex, String size) throws IOException;
	
	public SearchResponse getRelatedVideos(String id, String baseModel, String year) throws IOException;
	
	public List<String> getCategories(String baseModel, String year, String vTopic) throws Exception;
	
	public void init(String searchEndpointURL, String uploadDocEndpointURL);
}
