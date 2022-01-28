package com.toyota.tmna.lexusdrivers.core.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.jose4j.base64url.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.toyota.tmna.lexusdrivers.core.bean.UserInfo;
import com.toyota.tmna.lexusdrivers.core.services.AuthService;

/**
 * @author Srikanta Panda
 *
 */
public class AEMServletUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(AEMServletUtil.class);
	private static final String USER = "user";
	private static final String HTTPS_URL = "https://";
	private static final String KEY_GIVEN_NAME = "given_name";
	private static final String KEY_FAMILY_NAME = "family_name";
	private static final String KEY_EMAILS = "emails";
	private static final String KEY_SIGNIN_TYPE = "signInType";

	/**
	 * 
	 * @param cookieName
	 * @param response
	 * @param cookieValue
	 */
	public static void createCookie(String cookieName, String cookieValue, SlingHttpServletResponse response) {

		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
		cookie.setMaxAge(-1);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	public static void createNonHttpCookie(String cookieName, String cookieValue, SlingHttpServletResponse response) {
		LOGGER.info("Creating Non Http Cookie::"+cookieName);
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(-1);
		cookie.setHttpOnly(false);
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	/**
	 * 
	 * @param url
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String handleState(String url) throws UnsupportedEncodingException {
		String returnValue = url;
		if (url != null && !url.isEmpty()) {
			returnValue = new String(Base64.decode(URLDecoder.decode(url, "UTF-8")), "UTF-8");
			if (returnValue.contains("\\r"))
				returnValue = returnValue.substring(0, returnValue.indexOf("\\r"));
			if (returnValue.contains("\\n"))
				returnValue = returnValue.substring(0, returnValue.indexOf("\\n"));
		}
		return returnValue;
	}

	/**
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static Boolean isValidCookie(SlingHttpServletRequest request, String cookieName) {

		Cookie cookie = request.getCookie(cookieName);
		if (cookie == null || StringUtils.isEmpty(cookie.getValue())) {
			LOGGER.info("Cookie "+cookieName+" isValid::False");
			return Boolean.FALSE;
		} else {
			LOGGER.info("Cookie "+cookieName+" isValid::True");
			return Boolean.TRUE;
		}
	}

	public static UserInfo getUser(final SlingHttpServletRequest request) {
		LOGGER.info(" Request " + (request != null));
		if (request == null) {
			return null;
		}
		try {
			Cookie id_token = request.getCookie(ConstantsUtil.ID_TOKEN);
			if (id_token != null) {
				return AEMServletUtil.createUser(id_token.getValue());
			}
		} catch (JsonIOException e) {
			LOGGER.error(" AEMServletUtil: getUser: " + e);
		}

		return null;
	}

	public static void setUser(final SlingHttpServletRequest request, final UserInfo user) {
		HttpSession session = request.getSession();
		session.setAttribute(USER, user);

	}

	public static void removeUser(final SlingHttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(USER);

	}

	public static JsonObject getErrorJson(String errorMessage) {

		JsonObject errorJson = new JsonObject();
		try {
			errorJson.addProperty("status", "Error");
			errorJson.addProperty("message", errorMessage);
		} catch (JsonIOException e) {
			LOGGER.error(" Exception while creating error response JSON : {0}", e);
		}
		return errorJson;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param cookieName
	 */
	public static void resetCookie(SlingHttpServletRequest request, SlingHttpServletResponse response,
			String cookieName) {

		Cookie cookie = getCookie(request, cookieName);
		if (cookie != null) {
			LOGGER.info(" reset cookie" + cookieName + " called::" + cookie.toString());
			LOGGER.info(" reset cookie" + cookieName + " value::" + cookie.getValue());
			cookie.setValue(null);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		} else {
			LOGGER.info("cookie was not reset ::" + cookieName);
		}
	}

	private static Cookie getCookie(SlingHttpServletRequest req, String cname) {
		if (req != null && req.getCookies() != null) {
			for (Cookie c : req.getCookies()) {
				if (c.getName().equals(cname)) {
					return c;
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param request
	 * @param tokenName
	 * @return
	 */
	public static String getCookieToken(SlingHttpServletRequest request, String tokenName) {

		Cookie cookie = request.getCookie(tokenName);
		return cookie != null ? cookie.getValue() : StringUtils.EMPTY;
	}

	/**
	 * @param referrer
	 * @param authService
	 * @return
	 */
	public static String getValidReferer(String referrer, AuthService authService) {
		String defaultLandingPage = HTTPS_URL + authService.getCookieDomain() + authService.getHomePath();
		if (StringUtils.isNotEmpty(referrer)) {
			for (String noLandingPage : authService.getNoLandingPages()) {
				if (referrer.contains(noLandingPage)) {
					return defaultLandingPage;
				}
			}
		} else {
			return defaultLandingPage;
		}

		if (StringUtils.equalsIgnoreCase(defaultLandingPage, referrer)) {
			return defaultLandingPage;
		}

		return referrer;

	}

	/**
	 * Method to get Host/ Servername information from request.
	 * 
	 * @param request
	 * @return
	 */
	public static String getHostHeaderInformation(SlingHttpServletRequest request, String defaultValue) {

		LOGGER.info(" getHostHeaderInformation - enter");
		String host = request.getHeader("Host");
		LOGGER.info("getHostHeaderInformation host value:: " + host);

		if (null == host) {
			host = HTTPS_URL + defaultValue;
			LOGGER.info("getHostHeaderInformation (host) ServerName value:: " + host);
		}

		if (!host.startsWith(HTTPS_URL)) {
			host = HTTPS_URL + host;
		}

		LOGGER.info(" getHostHeaderInformation - exit with host value:" + host);
		return host;
	}

	/**
	 * Generic method to log the header key values
	 * 
	 * @param request
	 * @return
	 */
	public static Map<String, String> getHeaderInformation(SlingHttpServletRequest request) {

		Map<String, String> map = new HashMap<String, String>();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			LOGGER.info("Header Key : " + key + " value ::" + value);
			map.put(key, value);
		}
		return map;
	}

	public static UserInfo createUser(String idToken){
		JsonParser parser = new JsonParser();
		JsonObject tokenJson = parser.parse(decodeJWTToken(idToken)).getAsJsonObject();
		UserInfo user = new UserInfo();
		user.setFirstName(tokenJson.get(KEY_GIVEN_NAME).getAsString());
		user.setLastName(tokenJson.get(KEY_FAMILY_NAME).getAsString());
		user.setSigninType(tokenJson.get(KEY_SIGNIN_TYPE).getAsString());
		user.setIdToken(idToken);
		JsonArray array = tokenJson.getAsJsonArray(KEY_EMAILS);
		for (int i = 0; i < array.size(); i++) {
			user.getEmail().add(array.get(i).getAsString());
		}

		return user;
	}

	public static String decodeJWTToken(String token) {

		String jwtToken = token;
		String[] splitToken = jwtToken.split("\\.");
		String base64EncodedBody = splitToken[1];
		return new String(Base64.decode(base64EncodedBody));
	}

}