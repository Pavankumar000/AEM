package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

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
import com.toyota.tmna.lexusdrivers.core.search.services.RewardsService;
import com.toyota.tmna.lexusdrivers.core.services.AuthService;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;
import com.toyota.tmna.lexusdrivers.core.util.HandlerParamUtil;

@Component(service = Servlet.class, property = { "sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
		"sling.servlet.selectors=" + "rewards", "sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS })
public class RewardsHandler extends SlingAllMethodsServlet {

	@Reference
	private transient RewardsService rewardsService;
	@Reference
	private transient AuthService authService;
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(RewardsHandler.class);
	private final ObjectMapper objectMapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	public static final String TYPE_REWARDS = "rewards";
	public static final String TYPE_RELATED = "related";
	public static final String TYPE_STATES = "states";
	public static final String TYPE_CATEGORIES = "categories";

	@Override
	protected void doGet(@NotNull SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		LOGGER.info("inside rewards handler");
		SearchResponse rewardsResponse = new SearchResponse();
		List<String> categoryList = new ArrayList<String>();
		String rewardsStr = StringUtils.EMPTY;
		String type = HandlerParamUtil.getType(request);

		switch (type) {
		case TYPE_RELATED:
			rewardsResponse = rewardsService.getRelatedRewards(HandlerParamUtil.getCategory(request),
					HandlerParamUtil.getId(request), HandlerParamUtil.getZip(request));
			break;
		case TYPE_CATEGORIES:
			categoryList = rewardsService.getAllRewardCategories(HandlerParamUtil.getState(request));
			break;
		case TYPE_STATES:
			categoryList = rewardsService.getAllRewardStates();
			break;
		case TYPE_REWARDS:
			rewardsResponse = rewardsService.getRewardsAndEvents(HandlerParamUtil.getState(request),
					HandlerParamUtil.getCategory(request), HandlerParamUtil.getType(request),
					HandlerParamUtil.getZip(request), HandlerParamUtil.getStartIndex(request),
					HandlerParamUtil.getSize(request));
			break;
		default:
			rewardsResponse = rewardsService.getRewardsById(HandlerParamUtil.getId(request));
			break;
		}

		if (rewardsResponse != null) {
			rewardsStr = objectMapper.writeValueAsString(rewardsResponse);
		}
		if (!categoryList.isEmpty()) {
			rewardsStr = objectMapper.writeValueAsString(categoryList);
		}
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(rewardsStr);
		out.flush();
	}

}
