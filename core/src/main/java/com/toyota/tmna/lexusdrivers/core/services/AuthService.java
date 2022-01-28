package com.toyota.tmna.lexusdrivers.core.services;

public interface AuthService {

	String getBrandName();

	String getClientid();

	String getClientSecret();

	String getRedirectURI();

	String getHomeRedirect();

	String getDomain();

	String getScopes();

	Boolean getUseEnvTokenName();

	String getLoginRedirectURI();

	String getCookieDomain();

	String getIdTokenCookieName();

	String getAuthorize();

	String getoAuth();

	String getToken();

	String getJson();

	String getLogOut();

	String getTenant();

	String[] getRoles();

	String getDefaultLandingPage();

	String getErrorPagePath();
	
	String getHomePath();
	
	String[] getNoLandingPages();

	String getLogoutRedirect();

}
