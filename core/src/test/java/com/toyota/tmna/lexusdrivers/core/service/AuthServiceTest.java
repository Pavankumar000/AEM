package com.toyota.tmna.lexusdrivers.core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.services.AuthService;
import com.toyota.tmna.lexusdrivers.core.services.impl.AuthServiceImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class AuthServiceTest {
	private final AemContext context = new AemContext();
	
	Map<String, Object> configProps = new HashMap<>();
	
	
	@BeforeEach
	void setUp() throws NoSuchFieldException {
		
	}

	@Test
	public void checkHomePath() throws ServletException, IOException {
		AuthService authService = new AuthServiceImpl();
		configProps.put("getHomePath", "/content/lexusdrivers/register.html");
		configProps.put("getErrorPagePath","/content/lexusdrivers/error.html");
		configProps.put("getIdTokenCookieName","idTokenCookieName");
		configProps.put("getDomain", "https://test.account.lexus.com");
		configProps.put("getTenant", "/api");
		configProps.put("getOAuth", "/oauth2/realms/root/realms/");
		configProps.put("getBrandName", "Lexus");
		configProps.put("getToken", "/access_token");
		configProps.put("getClientid", "LexusWeb");
		configProps.put("getRedirectURI", "https://local.aem.lexus.com/lexusdrivers/account/login");
		configProps.put("getNoLandingPages", new String[]{"register"});
		configProps.put("getClientSecret", "6c44f3d5-5e65-430d-8f87-7d7b405b8af4");
		configProps.put("getHomeRedirect", "/lexusdrivers/");
		configProps.put("getScopes", "openid profile");
		configProps.put("isUseEnvTokenName", true);
		configProps.put("getAuthorize", "/authorize");
		configProps.put("getJson", "/json/realms/root/realms/");
		configProps.put("getRoles", new String[] {"Shopper","Buyer","Owner","Driver"});
		configProps.put("getDefaultLandingPage", "https://dev-aem-ld.origin.cepo-proxy.tms.aws.lexus.com/lexusdrivers");
		context.registerInjectActivateService(authService, configProps);
		assertEquals("/content/lexusdrivers/register.html", authService.getHomePath());
		assertEquals("/content/lexusdrivers/error.html", authService.getErrorPagePath());
		assertEquals("https://test.account.lexus.com", authService.getDomain());
		assertEquals("/api", authService.getTenant());
		assertEquals("/oauth2/realms/root/realms/", authService.getoAuth());
		assertEquals("Lexus", authService.getBrandName());
		assertEquals("/access_token", authService.getToken());
		assertEquals("LexusWeb", authService.getClientid());
		assertEquals("https://local.aem.lexus.com/lexusdrivers/account/login", authService.getRedirectURI());
		assertEquals("register", authService.getNoLandingPages()[0]);
		assertEquals("6c44f3d5-5e65-430d-8f87-7d7b405b8af4", authService.getClientSecret());
		assertEquals("/lexusdrivers/", authService.getHomeRedirect());
		assertEquals("openid profile", authService.getScopes());
		assertEquals(true, authService.getUseEnvTokenName());
		assertEquals("/authorize", authService.getAuthorize());
		assertEquals("/json/realms/root/realms/", authService.getJson());
		assertEquals("Shopper", authService.getRoles()[0]);
		assertEquals("https://dev-aem-ld.origin.cepo-proxy.tms.aws.lexus.com/lexusdrivers", authService.getDefaultLandingPage());
		assertEquals("idTokenCookieName",authService.getIdTokenCookieName());
	}
}
