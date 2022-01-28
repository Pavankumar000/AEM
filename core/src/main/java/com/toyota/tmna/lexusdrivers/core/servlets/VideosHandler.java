package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.toyota.tmna.lexusdrivers.core.util.HandlerParamUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.jetbrains.annotations.NotNull;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.services.VideosService;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
                "sling.servlet.selectors=" + "videos",
                "sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS})
public class VideosHandler extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(VideosHandler.class);

    @Reference
    private transient VideosService videosService;
    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static final String TYPE_RELATED = "related";
    private static final String TYPE_CATEGORIES = "categories";
    @Override
    protected void doGet(@NotNull SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.info("inside videos handler");
        PrintWriter out = response.getWriter();
        SearchResponse videosResponse = new SearchResponse();
        List<String> categoryList = new ArrayList<String>();
        String type = HandlerParamUtil.getType(request);
        String videosStr = StringUtils.EMPTY;
		switch (type) {
		case TYPE_RELATED:
            videosResponse = videosService.getRelatedVideos(HandlerParamUtil.getId(request), HandlerParamUtil.getModel(request), HandlerParamUtil.getYear(request));
			break;
		case TYPE_CATEGORIES:
            categoryList = videosService.getCategories(HandlerParamUtil.getModel(request), HandlerParamUtil.getYear(request), HandlerParamUtil.getTopic(request));
			break;
		default:
			if(!StringUtils.isNotBlank(HandlerParamUtil.getId(request)))
	            videosResponse = videosService.getVideos(HandlerParamUtil.getModel(request), HandlerParamUtil.getYear(request), HandlerParamUtil.getCategory(request), HandlerParamUtil.getKeyword(request), HandlerParamUtil.getTopic(request), HandlerParamUtil.getStartIndex(request), HandlerParamUtil.getSize(request));
			else
				videosResponse = videosService.getVideosById(HandlerParamUtil.getId(request));
			break;
		}
       
        if (videosResponse != null) {
            videosStr = objectMapper.writeValueAsString(videosResponse);
        }
        if (!categoryList.isEmpty()) {
            videosStr = objectMapper.writeValueAsString(categoryList);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(videosStr);
        out.flush();
        out.close();
    }

}
