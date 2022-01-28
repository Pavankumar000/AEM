package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

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
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.services.DisclaimerService;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

@Component(service = Servlet.class, property = { "sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
		"sling.servlet.selectors=" + "disclaimers",
		"sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS })
public class DisclaimerDataHandler extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(DisclaimerDataHandler.class);

	@Reference
	private transient DisclaimerService disclaimerService;

	private final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	@Override
	protected void doGet(@NotNull SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		SearchResponse disclaimerResponse;
		String disclaimerStr;
		String disclaimersID = request.getParameter(ConstantsUtil.DISCLAIMERS_ID);
		String description = null;
		String id = null;
		Map<String, String> disclaimersData = new HashMap<>();
		if (disclaimersID != null) {
			if (!disclaimersID.equalsIgnoreCase(StringUtils.EMPTY)) {
				disclaimerResponse = disclaimerService.getDisclaimerById(disclaimersID);
				disclaimerStr = objectMapper.writeValueAsString(disclaimerResponse.getData());
				JsonElement jsonElement = new JsonParser().parse(disclaimerStr);
				JsonArray jsonArray = jsonElement.getAsJsonArray();
				for (JsonElement element : jsonArray) {
					description = element.getAsJsonObject().get("description").getAsString();
					id = element.getAsJsonObject().get("id").getAsString();
					disclaimersData.put(id, description);
				}
			}
			Gson gson = new Gson();
			String jsonObject = gson.toJson(disclaimersData);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(jsonObject);
		}
		out.flush();
		out.close();
	}

}
