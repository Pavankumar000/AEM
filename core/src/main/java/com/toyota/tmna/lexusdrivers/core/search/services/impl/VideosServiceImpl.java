package com.toyota.tmna.lexusdrivers.core.search.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.toyota.tmna.lexusdrivers.core.search.services.VideosConfig;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
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
import com.toyota.tmna.lexusdrivers.core.search.dao.VideosDao;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.domain.Videos;
import com.toyota.tmna.lexusdrivers.core.search.services.VideosService;
import com.toyota.tmna.lexusdrivers.core.util.SearchConstants;

@Component(service=VideosService.class, immediate = true)
@Designate(ocd= VideosConfig.class)
public class VideosServiceImpl implements VideosService {

	private static final long serialVersionUID = 9201023359112846965L;
	private String videosSearchEndpointURL;
	private String videosUploadDocEndpointURL;

	@Reference
	private  transient VideosDao videosDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VideosServiceImpl.class);

	@Override
	public SearchResponse getVideosById(String videosId) {
		SearchResponse newSr = new SearchResponse();
		List<Videos> videosList = new ArrayList<Videos>();
		try {
			SearchResponse sr= videosDao.getVideosById(videosId);
			return updateTopicTagForDisplay(newSr, videosList, sr);
		} catch (IOException e) {
			LOGGER.error("Error while retrieving videos::"+e.getMessage());
		}
		return null;
	}

	@Override
	public boolean uploadVideos(Videos videos) {
		try {
			return videosDao.uploadVideos(videos);
		} catch (JsonProcessingException e) {
			LOGGER.error("Error while uploading videos::"+e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteVideosById(String videosId) {
		try {
			return videosDao.deleteVideos(videosId);
		} catch (IOException e) {
			LOGGER.error("Error while deleting videos :: "+e.getMessage());
		}
		return false;
	}
	@Override
	public SearchResponse getVideos(String model, String year, String category, String keyword, String vTopic, String startIndex, String size){
		try {
			return videosDao.getVideos(getBaseModel(model), year, category, keyword, vTopic, startIndex, size);
		}catch (IOException e) {
			LOGGER.error("Error while retrieving video :: "+e.getMessage());
		}
		return null;
	}
	
	@Override
	public SearchResponse getRelatedVideos(String id, String model, String year){
		SearchResponse sr;
		SearchResponse finalSr = new SearchResponse();
		Set<String> selectedVdoTopicTagSet = new HashSet<String>();
		Integer relatedVdoCount = 0;
		List<Videos> relatedVideos = new ArrayList<Videos>();
		Map<Integer, Videos> topicTagVideoMap = new HashMap<Integer, Videos>();
		try {
			//Retrieve list of related videos from CS domain.
			sr = videosDao.getRelatedVideos(id, getBaseModel(model), year);
			List<Videos> videosList = (List<Videos>) sr.getData();
			if(videosList != null) {
				Collections.sort(videosList);
			}
			//Logic to retrieve related videos is to pick top 4 maximum matching topic tags videos with the selected video.
			//If the video has * or all as topic tag, that video takes precedence over others and will be listed as top most video in sortedTopicTagVideoMapList
			SearchResponse selectedVideo = videosDao.getVideosById(id);
			Videos videos = (Videos) selectedVideo.getData().get(0);
			String selectedVdoTopicTag[] = splitCommaForTopicTag(videos);
			selectedVdoTopicTag = StringUtils.stripAll(selectedVdoTopicTag);
			if(selectedVdoTopicTag != null)
				selectedVdoTopicTagSet.addAll(Arrays.asList(selectedVdoTopicTag));
			if(videosList != null)
				retrieveHighPrecedenceVideos(selectedVdoTopicTagSet, relatedVdoCount, relatedVideos, topicTagVideoMap,
					videosList, videos);
			//sort TopicTagVideoMap in descending order
			List<Map.Entry<Integer, Videos>> sortedTopicTagVideoMapList = sortTopicTagVideoMapList(topicTagVideoMap);
			Integer count = relatedVideos.size();
			for (Map.Entry<Integer, Videos> sortedTopicTagVdo : sortedTopicTagVideoMapList) { 
				count ++;
				if(count <= SearchConstants.COUNT_4){
					relatedVideos.add(sortedTopicTagVdo.getValue());
				}
				else break;
			}
			retrieveRelatedVideos(relatedVideos, videosList);
			finalSr.setData(relatedVideos);
			finalSr.setTotal_records(Long.valueOf(relatedVideos.size()));
			
		}catch (IOException e) {
			LOGGER.error("Error while retrieving video :: "+e.getMessage());
		}
		return finalSr;
	}

	private void retrieveRelatedVideos(List<Videos> relatedVideos, List<Videos> videosList) {
		Integer count=0;
		if(!(relatedVideos.size() > 0 && relatedVideos.size() == SearchConstants.COUNT_4)) {
			count = relatedVideos.size();
			if(videosList != null) {
				for(Videos v: videosList) {
					count++;
					if(count <= SearchConstants.COUNT_4) {
						relatedVideos.add(v);
					}
				}
			}
		}
	}
	// From the list of all videos, retrieve high precedence videos and sort based on precedence order which can be determined
	// through max. matching topic tags for the video with the selected video.
	private void retrieveHighPrecedenceVideos(Set<String> selectedVdoTopicTagSet, Integer relatedVdoCount,
			List<Videos> relatedVideos, Map<Integer, Videos> topicTagVideoMap, List<Videos> videosList, Videos videos) {
		boolean isHighPrecedence;
		List<String> tempList;
		for (Videos v : videosList) {
			isHighPrecedence = false;
			int matchedTopicTagCount = 0;
			tempList = new ArrayList<String>();
			String topicTags[] = splitCommaForTopicTag(v);
			topicTags = StringUtils.stripAll(topicTags);
			if (topicTags != null) {
				tempList.addAll(Arrays.asList(topicTags));
				if (checkHighPrecedenceVideo(videos, tempList, v)) {
					isHighPrecedence = true;
				}
				tempList.retainAll(selectedVdoTopicTagSet);
				matchedTopicTagCount = tempList.size();
			}
			if (isHighPrecedence) {
				removePrecedenceTopicTag(v, topicTags);
				if (relatedVdoCount < SearchConstants.COUNT_4) {
					relatedVdoCount++;
					relatedVideos.add(v);
				}
			}
			if (checkForTopicTagCount(videos, isHighPrecedence, v, matchedTopicTagCount)) {
				topicTagVideoMap.put(matchedTopicTagCount, v);
			}
		}
	}

	@Override
	public List<String> getCategories(String model, String year, String vTopic) {
		try {
			return videosDao.getCategories(getBaseModel(model), year, vTopic);
		} catch (Exception e) {
			LOGGER.error("Exception while trying to retrieve videos categories:"+e.getMessage());
		}
		return null;
	}
	//Update topic tags to not have precedence characters in the topic tags values.
	private SearchResponse updateTopicTagForDisplay(SearchResponse newSr, List<Videos> videosList, SearchResponse sr) {
		if(sr != null && sr.getData()!=null && sr.getData().size() > 0 ) {
			Videos v = (Videos) sr.getData().get(0);
			String selectedVdoTopicTag[] = splitCommaForTopicTag(v);
			selectedVdoTopicTag = StringUtils.stripAll(selectedVdoTopicTag);
			removePrecedenceTopicTag(v, selectedVdoTopicTag);
			videosList.add(v);
			newSr.setData(videosList);
			newSr.setTotal_records(Long.valueOf(videosList.size()));
		}
		return newSr;
	}
	//remove *, all precedence topic tag from the selected video, to not display in front end.
	private void removePrecedenceTopicTag(Videos v, String[] topicTags) {
		Object topicTag[] = ArrayUtils.removeElement(topicTags, SearchConstants.STAR);
		String tTag = StringUtils.EMPTY;
		for(int i = 0 ; i < topicTag.length ; i++){
			if(i != topicTag.length-1)
				tTag = tTag.concat(topicTag[i].toString()).concat(SearchConstants.COMMA);
			else
				tTag = tTag.concat(topicTag[i].toString());
			
		}
		List<String> tTagList = new ArrayList<String>();
		tTagList.add(tTag);
		v.setTopic_tag(tTagList);
	}
	//Sort topic tags of videos
	private List<Map.Entry<Integer, Videos>> sortTopicTagVideoMapList(Map<Integer, Videos> topicTagMap){
		List<Map.Entry<Integer, Videos> > list = 
	               new LinkedList<Map.Entry<Integer, Videos> >(topicTagMap.entrySet()); 
	        Collections.sort(list, new Comparator<Map.Entry<Integer, Videos> >() { 
	            public int compare(Map.Entry<Integer, Videos> o1,  
	                               Map.Entry<Integer, Videos> o2) 
	            { 
	                return (o2.getKey()).compareTo(o1.getKey()); 
	            } 
	        }); 
	        return list; 
	}
	/**
	 * Method to retrieve base model of the model eg- RX350 , rx is base model
	 * @param model
	 * @return
	 */
	private String getBaseModel(String model) {
		model = model.toLowerCase();
		// to remove trim from model
		String integerSet = SearchConstants.INTEGER_SET;
		int index = StringUtils.indexOfAny(model, integerSet);
		String baseModelName = model;
		if (index != -1) {
			baseModelName = model.substring(0, index);
		}
		if (model.endsWith(SearchConstants.SMALL_H)) {
			baseModelName = new StringBuilder(baseModelName).append(SearchConstants.HYBRID).toString();
		}
		if(model.endsWith(SearchConstants.SMALL_C)) {
			baseModelName = new StringBuilder(baseModelName).append(SearchConstants.SMALL_C).toString();
		}
		if (model.toUpperCase().endsWith(SearchConstants.CAP_L)) {
			
			if (model.toUpperCase().endsWith(SearchConstants.CAP_HL)) 
				baseModelName = new StringBuilder(baseModelName).append(SearchConstants.LHYBRID).toString();
			else
				baseModelName = new StringBuilder(baseModelName).append(SearchConstants.SMALL_L).toString();
		}
		baseModelName = new StringBuilder(baseModelName.trim()
				.replaceAll(" ", StringUtils.EMPTY)
				.replaceAll(SearchConstants.HYBRID, SearchConstants.HYPHEN_HYBRID)).toString();

		return baseModelName;
	}
	private String[] splitCommaForTopicTag(Videos v) {
		return v.getTopic_tag() != null ? v.getTopic_tag().split(SearchConstants.COMMA) : null;
	}

	private boolean checkForTopicTagCount(Videos videos, boolean isHighPrecedence, Videos v, int matchedTopicTagCount) {
		return !isHighPrecedence && matchedTopicTagCount > 0 && !v.getId().equals(videos.getId());
	}

	private boolean checkHighPrecedenceVideo(Videos videos, List<String> tempList, Videos v) {
		return (tempList.contains(SearchConstants.ALL) || tempList.contains(SearchConstants.STAR))
				&& !(v.getId().equalsIgnoreCase(videos.getId()));
	}
	@Activate
	public void activate(VideosConfig config) throws IOException {
		videosSearchEndpointURL = config.videos_searchEndpointURL();
		videosUploadDocEndpointURL= config.videos_uploadDocEndpointURL();
		videosDao.init(videosSearchEndpointURL, videosUploadDocEndpointURL);
	}

}
