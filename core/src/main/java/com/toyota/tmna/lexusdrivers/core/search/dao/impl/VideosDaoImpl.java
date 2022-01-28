package com.toyota.tmna.lexusdrivers.core.search.dao.impl;

import java.io.IOException;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.toyota.tmna.lexusdrivers.core.search.SearchTemplate;
import com.toyota.tmna.lexusdrivers.core.search.dao.VideosDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.domain.Videos;

@Component(service=VideosDao.class, immediate = true)
public class VideosDaoImpl extends SearchTemplate<Videos> implements VideosDao {

	private static final long serialVersionUID = -7871385593394872366L;

	@Override
	public SearchResponse getVideosById(String id) throws IOException {
		return (SearchResponse) this.findById(id, Videos.class);
	}

	@Override
	public boolean uploadVideos(Videos videos) throws JsonProcessingException {
		return this.saveOrUpdateDocument(videos);

	}
	
	@Override
	public boolean deleteVideos(String id) throws IOException {
		return this.deleteById(id);
	}
	
	@Override
	public SearchResponse getVideos(String baseModel, String year, String category, String keyword, String vTopic, String startIndex, String size) throws IOException {
		return super.getVideos(baseModel, year, category, keyword, vTopic, startIndex, size, Videos.class);
	}

	@Override
	public SearchResponse getRelatedVideos(String id, String baseModel, String year) throws IOException {
		return super.getRelatedVideos(id, baseModel, year, Videos.class);
	}
	
	@Override
	public List<String> getCategories(String baseModel, String year, String vTopic) throws Exception{
		return super.getVideoCategories(baseModel, year, vTopic);
	}
	
	@Override
	public void init(String searchEndpointURL, String uploadDocEndpointURL) {
		super.init(searchEndpointURL, uploadDocEndpointURL);

	}
}
