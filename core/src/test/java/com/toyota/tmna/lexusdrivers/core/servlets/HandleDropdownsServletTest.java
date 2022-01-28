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
public class HandleDropdownsServletTest {
	private final AemContext context = new AemContext();
	HandleDropdownsServlet handleDropdownsServlet = new HandleDropdownsServlet();
	
	MockSlingHttpServletRequest request;
	MockSlingHttpServletResponse response;

	@BeforeEach
	void setUp() {
		context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/HandleDropdownsServletTest.json",
				"/apps/lexusdrivers/components/content/addressinput/cq:dialog/content/items");

		context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/HandleDropdownsServletTestData.json",
				"/apps/lexusdrivers/components/core/content/dropdownlists/v1");
		request = context.request();
		response = context.response();
	}

	@Test
	public void checkResponseStatus() throws ServletException, IOException {
		context.currentResource("/apps/lexusdrivers/components/content/addressinput/cq:dialog/content/items");
		handleDropdownsServlet.doGet(request, response);
		assertEquals(200, response.getStatus());
	}

	@Test
	public void checkResponseStatusNoData() throws ServletException, IOException {
		final AemContext context2 = new AemContext();
		context2.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/HandleDropdownsServletTest.json",
				"/apps/lexusdrivers/components/content/addressinput/cq:dialog/content/items");

		context2.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/HandleDropdownsServletTestNullData.json",
				"/apps/lexusdrivers/components/core/content/dropdownlists/v1");
		request = context2.request();
		response = context2.response();
		context2.currentResource(
				"/apps/lexusdrivers/components/content/addressinput/cq:dialog/content/items/validationRulesone");
		handleDropdownsServlet.doGet(request, response);
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void checkResponseStatusOne() throws ServletException, IOException {
		context.currentResource(
				"/apps/lexusdrivers/components/content/addressinput/cq:dialog/content/items/validationRules");
		handleDropdownsServlet.doGet(request, response);
		assertEquals(200, response.getStatus());
	}
	
	@Test
	public void checkResponseStatusTwo() throws ServletException, IOException {
		context.currentResource(
				"/apps/lexusdrivers/components/content/addressinput/cq:dialog/content/items/validationRulesone");
		handleDropdownsServlet.doGet(request, response);
		assertEquals(200, response.getStatus());
	}

}
