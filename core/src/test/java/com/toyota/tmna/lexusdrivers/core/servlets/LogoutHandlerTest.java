package com.toyota.tmna.lexusdrivers.core.servlets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import org.apache.sling.servlethelpers.MockSlingHttpServletResponse;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.toyota.tmna.lexusdrivers.core.services.AuthService;
import com.toyota.tmna.lexusdrivers.core.services.impl.AuthServiceImpl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.util.PrivateAccessor;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class LogoutHandlerTest {
	private final AemContext context = new AemContext();
	LogoutHandler logoutHandler = new LogoutHandler();

	
	AuthService authService;
	
	@BeforeEach
	void setUp() throws NoSuchFieldException {
		authService = new AuthServiceImpl();
	}
	
	@Test
	public void checkLogout() throws ServletException, IOException, NoSuchFieldException {
		Map<String, Object> configProps = new HashMap<>();
		context.registerInjectActivateService(authService, configProps);
		PrivateAccessor.setField(logoutHandler, "authService", authService);
		MockSlingHttpServletRequest request = context.request();
		MockSlingHttpServletResponse response = context.response();
		logoutHandler.doGet(request, response);
		int expected = 200;
		int actual = response.getStatus();
		assertEquals(expected, actual );
	}
	
	/*Check Response Status of Servlet*/
	@Test
	public void checkLogoutOne() throws ServletException, IOException, NoSuchFieldException {
		
		Map<String, Object> configProps = new HashMap<>();
		configProps.put("getDomain", "https://test.account.lexus.com");
		configProps.put("getTenant", "/api");
		configProps.put("getOAuth", "/oauth2/realms/root/realms/");
		configProps.put("getBrandName", "Lexus");
		configProps.put("getLogout", "/sessions/?_action=logout");
		configProps.put("getClientid", "LexusWeb");
		
		context.registerInjectActivateService(authService, configProps);
		PrivateAccessor.setField(logoutHandler, "authService", authService);
		
		MockSlingHttpServletRequest request = context.request();
		MockSlingHttpServletResponse response = context.response();
		
		Cookie cookie = new Cookie("id_token", "eyJ0eXAiOiJKV1QiLCJraWQiOiJ3VTNpZklJYUxPVUFSZVJCL0ZHNmVNMVAxUU09IiwiYWxnIjoiUlMyNTYifQ.eyJhdF9oYXNoIjoiMkx2d1VHWjdKSXNPQnhValZ2eFlpUSIsInNpZ25JblR5cGUiOiJMT0NBTCIsInN1YiI6ImFhY2E2YzYzLTNjNTktNGVlOS1iZTZmLTA5YWNmNTViNmJkOSIsImV4dGVuc2lvbl90bXNndWlkIjoiYWFjYTZjNjMzYzU5NGVlOWJlNmYwOWFjZjU1YjZiZDkiLCJhdWRpdFRyYWNraW5nSWQiOiJkN2UyOTU5NC1iODg4LTRhNmQtYjk0NC02MTE1ODllZTFlZTEtNTg0MSIsImlzcyI6Imh0dHBzOi8vdGVzdC5hY2NvdW50LmxleHVzLmNvbS9hcGkvb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9sZXh1cyIsInRva2VuTmFtZSI6ImlkX3Rva2VuIiwib2lkIjoiZDg4YTU1ZDUtYmRkMS00Y2MwLTg4YmQtMzE0ZjhjMTRlMDZkIiwiZW1haWxzIjpbImxkdGVzdHVzZXJiYjVAZ21haWwuY29tIl0sImFjciI6IjAiLCJhenAiOiJMZXh1c1dlYiIsImF1dGhfdGltZSI6MTYwNjMwMTgxNiwiZXh0ZW5zaW9uX0VtYWlsVmVyaWZpZWQiOiJmYWxzZSIsImV4cCI6MTYwNjMwNTUxOCwiaWF0IjoxNjA2MzAxOTE4LCJlbWFpbCI6ImxkdGVzdHVzZXJiYjVAZ21haWwuY29tIiwiZ2l2ZW5fbmFtZSI6IkJvYiIsImF1ZCI6IkxleHVzV2ViIiwiY19oYXNoIjoiYi1rbEpQT3JLeGFIc01QczRNOTlSZyIsIm9yZy5mb3JnZXJvY2sub3BlbmlkY29ubmVjdC5vcHMiOiJoemF3MmsxNU1HcHlxUkttX25CS0JSdEZleUkiLCJzX2hhc2giOiJ0aWZmQTVuMTZ1TktYRVJiOGpKLWFRIiwibmFtZSI6IkJvYiBTbWl0aCIsInJlYWxtIjoiL2xleHVzIiwidG9rZW5UeXBlIjoiSldUVG9rZW4iLCJmYW1pbHlfbmFtZSI6IlNtaXRoIn0.BBm0ADQQaRxeYgUQY46LohKqguoQtKuelJpyHD0cMzVE8mwxeEhhr6CiDjJwJo63M1a8sW1Lvs1grjHBR4SM7mfM-VCSFtnyHC0PJCg5WotsLSWL-5PdXqN7m99Qedm-X0EbeuiKYfA6i5DMK8ur6-_RzQAFcJgJ38WaSkwFme-GnZq6WcfDZVbMKYW-jrjnVXFciu2vV1uAWuOSX3KBbHvJpVJdI4nm3ps-OU-flEVuFZPgTbFNhlD2RqN21M7-whPugNMgyT2HCavymGBqZx_RLBm8OLjfcE3afniYiixaTCrmrU73C6ELnuR4WRK_rQrQQXFtTbCa0qd0n9f7vw");
		request.addCookie(cookie);
		Cookie cookie1 = new Cookie("access_token", "Bn-rmja6mrSOEgSTwNK8On_1e4I");
		request.addCookie(cookie1);
		logoutHandler.doGet(request, response);
		int expected = 200;
		int actual = response.getStatus();
		assertEquals(expected, actual );
	}

	@Test
	public void userRedirectTest() throws NoSuchFieldException{
		Map<String, Object> configProps = new HashMap<>();
		configProps.put("getDomain", "https://test.account.lexus.com");
		configProps.put("getTenant", "/api");
		configProps.put("getOAuth", "/oauth2/realms/root/realms/");
		configProps.put("getBrandName", "Lexus");
		configProps.put("getLogout", "/sessions/?_action=logout");
		configProps.put("getClientid", "LexusWeb");
		context.registerInjectActivateService(authService, configProps);
		PrivateAccessor.setField(logoutHandler, "authService", authService);
		MockSlingHttpServletResponse response = context.response();
		MockSlingHttpServletRequest request = context.request();
		logoutHandler.userRedirect(response, "referrer",request);
	}

	@Test
	public void logoutIdpTest() throws ServletException, IOException, NoSuchFieldException {

			Map<String, Object> configProps = new HashMap<>();
			configProps.put("getDomain", "https://stage.account.lexus.com");
			configProps.put("getTenant", "/api");
			configProps.put("getOAuth", "/oauth2/realms/root/realms/");
			configProps.put("getBrandName", "Lexus");
			configProps.put("getLogout", "/sessions/?_action=logout");
			configProps.put("getClientid", "LexusWeb");
			context.registerInjectActivateService(authService, configProps);
			PrivateAccessor.setField(logoutHandler, "authService", authService);
			MockSlingHttpServletResponse response = context.response();
			MockSlingHttpServletRequest request = context.request();
			/*assertThrows(ServletException.class,() -> {
				logoutHandler.logoutIdp("token", "token",request);
			});*/

	}

}
