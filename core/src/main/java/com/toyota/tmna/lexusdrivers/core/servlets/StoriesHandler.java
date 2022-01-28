package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import com.toyota.tmna.lexusdrivers.core.util.HandlerParamUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.eclipse.jetty.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.services.StoriesService;
import com.toyota.tmna.lexusdrivers.core.services.AuthService;
import com.toyota.tmna.lexusdrivers.core.util.AEMServletUtil;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

@Component(service = Servlet.class,
        property = {
                "sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
                "sling.servlet.selectors=" + "stories",
                "sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS})
public class StoriesHandler extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(StoriesHandler.class);

    @Reference
    private transient  StoriesService storiesService;
    private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    protected void doGet(@NotNull SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.info("inside Story handler");
        PrintWriter out = response.getWriter();
        SearchResponse storiesResponse = new SearchResponse();
        if (StringUtil.isNotBlank(HandlerParamUtil.getCategory(request)) && StringUtil.isBlank(HandlerParamUtil.getId(request))) {
            storiesResponse = storiesService.getAllStoriesOrByCategory(HandlerParamUtil.getStartIndex(request), HandlerParamUtil.getSize(request), HandlerParamUtil.getCategory(request));
        } else if (StringUtil.isNotBlank(HandlerParamUtil.getType(request)) && "related".equalsIgnoreCase(HandlerParamUtil.getType(request)) && StringUtils.isNotBlank(HandlerParamUtil.getId(request))) {
            storiesResponse = storiesService.getRelatedStories(HandlerParamUtil.getCategory(request), HandlerParamUtil.getId(request));
        } else if (StringUtil.isNotBlank(HandlerParamUtil.getId(request)) && StringUtils.isBlank(HandlerParamUtil.getType(request))) {
            storiesResponse = storiesService.getStoriesById(HandlerParamUtil.getId(request));
        }
        String storiesStr = objectMapper.writeValueAsString(storiesResponse);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(storiesStr);
        out.flush();
        out.close();	
    }
}
