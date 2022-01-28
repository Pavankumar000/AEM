package com.toyota.tmna.lexusdrivers.core.util;

import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;

public class HandlerParamUtil {
	private static final String DEALER_ZIP = "dealer-last-search-dealerZip";
    public static String getId(SlingHttpServletRequest request){
        return request.getParameter("id") != null ? request.getParameter("id").trim() : StringUtils.EMPTY;

    }

    public static String getType(SlingHttpServletRequest request){
        return request.getParameter("type") != null ? request.getParameter("type").trim() : StringUtils.EMPTY;

    }

    public static String getState(SlingHttpServletRequest request){
        return request.getParameter("state") != null ? request.getParameter("state").trim() : StringUtils.EMPTY;

    }

    public static String getZip(SlingHttpServletRequest request){
    	String zip;
    	if(request.getParameter("zip") != null) {
    		zip = request.getParameter("zip").trim();
    	}else {
    		zip = AEMServletUtil.getCookieToken(request, DEALER_ZIP);
    	}
        return zip;
    }

    public static String getStartIndex(SlingHttpServletRequest request){
        return request.getParameter("start_index") != null ? request.getParameter("start_index").trim() : StringUtils.EMPTY;

    }

    public static String getCategory(SlingHttpServletRequest request){
        return request.getParameter("category") != null ? request.getParameter("category").trim() : StringUtils.EMPTY;

    }

    public static String getSize(SlingHttpServletRequest request){
        return request.getParameter("size") != null ? request.getParameter("size").trim() : StringUtils.EMPTY;

    }
    
    public static String getModel(SlingHttpServletRequest request) {
    	return request.getParameter("model") != null ? request.getParameter("model").trim() : StringUtils.EMPTY;
    }
    
    public static String getYear(SlingHttpServletRequest request) {
    	return request.getParameter("year") != null ? request.getParameter("year").trim() : StringUtils.EMPTY;
    }
    
    public static String getTopic(SlingHttpServletRequest request) {
    	return request.getParameter("vTopic") != null ? request.getParameter("vTopic").trim() : StringUtils.EMPTY;
    }
    
    public static String getKeyword(SlingHttpServletRequest request) {
    	return request.getParameter("key") != null ? request.getParameter("key").trim() : StringUtils.EMPTY;
    }
}
