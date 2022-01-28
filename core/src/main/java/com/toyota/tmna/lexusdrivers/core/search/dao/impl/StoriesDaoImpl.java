package com.toyota.tmna.lexusdrivers.core.search.dao.impl;

import java.io.IOException;

import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.SearchTemplate;
import com.toyota.tmna.lexusdrivers.core.search.dao.StoriesDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.domain.Stories;

@Component(service=StoriesDao.class, immediate = true)
public class StoriesDaoImpl extends SearchTemplate<Stories> implements StoriesDao {

	private static final long serialVersionUID = -1460008840997180153L;

	@Override
	public SearchResponse getStoriesById(String id) throws IOException {
		return (SearchResponse) this.findByArticleId(id, Stories.class);
	}

	@Override
	public boolean uploadStories(Stories stories) throws JsonProcessingException {
		return this.saveOrUpdateDocument(stories);
	}

	@Override
	public boolean deleteStories(String id) throws IOException {
		return this.deleteById(id);
	}
	@Override
	public SearchResponse getAllStoriesOrByCategory(String start, String size, String category) throws IOException {
		return this.getStories(start, size, category, Stories.class);
	}
	@Override
	public SearchResponse getRelatedStories(String category, String id) throws IOException {
		return this.getRelatedArticles(category, id, Stories.class);
	}
	@Override
	public Long getStoriesCategoryCount(String category) throws Exception{
		return super.getStoriesCategoryCount(category);
	}
	@Override
	public void init(String searchEndpointURL, String uploadDocEndpointURL) {
		super.init(searchEndpointURL, uploadDocEndpointURL);

	}

}
