package com.toyota.tmna.lexusdrivers.core.search.services;

import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.domain.Stories;

import java.io.Serializable;

public interface StoriesService extends Serializable {

	public SearchResponse getStoriesById(String storiesId);

	public boolean uploadStories(Stories stories);
	
	public boolean deleteStoriesById(String storiesId);
	
	public SearchResponse getAllStoriesOrByCategory(String start, String size, String category); 
	
	public SearchResponse getRelatedStories(String category, String id);

}
