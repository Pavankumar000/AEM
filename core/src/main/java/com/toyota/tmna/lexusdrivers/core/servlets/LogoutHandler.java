package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.toyota.tmna.lexusdrivers.core.services.AuthService;
import com.toyota.tmna.lexusdrivers.core.util.AEMServletUtil;
import com.toyota.tmna.lexusdrivers.core.util.ConstantsUtil;

@Component( service = Servlet.class,
property = {
"sling.servlet.resourceTypes =" + ConstantsUtil.SERVLET_RESOURCE_TYPE,
"sling.servlet.selectors=" + "logout",
"sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS})
public class LogoutHandler extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(LogoutHandler.class);
	private static final String ACCESS_TOKEN = "access_token";
	private static final String JSESSION_TOKEN = "JSESSIONID";
	

	@Reference
	private transient AuthService authService;


	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException{

		LOGGER.info("Logout Servlet Called ");
		
		try {
			String idToken = AEMServletUtil.getCookieToken(request, ConstantsUtil.ID_TOKEN);		
			String accessToken = AEMServletUtil.getCookieToken(request, ACCESS_TOKEN);
			String referrer = request.getHeader(ConstantsUtil.REFERER);
			
			//LOGGER.info(" Request Session "+AEMServletUtil.getUser(request) ); 
			try {
				
				AEMServletUtil.resetCookie(request, response, ConstantsUtil.LAST_VIEWED_CARS_TOKEN);
				logoutIdp(idToken, accessToken, request);
			}
			catch (ServletException | IOException  se) {
				LOGGER.error("Servlet / IO Exception " +se);
			}
			AEMServletUtil.resetCookie(request, response, ConstantsUtil.ID_TOKEN);
			LOGGER.info(" ID Token Cookie Value  "+request.getCookie(ConstantsUtil.ID_TOKEN));
			
			AEMServletUtil.resetCookie(request, response, ACCESS_TOKEN);
			LOGGER.info(" Access TOKEN Cookie Value  "+request.getCookie(ACCESS_TOKEN));
			
			AEMServletUtil.resetCookie(request, response, JSESSION_TOKEN);
			LOGGER.info(" JSESSION Cookie Value  "+request.getCookie(JSESSION_TOKEN));
			
			AEMServletUtil.resetCookie(request, response, ConstantsUtil.LOGGED_IN);
			LOGGER.info(" LoggedIn Cookie Value  "+request.getCookie(ConstantsUtil.LOGGED_IN));

			//AEMServletUtil.removeUser(request);
			request.getSession(false);
		    request.getSession().invalidate();
			if(request.getSession(false)!=null) {
				request.getSession().invalidate();
			}
			LOGGER.info("Before Calling User Redirect ");
			userRedirect(response,referrer,request);
		} catch (IllegalStateException e) {
			LOGGER.error("Error occured during logout." +e);
		}
	}
	
	public void logoutIdp(String idToken, String accessToken, SlingHttpServletRequest request) throws ServletException, IOException {

		LOGGER.warn("Invalidate id token with postURI ");

		String endSessionUrl = buildEndSessionUrl(request) + "?id_token_hint=" + idToken + "&client_id="
				+ authService.getClientid();
		LOGGER.info(" URL logout : {}", endSessionUrl);
		URI uri = URI.create(endSessionUrl);

		HttpGet hGet = new HttpGet(uri);

		try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse closeableResp = httpClient.execute(hGet)) {
			hGet.setHeader("Authorization", "Bearer " + accessToken);
			if (closeableResp!=null && closeableResp.getStatusLine()!=null && closeableResp.getStatusLine().getStatusCode() != HttpStatus.SC_NO_CONTENT) {
				throw new ServletException(closeableResp.getStatusLine().getReasonPhrase() + closeableResp.getStatusLine().getStatusCode());
			}
			
			LOGGER.info(" IDP call status is 204");
			
		}

	}

	private String buildEndSessionUrl(SlingHttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		sb.append(authService.getDomain()).append(authService.getTenant()).append(authService.getoAuth())
				.append(authService.getBrandName()).append(authService.getLogOut());
		
		return sb.toString();	}


	public void userRedirect(SlingHttpServletResponse response,String referrer,SlingHttpServletRequest request) {
		try {
			LOGGER.info(" Referrer URL= {} ", referrer);
			String redirectUrl  = AEMServletUtil.getValidReferer(referrer, authService);
			LOGGER.info(" Redirect URL  = {} ", redirectUrl);
			String redirectIdp = authService.getDomain()+authService.getLogoutRedirect()
			+URLEncoder.encode(redirectUrl,"UTF-8");
			
			LOGGER.info(" IDP redirect : {}", redirectIdp);	
			
			response.sendRedirect(redirectIdp);
			LOGGER.info("redirectIdp value:: "+redirectIdp);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("Redirect failed with exception: ", e);
		} catch (IOException ioe) {
			LOGGER.error("Redirect failed with exception: ", ioe);
		}
	}

}
