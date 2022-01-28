package com.toyota.tmna.lexusdrivers.core.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
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
import org.jose4j.base64url.Base64;
import org.json.JSONException;
import org.json.JSONObject;
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
				"sling.servlet.selectors=" + "login",
				"sling.servlet.extensions=" + ConstantsUtil.SERVLET_EXTENSIONS})
public class LoginHandler extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginHandler.class);
	private static final String ACCESS_TOKEN = "access_token";
	private static final String ERROR_DESCRIPTION = "error_description";
	private static final String PARAM_CODE = "code";
	private static final String PARAM_STATE = "state";
	private static final String URI_STATE = "&state=";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String URL_ENCODED = "application/x-www-form-urlencoded";
	private static final String ACCEPTS = "Accepts";
	private static final String APP_JSON = "application/json";
	private static final String CLIENT_ID = "client_id";
	private static final String REDIRECT_URI = "redirect_uri";
	private static final String GRANT_TYPE = "grant_type";
	private static final String CLIENT_SECRET = "client_secret";
	private static final String AUTH_CODE = "authorization_code";
	private static final String REQUEST_FORWARD_SLASHS = "://";

	@Reference
	private transient AuthService authService;


	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		String authCode = request.getParameter(PARAM_CODE);

		LOGGER.info("Login Handler Header Object Referrer Header Value= "+ request.getHeader(HttpHeaders.REFERER));
		LOGGER.info("Login Handler State request.getParameter(PARAM_STATE) = "+ request.getParameter(PARAM_STATE));
		LOGGER.info("Login Handler State Host header is  = "+AEMServletUtil.getHostHeaderInformation(request, authService.getCookieDomain()));

		if (null == authCode) {
			LOGGER.info("null == authCode");
			executeLogin(request, response);
			return;
		}

		HttpPost post = getPostCallDetails(authCode,request);

		try (CloseableHttpClient httpClient = HttpClients.createDefault(); CloseableHttpResponse closeableResp = httpClient.execute(post)) {
					
			
			if(closeableResp!=null) {

				String result = EntityUtils.toString(closeableResp.getEntity());

				LOGGER.info("result from POST call is:"+result);

				JSONObject jsonObject = new JSONObject(result);


				if (closeableResp.getStatusLine()!=null && closeableResp.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
					String redirectUrl = AEMServletUtil.getHostHeaderInformation(request, authService.getCookieDomain())+authService.getHomePath()+"?errorcode="+closeableResp.getStatusLine().getStatusCode();
					LOGGER.info("result is "+ result + "and  HttpStatus.SC_NOT_OK response.sendRedirect(redirectUrl) : "+redirectUrl);
					response.sendRedirect(redirectUrl);

					//throw new ServletException((String) jsonObject.get(ERROR_DESCRIPTION));

				} else {

					final String idToken = (String) jsonObject.get(ConstantsUtil.ID_TOKEN);
					final String accessToken = (String) jsonObject.get(ACCESS_TOKEN);

					LOGGER.info(" HttpStatus.SC_OK");

					//LOGGER.info("idtoken :: {}", idToken);

					/*LDA-4238 for protected pages:
					**Check if last viewcar cooke is present and clear it before stting login for the session
					*/
					if (Boolean.TRUE.equals(AEMServletUtil.isValidCookie(request, ConstantsUtil.LAST_VIEWED_CARS_TOKEN))) {
							AEMServletUtil.resetCookie(request, response, ConstantsUtil.LAST_VIEWED_CARS_TOKEN);
					}
					AEMServletUtil.createCookie(ACCESS_TOKEN, accessToken, response);
					AEMServletUtil.createCookie(ConstantsUtil.ID_TOKEN, idToken, response);
					AEMServletUtil.createNonHttpCookie(ConstantsUtil.LOGGED_IN, "true", response);
					LOGGER.info("cookie created");

					String redirectUrl = getRedirectUrl(request);

					LOGGER.info("getRedirectUrl  value:: "+redirectUrl);

					response.sendRedirect(redirectUrl);

				}

			} /*
			 * catch (ServletException e) {
			 * LOGGER.error(" Error occured during Login : {0}", e);
			 *
			 * }
			 */
		} catch (JSONException e) {
			LOGGER.error(" Error occured during Login : {0}", e);
		}catch (Exception e){
			LOGGER.error(" Error occured during Login : {0}", e);
			String redirect = AEMServletUtil.getHostHeaderInformation(request , authService.getCookieDomain())+authService.getHomePath();
			LOGGER.error("redirect value:: "+redirect);
			response.sendRedirect(redirect);
		}
	}

	private void executeLogin(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
		
		String referrer = null;
		if (!StringUtils.isEmpty(request.getParameter(REDIRECT_URI))) {
			referrer = request.getScheme()+REQUEST_FORWARD_SLASHS+authService.getCookieDomain()+request.getParameter(REDIRECT_URI);
			LOGGER.info("!StringUtils.isEmpty(request.getParameter(REDIRECT_URI)) , referrer = "+referrer);
		}
		
		if (StringUtils.isEmpty(referrer)) {
			referrer = request.getParameter(PARAM_STATE);
			LOGGER.info("StringUtils.isEmpty(referrer) , request.getParameter(PARAM_STATE)  =  referrer = "+referrer);
			
		}
		if (StringUtils.isEmpty(referrer)) {
			referrer = request.getHeader(HttpHeaders.REFERER);
			LOGGER.info("StringUtils.isEmpty(referrer) , request.getHeader(HttpHeaders.REFERER) = referrer = "+referrer);
		}
		referrer = AEMServletUtil.getValidReferer(referrer, authService);
		
		LOGGER.info("AEMServletUtil.getValidReferer(referrer, authService), referrer = "+referrer);

		if (Boolean.TRUE.equals(AEMServletUtil.isValidCookie(request, ConstantsUtil.ID_TOKEN))) {
			LOGGER.info("Now creating loggedIn cookie");
			AEMServletUtil.createNonHttpCookie(ConstantsUtil.LOGGED_IN, "true", response);
			LOGGER.info("Boolean.TRUE.equals(AEMServletUtil.isValidCookie(request, ConstantsUtil.ID_TOKEN))");
			LOGGER.info("response.sendRedirect(referrer) : referrer : "+referrer);
			response.sendRedirect(referrer);
			
		}else {
			LOGGER.info("id_token is not present- In else");
		}
		LOGGER.info(" Referrer Before Encoding = {}", referrer);
		String encodedState = Base64.encode(referrer.getBytes());

		String loginUri = authService.getLoginRedirectURI();
		
		LOGGER.info(" loginUri =" + loginUri);
		
		loginUri = MessageFormat.format(loginUri, AEMServletUtil.getHostHeaderInformation(request, authService.getCookieDomain()));
		
		String finalUri = loginUri.concat(URI_STATE).concat(encodedState);
	
		LOGGER.info("response.sendRedirect(finalUri) :: final uri :  "+finalUri);
		response.sendRedirect(finalUri);
	
	}


	private HttpPost getPostCallDetails(String authCode,SlingHttpServletRequest request) throws UnsupportedEncodingException {

		HttpPost post = new HttpPost(buildTokenEndpointUrl());
		post.setHeader(CONTENT_TYPE, URL_ENCODED);
		post.setHeader(ACCEPTS, APP_JSON);
		
		String redirectURI = MessageFormat.format(authService.getRedirectURI(), AEMServletUtil.getHostHeaderInformation(request, authService.getCookieDomain()));

		LOGGER.info("authService.getRedirectURI() formatted "+redirectURI );
		
		//LOGGER.info("Client Secret Decrypted="+authService.getClientSecret() );
		List<NameValuePair> nameValuePairs = new ArrayList<>();
		nameValuePairs.add(new BasicNameValuePair(CLIENT_ID, authService.getClientid()));
		nameValuePairs.add(new BasicNameValuePair(REDIRECT_URI, redirectURI));
		nameValuePairs.add(new BasicNameValuePair(PARAM_CODE, authCode));
		nameValuePairs.add(new BasicNameValuePair(GRANT_TYPE, AUTH_CODE));
		nameValuePairs.add(new BasicNameValuePair(CLIENT_SECRET, authService.getClientSecret()));
		
		LOGGER.info("nameValuePairs:"+nameValuePairs );
		HttpEntity entity = new UrlEncodedFormEntity(nameValuePairs);
		post.setEntity(entity);

		return post;
	}



	private String getRedirectUrl(SlingHttpServletRequest request) throws UnsupportedEncodingException {

		String state = request.getParameter(PARAM_STATE);
		if (null != state && state.length() > 0) {
			return /*
					 * AEMServletUtil.getHostHeaderInformation(request,
					 * authService.getCookieDomain())+
					 */AEMServletUtil.handleState(state);
		} else {
			return /*
					 * AEMServletUtil.getHostHeaderInformation(request,
					 * authService.getCookieDomain())+
					 */AEMServletUtil.getValidReferer(StringUtils.EMPTY, authService);
		}
	}

	private String buildTokenEndpointUrl() {

		StringBuilder sb = new StringBuilder();
		sb.append(authService.getDomain()).append(authService.getTenant()).append(authService.getoAuth()).
				append(authService.getBrandName()).append(authService.getToken());
		LOGGER.info("buildTokenEndpointUrl is:"+sb.toString());
		return sb.toString();
	}
}
