package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.toyota.tmna.lexusdrivers.core.services.AuthTokensService;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

@Component(service = Servlet.class, property = { "sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
		"sling.servlet.selectors=" + "oAuthTokens", "sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS })
public class OAuthTokenization extends SlingSafeMethodsServlet {
	private static final long serialVersionUID = 1L;
	private static final String URL_ENCODED = "application/x-www-form-urlencoded";
	private static final Logger LOGGER = LoggerFactory.getLogger(OAuthTokenization.class);
	private static final String GRANT_TYPE = "grant_type";
	private static final String CLIENT_SECRET = "client_secret";
	private static final String CLIENT_ID = "client_id";
	private static final String CONTENT_TYPE = "Content-Type";
	@Reference
	private transient AuthTokensService authService;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String serviceNameRequest = request.getParameter("serviceName");
		HttpPost post = makeOAuthRequest(request, serviceNameRequest);
		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse closeableResp = httpClient.execute(post)) {

			if (closeableResp != null) {

				String result = EntityUtils.toString(closeableResp.getEntity());
				JSONObject jsonObject = new JSONObject(result);
				JsonObject jsonObj = new JsonObject();
				jsonObj.addProperty("AccessToken", (String) jsonObject.get("access_token"));
				jsonObj.addProperty("Resource", (String) jsonObject.get("resource"));

				Gson gson = new Gson();
				String json = gson.toJson(jsonObj);

				LOGGER.info("result from POST oAuth call is:" + result);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(json);
				out.flush();
				out.close();

			}
		} catch (JSONException e) {
			LOGGER.error(" Error occured during oauth  : {0}", e);
		}

	}

	private HttpPost makeOAuthRequest(SlingHttpServletRequest request, String serviceName)
			throws UnsupportedEncodingException {
		String url = authService.getTenantUrl() + authService.getTenantId() + authService.getTenantPath();
		HttpPost post = new HttpPost(url);
		post.setHeader(CONTENT_TYPE, URL_ENCODED);
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		String serviceNames = getServiceName(serviceName);
		LOGGER.info("auth service check in public services" + serviceNames);
		String resourceUrl = authService.getResourceUrl() + serviceNames;

		nameValuePairs.add(new BasicNameValuePair("resource", resourceUrl));
		nameValuePairs.add(new BasicNameValuePair(CLIENT_ID, authService.getClientId()));
		nameValuePairs.add(new BasicNameValuePair(GRANT_TYPE, "client_credentials"));
		nameValuePairs.add(new BasicNameValuePair(CLIENT_SECRET, authService.getClientSecret()));
		LOGGER.debug("nameValuePairs:" + nameValuePairs);
		HttpEntity entity = new UrlEncodedFormEntity(nameValuePairs);
		post.setEntity(entity);
		return post;

	}

	private String getServiceName(String requestName) {
		switch (requestName) {
		case "modelYear":
			return authService.getModelYear();
		case "masterPreferences":
			return authService.getMasterPreferences();
		case "manuals":
			return authService.getManuals();
		case "safetyCampaign":
			return authService.getSafetyCampaign();
		case "maintenanceScheduleVin":
			return authService.getMaintenanceScheduleVin();
		case "maintenanceScheduleDmy":
			return authService.getMaintenanceScheduleDMY();
		case "maintenanceScheduleEtd":
			return authService.getMaintenanceScheduleETD();
		case "vehicleSpecs":
			return authService.getVehicleSpecs();
		case "telematicsInfo":
			return authService.getTelematicsInfo();
		default:
			return "";
		}

	}

}
