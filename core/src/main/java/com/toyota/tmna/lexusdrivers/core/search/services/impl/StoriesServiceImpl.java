package com.toyota.tmna.lexusdrivers.core.search.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.toyota.tmna.lexusdrivers.core.search.services.StoriesConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.dao.StoriesDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.domain.Stories;
import com.toyota.tmna.lexusdrivers.core.search.services.StoriesService;

@Component(service=StoriesService.class, immediate = true)
@Designate(ocd= StoriesConfig.class)
public class StoriesServiceImpl implements StoriesService {
	private static final long serialVersionUID = 1L;
	private String storiesSearchEndpointURL;
	private String storiesUploadDocEndpointURL;

	@Reference
	private transient StoriesDao storiesDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StoriesServiceImpl.class);

	@Override
	public SearchResponse getStoriesById(String storiesId) {
		try {
			return storiesDao.getStoriesById(storiesId);
		} catch (IOException e) {
			LOGGER.error("Error while retrieving stories::"+e.getMessage());
		}
		return null;
	}

	@Override
	public boolean uploadStories(Stories stories) {
		try {
			return storiesDao.uploadStories(stories);
		} catch (JsonProcessingException e) {
			LOGGER.error("Error while uploading stories::"+e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteStoriesById(String storiesId) {
		try {
			return storiesDao.deleteStories(storiesId);
		} catch (IOException e) {
			LOGGER.error("Error while deleting stories :: "+e.getMessage());
		}
		return false;
	}
	@Override
	public SearchResponse getAllStoriesOrByCategory(String start, String size, String category){
		try {
			SearchResponse sr = storiesDao.getAllStoriesOrByCategory(start, size, category);
			setCategoryCountForRetrievedStories(sr);
			return sr;
		}catch (IOException e) {
			LOGGER.error("Error while fetching all stories or by category:: "+e.getMessage());
		}
		return null;
	}
	@Override
	public SearchResponse getRelatedStories(String categoryList, String id){
		try {
			SearchResponse sr =  storiesDao.getRelatedStories(categoryList, id);
			setCategoryCountForRetrievedStories(sr);
			return sr;
		}catch (IOException e) {
			LOGGER.error("Error while fetching stories by category:: "+e.getMessage());
		}
		return null;
	}

	private void setCategoryCountForRetrievedStories(SearchResponse sr) {
		List<Stories> storiesList = (sr != null) ? (List<Stories>) sr.getData() : null;
		Map<String, Long> categoryCountMap = new HashMap<String, Long>();
		Long categoryCount = 0l;
		List<Stories> newStoriesList = new ArrayList<Stories>();
		if (storiesList != null) {
			for (Stories s : storiesList) {
				if (s.getCategory_count() == null) {
					if (categoryCountMap.size() > 0 && categoryCountMap.get(s.getCategory()) != null) {
						categoryCount = categoryCountMap.get(s.getCategory());
					} else {
						try {
							categoryCount = storiesDao.getStoriesCategoryCount(s.getCategory());
						} catch (Exception e) {
							LOGGER.error("Error while retrieving stories category count::"+e.getMessage());
						}
						categoryCountMap.put(s.getCategory(), categoryCount);
					}
					s.setCategory_count(categoryCount);
				}
				newStoriesList.add(s);
			}
			sr.setData(newStoriesList);
		}
	}

	@Activate
	public void activate(StoriesConfig config) throws IOException {
		storiesSearchEndpointURL = config.stories_searchEndpointURL();
		storiesUploadDocEndpointURL= config.stories_uploadDocEndpointURL();
		storiesDao.init(storiesSearchEndpointURL, storiesUploadDocEndpointURL);
	}

}
