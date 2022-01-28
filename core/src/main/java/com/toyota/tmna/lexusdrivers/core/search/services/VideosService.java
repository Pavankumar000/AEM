package com.toyota.tmna.lexusdrivers.core.search.services;

import java.io.Serializable;
import java.util.List;

import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.domain.Videos;

public interface VideosService extends Serializable {

	public SearchResponse getVideosById(String videosId);

	public boolean uploadVideos(Videos videos);
	
	public boolean deleteVideosById(String videosId);
	
	public SearchResponse getVideos(String model, String year, String category, String keyword, String vTopic, String startIndex, String size);
	
	public SearchResponse getRelatedVideos(String id, String model, String year);
	
	public List<String> getCategories(String model, String year, String vTopic);

}
