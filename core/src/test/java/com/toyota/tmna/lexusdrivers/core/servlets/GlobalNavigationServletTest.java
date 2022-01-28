package com.toyota.tmna.lexusdrivers.core.servlets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.sling.servlethelpers.MockSlingHttpServletResponse;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class GlobalNavigationServletTest {
	
	private final AemContext context = new AemContext();
	GlobalNavigationServlet servlet = new GlobalNavigationServlet();
	MockSlingHttpServletRequest request;
	MockSlingHttpServletResponse response;
	
	@BeforeEach
	void setUp() throws NoSuchFieldException {
		context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/GlobalNavServletPage.json",
				"/content/lexusdrivers/us/en/lexusdrivers");
		context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/GlobalNavServletTemplate.json",
				"/conf/lexusdrivers/settings/wcm/templates/content-template");
		request = context.request();
		response = context.response();
	}
	
	@Test
	public void checkGlobalNav() throws ServletException, IOException {
		servlet.doGet(request, response);
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void checkGlobalNavOne() throws ServletException, IOException {
		context.currentResource("/content/lexusdrivers/us/en/lexusdrivers");
		servlet.doGet(request, response);
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void checkGlobalNavTwo() throws ServletException, IOException {
		context.currentResource("/content/lexusdrivers/us/en/lexusdrivers/account");
		servlet.doGet(request, response);
		assertEquals(200, response.getStatus());
	}

}