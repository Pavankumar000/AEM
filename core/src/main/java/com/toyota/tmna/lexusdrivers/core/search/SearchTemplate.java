package com.toyota.tmna.lexusdrivers.core.search;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.toyota.tmna.lexusdrivers.core.servlets.VideosHandler;
import org.apache.commons.lang3.StringUtils;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomainClient;
import com.amazonaws.services.cloudsearchdomain.AmazonCloudSearchDomainClientBuilder;
import com.amazonaws.services.cloudsearchdomain.model.ContentType;
import com.amazonaws.services.cloudsearchdomain.model.Hit;
import com.amazonaws.services.cloudsearchdomain.model.Hits;
import com.amazonaws.services.cloudsearchdomain.model.QueryParser;
import com.amazonaws.services.cloudsearchdomain.model.SearchRequest;
import com.amazonaws.services.cloudsearchdomain.model.SearchResult;
import com.amazonaws.services.cloudsearchdomain.model.UploadDocumentsRequest;
import com.amazonaws.services.cloudsearchdomain.model.UploadDocumentsResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toyota.tmna.lexusdrivers.core.search.domain.Identifiable;
import com.toyota.tmna.lexusdrivers.core.search.domain.Rewards;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.domain.UploadRequest;
import com.toyota.tmna.lexusdrivers.core.util.SearchConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SearchTemplate<T extends Identifiable> implements Serializable {
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchTemplate.class);

	private static final long serialVersionUID = 6524571502390636461L;
	private transient EndpointConfiguration endpointConfiguration;
	private transient AmazonCloudSearchDomainClient  amazonCloudSearchDomainClient;
	private transient AmazonCloudSearchDomainClient amazonCloudSearchUploadDomainClient;
	private ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	public void init(String endpointSearchURL, String uploadEndpointURL) {
		endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(endpointSearchURL, null);
		AmazonCloudSearchDomainClientBuilder acs = AmazonCloudSearchDomainClientBuilder.standard()
				.withEndpointConfiguration(endpointConfiguration);
		acs.setCredentials(new AWSStaticCredentialsProvider(new AnonymousAWSCredentials()));
		amazonCloudSearchDomainClient = (AmazonCloudSearchDomainClient) acs.build();
		endpointConfiguration = new AwsClientBuilder.EndpointConfiguration(uploadEndpointURL, null);
		AmazonCloudSearchDomainClientBuilder acsUpload = AmazonCloudSearchDomainClientBuilder.standard()
				.withEndpointConfiguration(endpointConfiguration);
		acsUpload.setCredentials(new AWSStaticCredentialsProvider(new AnonymousAWSCredentials()));
		amazonCloudSearchUploadDomainClient = (AmazonCloudSearchDomainClient) acsUpload.build();
	}

	/**
	 * findById is used to retrieve list of documents which satisfy the request id or id's separated by comma.
	 * @param id
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	/**
	 * Sample query when request passed is x,y -  (or id:'x' id:'y')
	 * if single value in request , query formed is (or id:'x')
	 */
	public SearchResponse findById(String id, Class<T> clazz) throws IOException {
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder searchQuery = new StringBuilder();
		searchQuery.append("( or id:'");
		if(id.indexOf(SearchConstants.COMMA) !=-1) {
			String multipleIds[] = id.split(SearchConstants.COMMA);
			for(int i=0 ; i< multipleIds.length-1 ; i++) {
				searchQuery.append(multipleIds[i]).append("' id:'");
			}
			searchQuery.append(multipleIds[multipleIds.length-1]).append("'");
		}else {
			searchQuery.append(id).append("'");
		}
		searchQuery.append(")");
		return setQueryRequestAttributes(clazz, searchRequest, searchQuery);
	}
	/**
	 * findByArticleId is used to retrieve list of documents which satisfy the request id and its not expired.
	 * @param id
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	/**
	 * Sample query when request passed is x-  (and (range field%3Deffective_end_date ['2021-06-14T16:58:13.383Z',}) (range field%3Dpublish_date {,'2021-06-14T16:58:13.397Z'])(and (term field%3Did 'ART2371')))
	 * 
	 */
	public SearchResponse findByArticleId(String id, Class<T> clazz) throws IOException {
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder searchQuery = new StringBuilder();
		searchQuery.append("(and (range field=effective_end_date ['")
		.append(new Date().toInstant().toString()).append("',}) (range field=publish_date {,'")
		.append(new Date().toInstant().toString()).append("'])");
		searchQuery.append("(and (term field=id '").append(id).append("')))");
		searchRequest.setQuery(searchQuery.toString());
		searchRequest.setQueryParser(QueryParser.Structured);
		SearchResult results = amazonCloudSearchDomainClient.search(searchRequest);

		return hitMarshallList(results.getHits(), clazz);
	}
	/**
	 * saveOrUpdateDocument is used to add or update existing document to cloudsearch, action passed is "add"
	 * @param classObj
	 * @return
	 * @throws JsonProcessingException
	 */
	public boolean saveOrUpdateDocument(T classObj) throws JsonProcessingException {
		List<UploadRequest<T>> uploadRequestList = new ArrayList<UploadRequest<T>>();

		UploadRequest<T> uploadReq = new UploadRequest<T>(SearchConstants.ADD, classObj.getId(), classObj);
		uploadRequestList.add(uploadReq);
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		String obj = objectMapper.writeValueAsString(uploadRequestList);
		UploadDocumentsRequest uploadRequest = new UploadDocumentsRequest();
		try{
			InputStream is = new ByteArrayInputStream(obj.getBytes("UTF-8"));
			uploadRequest.setDocuments(is);
			uploadRequest.setContentType(ContentType.Applicationjson.toString());
			uploadRequest.setContentLength(Long.valueOf(obj.getBytes("UTF-8").length));
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Error occured during upload  : {0}", e);
		}
		UploadDocumentsResult uploadResults = amazonCloudSearchUploadDomainClient.uploadDocuments(uploadRequest);
		if (uploadResults != null && uploadResults.getStatus().equalsIgnoreCase(SearchConstants.SUCCESS)) {
			return true;
		}

		return false;
	}

	/**
	 * deleteById is used to delete the id passed in the request, action is "delete"
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public boolean deleteById(String id) throws IOException{
		List<UploadRequest<T>> uploadRequestList = new ArrayList<UploadRequest<T>>();
		UploadRequest<T> uploadReq = new UploadRequest<T>(SearchConstants.DELETE, id);
		uploadRequestList.add(uploadReq);

		String obj = objectMapper.writeValueAsString(uploadRequestList);
		UploadDocumentsRequest uploadRequest = new UploadDocumentsRequest();
		InputStream is = new ByteArrayInputStream(obj.getBytes());
		uploadRequest.setDocuments(is);
		uploadRequest.setContentType(ContentType.Applicationjson.toString());
		uploadRequest.setContentLength(Long.valueOf(obj.getBytes().length));
		UploadDocumentsResult uploadResults = amazonCloudSearchUploadDomainClient
				.uploadDocuments(uploadRequest);
		if (uploadResults != null && uploadResults.getStatus().equalsIgnoreCase("success")) {
			return true;
		}
	 else
		return false;
	}
	/**
	 * getArticlesExpiredUntilDaysBefore is used to retrieve articles expiring in numDays passed from cloudsearch
	 * @param numDays
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	/**
	 * Sample Query - effective_end_date:[currentDate,numDays]
	 */
	public SearchResponse getArticlesExpiredUntilDaysBefore(String numDays, Class<T> clazz) throws IOException {
		SearchRequest searchRequest = new SearchRequest();
		String query = "effective_end_date:['";
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, Integer.parseInt(numDays));
		String date = c.getTime().toInstant().toString();
		query = query+new Date().toInstant().toString()+"','"+date+"']";
		searchRequest.setSize(SearchConstants.DEFAULT_SIZE);
		return setQueryRequestAttributes(clazz, searchRequest, new StringBuilder(query));
	}
	
	/**
	 * getAllRewardsAndEvents used to retrieve list of all rewards based on state, category, type, lat, lan values.
	 * @param state
	 * @param category
	 * @param type
	 * @param latitude
	 * @param longitude
	 * @param startIndex
	 * @param size
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	/**
	 * Sample query
	 * Q1 - (and (range field=effective_end_date ['',}) (range field=publish_date {,'']) (and (term field=zip_code '00000')))
	 * Q2 - (and (range field=effective_end_date ['',}) (range field=publish_date {,'']) (or (term field=state '') (term field=zip_code '00000')))
	 * Q3 - (and (range field=effective_end_date ['',}) (range field=publish_date {,'']) (or (term field=state '') (term field=zip_code '00000'))(and (or category_list:'')))
	 * 
	 */
	public SearchResponse getAllRewardsAndEvents(String state, String category, String type,  String latitude, String longitude, String startIndex, String size, Class<T> clazz) throws IOException {
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder query = new StringBuilder();
		setEffectiveEndDateQuery(query);
		
		if(StringUtils.isNotBlank(state) && !"*".equalsIgnoreCase(state)) {
			setRewardsStateQuery(state, category, query);
		}else {
			setRewardsCategoryQuery(category, query);
		}
		query.append(")");
		if(StringUtils.isNotBlank(latitude) && StringUtils.isNotBlank(longitude)) {
			setExprDistanceSort(latitude, longitude, searchRequest);
		}
		setSizeStartForQuery(startIndex, size, searchRequest);
	
		return setQueryRequestAttributes(clazz, searchRequest, query);
	}

	private void setSizeStartForQuery(String startIndex, String size, SearchRequest searchRequest) {
		if(StringUtils.isNotBlank(size) && StringUtils.isNotBlank(startIndex)) {
			searchRequest.setSize(Long.valueOf(size));
			searchRequest.setStart(Long.valueOf(startIndex)-1);
		}else {
			searchRequest.setSize(SearchConstants.DEFAULT_SIZE);
		}
	}

	private void setEffectiveEndDateQuery(StringBuilder query) {
		query.append("(and (range field=effective_end_date ['")
			.append(new Date().toInstant().toString()).append("',}) (range field=publish_date {,'")
			.append(new Date().toInstant().toString()).append("'])");
	}

	private void setExprDistanceSort(String latitude, String longitude, SearchRequest searchRequest) {
		searchRequest.setExpr("{\"distance\":\"haversin("+latitude+SearchConstants.COMMA+longitude+", lat_lan.latitude, lat_lan.longitude)\"}");
		searchRequest.setSort("distance asc");
		searchRequest.setReturn("_all_fields,distance");
	}

	private void setRewardsCategoryQuery(String category, StringBuilder query) {
		if(StringUtils.isNotBlank(category)) {
			query.append("(and (or category_list:'");
			if(category.indexOf(SearchConstants.COMMA) !=-1) {
				String multipleCategories[] = category.split(SearchConstants.COMMA);
				for(int i=0 ; i< multipleCategories.length-1 ; i++) {
					query.append(multipleCategories[i]).append("' category_list:'");
				}
				query.append(multipleCategories[multipleCategories.length-1]).append("'");
			}else {
				query.append(category).append("'");
			}
			query.append("))");
		}
	}

	private void setRewardsStateQuery(String state, String category, StringBuilder query) {
		if("online".equalsIgnoreCase(state)) {
			query.append(" (and (term field=zip_code '00000'))");
		} else {
			query.append(" (and (term field=state '").append(state).append("') (not (term field=zip_code '00000')))");
			setRewardsCategoryQuery(category, query);
		}
	}

	/**
	 * getAllRewardsCategories is list of categories returned for all rewards for a state
	 * @param state
	 * @return
	 */
	/**
	 * Sample Query - (and (range field=effective_end_date ['',})(range field=publish_date {,'']) (and (term field=state '')))
	 */
	public List<String> getAllRewardsCategories(String state) throws Exception{
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder query = new StringBuilder();
		query.append("(and (range field=effective_end_date ['")
			.append(new Date().toInstant().toString()).append("',}) (range field=publish_date {,'")
			.append(new Date().toInstant().toString()).append("'])");
		if(StringUtils.isNotBlank(state) && "online".equalsIgnoreCase(state)) {
			query.append("(and (term field=zip_code '00000')))");
		}else {
			query.append("(and (term field=state '").append(state).append("')))");
		}
		searchRequest.setQuery(query.toString());
		searchRequest.setQueryParser(QueryParser.Structured);
		searchRequest.setSize(SearchConstants.DEFAULT_SIZE);
		searchRequest.setReturn("category_list");
		SearchResult results = amazonCloudSearchDomainClient.search(searchRequest);
		List<Hit> hit = results.getHits().getHit();
		List<String> categories = new ArrayList<String>();
		String categoryList="";
		for(Hit h: hit) {
			Map<String, List<String>> map = h.getFields();
			categoryList = 	map.get("category_list").get(0);
			if(!categories.contains(categoryList)) {
				categories.add(categoryList);
			}
		}
		return categories;
	}
	/**
	 * getAllRewards State is to return list of all states for rewards.
	 * @return
	 */
	/**
	 * Sample query - (and (range field=effective_end_date ['',}) (range field=publish_date {,'']))
	 */
	public List<String> getAllRewardsState() throws Exception{
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder query = new StringBuilder();
		query.append("(and (range field=effective_end_date ['")
			.append(new Date().toInstant().toString()).append("',}) (range field=publish_date {,'")
			.append(new Date().toInstant().toString()).append("']))");
		searchRequest.setQuery(query.toString());
		searchRequest.setQueryParser(QueryParser.Structured);
		searchRequest.setSize(SearchConstants.DEFAULT_SIZE);
		searchRequest.setReturn("state");
		SearchResult results = amazonCloudSearchDomainClient.search(searchRequest);
		List<Hit> hit = results.getHits().getHit();
		List<String> state= new ArrayList<String>();
		String stateList="";
		for(Hit h: hit) {
			Map<String, List<String>> map = h.getFields();
			stateList = map.get("state").get(0);
			if(!state.contains(stateList)) {
				state.add(stateList);
			}
		}
		return state;
	}
	
	/**
	 * GetRelated rewards for the selected reward
	 * @param category
	 * @param id
	 * @param latitude
	 * @param longitude
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	/**
	 * Sample query - (and (range field=effective_end_date ['',})(range field=display_start_date {,''])(and (term field=category_list ''))(not (term field=id '')))
	 */
	public SearchResponse getRelatedRewards(String category, String id,  String latitude, String longitude, Class<T> clazz) throws IOException{
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder query = new StringBuilder();
		query.append("(and (range field=effective_end_date ['")
			.append(new Date().toInstant().toString()).append("',}) (range field=display_start_date {,'")
			.append(new Date().toInstant().toString()).append("']) (and (term field=category_list '").append(category).append("'))")
			.append("(not (term field=id '").append(id).append("')))");	
		
		if(StringUtils.isNotBlank(latitude) && StringUtils.isNotBlank(longitude)) {
			setExprDistanceSort(latitude, longitude, searchRequest);
		}
		searchRequest.setSize(4l);
		return setQueryRequestAttributes(clazz, searchRequest, query);
	}

	private SearchResponse setQueryRequestAttributes(Class<T> clazz, SearchRequest searchRequest, StringBuilder query)
			throws IOException {
		searchRequest.setQuery(query.toString());
		searchRequest.setQueryParser(QueryParser.Structured);
		SearchResult results = amazonCloudSearchDomainClient.search(searchRequest);
		return hitMarshallList(results.getHits(), clazz);
	}
	
	/**
	 * getStories is used to return list of all documents which satisfy given category
	 * @param start
	 * @param size
	 * @param category
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	/**
	 * Sample query - (and (range field=effective_end_date ['',}) (range field=display_start_date {,'']))
	 * or 
	 * (and (range field=effective_end_date ['',}) (range field=display_start_date {,'']) (and (term field=category '')))
	 */
	public SearchResponse getStories(String start, String size, String category, Class<T> clazz) throws IOException {
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder query = new StringBuilder();
		query.append("(and (range field=effective_end_date ['")
			.append(new Date().toInstant().toString()).append("',}) (range field=display_start_date {,'")
			.append(new Date().toInstant().toString()).append("'])");
		if(StringUtils.isNotBlank(category) && !"*".equalsIgnoreCase(category)) {
			query.append(" (and (term field=category '").append(category).append("'))");;
		}
		query.append(")");
		searchRequest.setSort("publish_date desc");
		setSizeStartForQuery(start, size, searchRequest);
		return setQueryRequestAttributes(clazz, searchRequest, query);
	}
	/**
	 * getRelatedArticles is used to retrive related article for selected story
	 * @param category
	 * @param id
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	/**
	 * Sample query 
	 * retrieve 1 article from this query (and (range field=effective_end_date ['',}) (range field=display_start_date {,''])(term field=category '')(not (term field=id '')))
	 * then retrieve rest 3 using below query
	 * (and (range field=effective_end_date ['',}) (range field=display_start_date {,''])(not (term field=category '<selected_category>')))
	 */
	public SearchResponse getRelatedArticles(String category, String id, Class<T> clazz) throws IOException{
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder query = new StringBuilder();
		query.append("(and (range field=effective_end_date ['")
		.append(new Date().toInstant().toString()).append("',}) (range field=display_start_date {,'")
		.append(new Date().toInstant().toString()).append("']) (term field=category '").append(category).append("')");
		query.append("(not (term field=id '").append(id).append("')))");	
		searchRequest.setSort("publish_date desc");
		searchRequest.setSize(1l);
		SearchResponse sr = setQueryRequestAttributes(clazz, searchRequest, query);
		if(sr!=null && sr.getData().size() < 3) {
			query = new StringBuilder();
			long pendingArticlesList = 3 - Long.valueOf((sr.getData().size()));
			query.append("(and (range field=effective_end_date ['")
			.append(new Date().toInstant().toString()).append("',}) (range field=display_start_date {,'")
			.append(new Date().toInstant().toString()).append("']) (not (term field=category '").append(category).append("')))");
			searchRequest.setSort("publish_date desc");
			searchRequest.setSize(pendingArticlesList);
			SearchResponse srTemp = setQueryRequestAttributes(clazz, searchRequest, query);
			List<T> data = (List<T>) sr.getData();
			if(srTemp != null && srTemp.getData()!= null) {
				data.addAll((List<T>)srTemp.getData());
				sr.setData(data);
			}
		}
		return sr;
	}
	/**
	 * getVideos is used to retrieve queries based on model, year, category, keyword, vtopic
	 * @param baseModel
	 * @param year
	 * @param category
	 * @param keyword
	 * @param vTopic
	 * @param startIndex
	 * @param size
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	/**
	 * Sample query
	 * If nothing is passed in param, then section_type:'videos'
	 * else
	 * (and (or type_tag:'')) (or (phrase field=model_year 'year-model') (phrase field=model_year 'year-all') (phrase field=model_year 'all-model') (phrase field=model_year 'all-all'))
	 * (and (term field=topic_tag '')) (or (term field=topic_tag '') (term field=title '') (term field=type_tag '')))
	 */
	public SearchResponse getVideos(String baseModel, String year, String category, String keyword, String vTopic,String startIndex, String size, Class<T> clazz) throws IOException {
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder query = new StringBuilder();
		if(StringUtils.isBlank(baseModel) && StringUtils.isBlank(year) && StringUtils.isBlank(keyword) && StringUtils.isBlank(category) 
				&& StringUtils.isBlank(vTopic)) {
			query.append("section_type:'videos'");
		}else {
			setVideosQuery(baseModel, year, category, keyword, vTopic, query);
		}
		setSizeStartForQuery(startIndex, size, searchRequest);
		return setQueryRequestAttributes(clazz, searchRequest, query);
	}

	private void setVideosQuery(String baseModel, String year, String category, String keyword, String vTopic,
			StringBuilder query) {
		if(StringUtils.isNotBlank(category)) {
			query.append("(and (or type_tag:'");
			if(category.indexOf(SearchConstants.COMMA) !=-1) {
				String multipleCategories[] = category.split(SearchConstants.COMMA);
				for(int i=0 ; i< multipleCategories.length-1 ; i++) {
					query.append(multipleCategories[i]).append("' type_tag:'");
				}
				query.append(multipleCategories[multipleCategories.length-1]).append("'");
			}else {
				query.append(category).append("'");
			}
			query.append(")");
		}
		setTopicTagQuery(keyword, vTopic, query);
		setModelQuery(baseModel, year, query);
		if(StringUtils.isNotBlank(category))
			query.append(")");
		if(StringUtils.isNotBlank(vTopic))
			query.append(")");
	}

	private void setTopicTagQuery(String keyword, String vTopic, StringBuilder query) {
		if(StringUtils.isNotBlank(vTopic)) {
			query.append(" (and (term field=topic_tag '").append(vTopic).append("')");
		}
		if(StringUtils.isNotBlank(keyword)) {
			query.append(" (or (term field=topic_tag '").append(keyword).append("') (term field=title '").append(keyword).append("') (term field=type_tag '").append(keyword).append("'))");
		}
	}

	private void setModelQuery(String baseModel, String year, StringBuilder query) {
		if(StringUtils.isNotBlank(baseModel) && StringUtils.isNotBlank(year)) {
			query.append("(or (phrase field=model_year '").append(year.concat("-").concat(baseModel)).append("') (phrase field=model_year 'all-").append(baseModel).append("') (phrase field=model_year '").append(year).append("-all') (phrase field=model_year 'all-all'))");
		}
	}
	
	/**
	 * getRelatedVideos is used to retrieve related videos for the selected videoid.
	 * @param id
	 * @param baseModel
	 * @param year
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	/**
	 * Sample query - (and (or (phrase field=model_year 'year-model') (phrase field=model_year 'year-all') (phrase field=model_year 'all-model') (phrase field=model_year 'all-all')) (not (term field=id '')))
	 */
	public SearchResponse getRelatedVideos(String id, String baseModel, String year, Class<T> clazz) throws IOException {
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder query = new StringBuilder();
		query.append("(and ");
		setModelQuery(baseModel, year, query);
		query.append("(not (term field=id '").append(id).append("')))");
		searchRequest.setSize(SearchConstants.DEFAULT_SIZE);
		return setQueryRequestAttributes(clazz, searchRequest, query);
	}
	/**
	 * getVideoCategories is used to return list of all categories for a model and year
	 * @param baseModel
	 * @param year
	 * @param vTopic
	 * @return
	 */
	/**
	 * Sample query 
	 * Q1 (or (phrase field=model_year 'year-model') (phrase field=model_year 'year-all') (phrase field=model_year 'all-model') (phrase field=model_year 'all-all'))
	 * Q2 - section_type:'videos' 
	 */
	public List<String> getVideoCategories(String baseModel, String year, String vTopic) throws Exception{
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder query = new StringBuilder();
		if(StringUtils.isBlank(baseModel) && StringUtils.isBlank(year)&& StringUtils.isBlank(vTopic)) {
			query.append("section_type :'videos'");
		}
		if(StringUtils.isNotBlank(vTopic)) {
			query.append(" (and (term field=topic_tag '").append(vTopic).append("')");
		}
		setModelQuery(baseModel, year, query);
		if(StringUtils.isNotBlank(vTopic))
			query.append(")");
		searchRequest.setQuery(query.toString());
		searchRequest.setQueryParser(QueryParser.Structured);
		searchRequest.setSize(SearchConstants.DEFAULT_SIZE);
		searchRequest.setReturn("type_tag");
		searchRequest.setSort("type_tag asc");
		SearchResult results = amazonCloudSearchDomainClient.search(searchRequest);
		List<Hit> hit = results.getHits().getHit();
		List<String> categories = new ArrayList<String>();
		String categoryList="";
		for(Hit h: hit) {
			Map<String, List<String>> map = h.getFields();
			if(map!=null && map.get("type_tag")!=null) {
				categoryList = map.get("type_tag").get(0);
				if (!categories.contains(categoryList)) {
					categories.add(categoryList);
				}
			}
		}
		return categories;
	}
	
	
	private SearchResponse hitMarshallList(Hits hits, Class<T> clazz) throws IOException {
		List<T> documentList = new ArrayList<T>();
		SearchResponse sr = new SearchResponse();
		sr.setTotal_records(hits.getFound());
		List<Hit> hit = hits.getHit();
		for (Hit h : hit) {
			T classObj = objectMapper.convertValue(h.getFields(), clazz);
			if(classObj instanceof Rewards) {
				Rewards r = (Rewards)classObj;
				if(h.getExprs() != null && h.getExprs().get("distance") != null) {
					r.setDistance(SearchConstants.KM_MILES_CONVERTER*Double.parseDouble(h.getExprs().get("distance")));
				}
				classObj = (T)r;
			}
			documentList.add(classObj);
		}
		sr.setData(documentList);
		return sr;
	}
	/**
	 * getStoriesCategoryCount is used to return count of articles in category for category passed
	 * @param category
	 * @return
	 */
	/**
	 * Sample query - (and (range field=effective_end_date ['',})(range field=display_start_date {,'']) (and (term field=category '')))
	 */
	public Long getStoriesCategoryCount(String category) throws Exception{
		SearchRequest searchRequest = new SearchRequest();
		StringBuilder query = new StringBuilder();
		query.append("(and (range field=effective_end_date ['")
			.append(new Date().toInstant().toString()).append("',}) (range field=display_start_date {,'")
			.append(new Date().toInstant().toString()).append("'])");
		if(StringUtils.isNotBlank(category) && !"*".equalsIgnoreCase(category)) {
			query.append(" (and (term field=category '").append(category).append("'))");;
		}
		query.append(")");
		searchRequest.setReturn("category");
		searchRequest.setQuery(query.toString());
		searchRequest.setQueryParser(QueryParser.Structured);
		SearchResult results = amazonCloudSearchDomainClient.search(searchRequest);
		return results.getHits().getFound();
	}
}
