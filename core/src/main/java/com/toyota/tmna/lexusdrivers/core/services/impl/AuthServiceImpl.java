package com.toyota.tmna.lexusdrivers.core.services.impl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import com.toyota.tmna.lexusdrivers.core.services.AuthService;

@Component(service=AuthService.class, immediate = true)
@Designate(ocd=AuthServiceImpl.AuthPropertyService.class)
public class AuthServiceImpl implements AuthService{
	
	private String brandName;
	private String clientid;
	private String clientSecret;
	private String redirectURI;
	private String homeRedirect;
	private String domain;
	private String scopes;
	private Boolean useEnvTokenName;
	private String loginRedirectURI;
	private String cookieDomain;
	private String idTokenCookieName;
	private String authorize;
	private String oAuth;
	private String token;
	private String json;
	private String logOut;
	private String tenant;
	private String[] roles;
	private String defaultLandingPage;
	private String errorPagePath;
	private String homePath;
	private String[] noLandingPages;
	private String logoutRedirect;
	
	
	@Activate
	public void activate(AuthPropertyService config) {
		this.brandName = config.getBrandName();
		this.clientid = config.getClientid();
		this.clientSecret = config.getClientSecret();
		this.redirectURI = config.getRedirectURI();
		this.homeRedirect = config.getHomeRedirect();
		this.domain = config.getDomain();
		this.scopes = config.getScopes();
		this.useEnvTokenName = config.isUseEnvTokenName();
		this.loginRedirectURI = config.getLoginRedirectURI();
		this.cookieDomain = config.getCookieDomain();
		this.idTokenCookieName = config.getIdTokenCookieName();
		this.authorize = config.getAuthorize();
		this.oAuth = config.getOAuth();
		this.token = config.getToken();
		this.json = config.getJson();
		this.logOut =config.getLogout();
		this.tenant = config.getTenant();
		this.roles = config.getRoles();
		this.defaultLandingPage = config.getDefaultLandingPage();
		this.errorPagePath = config.getErrorPagePath();
		this.homePath = config.getHomePath();
		this.noLandingPages = config.getNoLandingPages();
		this.logoutRedirect = config.getLogoutRedirect();
	}

	@Override
	public String getBrandName() {
		return brandName;
	}

	@Override
	public String getClientid() {
		return clientid;
	}

	@Override
	public String getClientSecret() {
		return clientSecret;
	}

	@Override
	public String getRedirectURI() {
		return redirectURI;
	}

	@Override
	public String getHomeRedirect() {
		return homeRedirect;
	}

	@Override
	public String getDomain() {
		return domain;
	}

	@Override
	public String getScopes() {
		return scopes;
	}

	@Override
	public Boolean getUseEnvTokenName() {
		return useEnvTokenName;
	}

	@Override
	public String getLoginRedirectURI() {
		return loginRedirectURI;
	}

	@Override
	public String getCookieDomain() {
		return cookieDomain;
	}

	@Override
	public String getIdTokenCookieName() {
		return idTokenCookieName;
	}

	@Override
	public String getAuthorize() {
		return authorize;
	}

	@Override
	public String getoAuth() {
		return oAuth;
	}

	@Override
	public String getToken() {
		return token;
	}

	@Override
	public String getJson() {
		return json;
	}

	@Override
	public String getLogOut() {
		return logOut;
	}

	@Override
	public String getTenant() {
		return tenant;
	}

	@Override
	public String[] getRoles() {
		return roles.clone();
	}

	@Override
	public String getDefaultLandingPage() {
		return defaultLandingPage;
	}

	@Override
	public String getErrorPagePath() {
		return errorPagePath;
	}
	
	@Override
	public String getHomePath() {
		return homePath;
	}

	@Override
	public String[] getNoLandingPages() {
		return noLandingPages.clone();
	}
	
	@Override
	public String getLogoutRedirect() {
		return logoutRedirect;
	}

	@ObjectClassDefinition(name = "Lexus Drivers OAuth properties")
	public @interface AuthPropertyService {
		
		@AttributeDefinition(name="Brand Name", type=AttributeType.STRING)
		String getBrandName();
		
		@AttributeDefinition(name="Client Id", type=AttributeType.STRING)
		String getClientid();
		
		@AttributeDefinition(name="Client Secret", type=AttributeType.STRING)
		String getClientSecret();
		
		@AttributeDefinition(name="Redirect URI", type=AttributeType.STRING)
		String getRedirectURI();
		
		@AttributeDefinition(name="Home Redirect", type=AttributeType.STRING)
		String getHomeRedirect();
		
		@AttributeDefinition(name="Domain", type=AttributeType.STRING)
		String getDomain();
		
		@AttributeDefinition(name="Scopes", type=AttributeType.STRING)
		String getScopes();
		
		@AttributeDefinition(name="Environment Token Name", type=AttributeType.BOOLEAN)
		boolean isUseEnvTokenName();
		
		@AttributeDefinition(name="Login Redirect URI", type=AttributeType.STRING)
		String getLoginRedirectURI();
		
		@AttributeDefinition(name="Cookie Domain", type=AttributeType.STRING)
		String getCookieDomain();
		
		@AttributeDefinition(name="ID Token name", type=AttributeType.STRING)
		String getIdTokenCookieName();
		
		@AttributeDefinition(name="Authorize", type=AttributeType.STRING)
		String getAuthorize();
		
		@AttributeDefinition(name="OAuth Value", type=AttributeType.STRING)
		String getOAuth();
		
		@AttributeDefinition(name="Token", type=AttributeType.STRING)
		String getToken();
		
		@AttributeDefinition(name="Json", type=AttributeType.STRING)
		String getJson();
		
		@AttributeDefinition(name="Logout", type=AttributeType.STRING)
		String getLogout();
		
		@AttributeDefinition(name="Tenant", type=AttributeType.STRING)
		String getTenant();
		
		@AttributeDefinition(name="Roles")
		String[] getRoles();
		
		@AttributeDefinition(name="Default Landing Page", type=AttributeType.STRING)
		String getDefaultLandingPage();
		
		@AttributeDefinition(name="Error Page", type=AttributeType.STRING)
		String getErrorPagePath();
		
		@AttributeDefinition(name="Home Page", type=AttributeType.STRING)
		String getHomePath();

		@AttributeDefinition(name = "No Landing Pages", description = "If login is triggred from these pages, the user will land on default landing page, after login.")
		String[] getNoLandingPages();
		
		@AttributeDefinition(name="Logout redirect IDP path and parameters", type=AttributeType.STRING)
		String getLogoutRedirect();
	}

}
