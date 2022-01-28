package com.toyota.tmna.lexusdrivers.core.util;

import com.google.gson.JsonObject;
import com.toyota.tmna.lexusdrivers.core.bean.UserInfo;
import com.toyota.tmna.lexusdrivers.core.services.impl.AuthServiceImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;

import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import java.util.Base64;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.http.Cookie;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AEMServletUtilTest {

    AEMServletUtil aemServletUtil;
    public static final String COOKIE_NAME = "idToken";
    public static final String COOKIE_VALUE = "idToken_Value";
    MockSlingHttpServletResponse mockSlingHttpServletResponse;
    MockSlingHttpServletRequest mockSlingHttpServletRequest;
    private final AemContext context = new AemContext();

    @Test
    void createCookieTest(){
        mockSlingHttpServletResponse = context.response();
        mockSlingHttpServletRequest = context.request();
        Cookie cookie = new Cookie(COOKIE_NAME, COOKIE_VALUE);
        mockSlingHttpServletRequest.addCookie(cookie);
        aemServletUtil.createCookie(COOKIE_NAME, COOKIE_VALUE, mockSlingHttpServletResponse);
        aemServletUtil.resetCookie(mockSlingHttpServletRequest, mockSlingHttpServletResponse, COOKIE_NAME);
        aemServletUtil.setUser(mockSlingHttpServletRequest, new UserInfo());
    }

    @Test
    void handleStateTest() throws UnsupportedEncodingException {
        mockSlingHttpServletResponse = context.response();
        String url = "http://www.google.com\\r";
        String expected = "http://www.google.com";
        String actual = aemServletUtil.handleState(Base64.getEncoder().encodeToString(url.getBytes()));
        assertEquals(expected, actual);
    }

    @Test
    void handleStateTest_2() throws UnsupportedEncodingException {
        mockSlingHttpServletResponse = context.response();
        String url = "http://www.google.com\\n";
        String expected = "http://www.google.com";
        String actual = aemServletUtil.handleState(Base64.getEncoder().encodeToString(url.getBytes()));
        assertEquals(expected, actual);
    }

    @Test
    void isValidCookieTrue() {
        mockSlingHttpServletRequest = context.request();
        Cookie cookie = new Cookie(COOKIE_NAME, COOKIE_VALUE);
        mockSlingHttpServletRequest.addCookie(cookie);
        Boolean isValid = aemServletUtil.isValidCookie(mockSlingHttpServletRequest,COOKIE_NAME);
        assertEquals(Boolean.TRUE, isValid);
    }

    @Test
    void isValidCookieFalse() {
        mockSlingHttpServletRequest = context.request();
        Cookie cookie = new Cookie(COOKIE_NAME, COOKIE_VALUE);
        mockSlingHttpServletRequest.addCookie(cookie);
        Boolean isValid = aemServletUtil.isValidCookie(mockSlingHttpServletRequest,"CookieFalse");
        assertEquals(Boolean.FALSE, isValid);
    }

    @Test
    void getCookieTokenTest() {
        mockSlingHttpServletRequest = context.request();
        Cookie cookie = new Cookie(COOKIE_NAME, COOKIE_VALUE);
        mockSlingHttpServletRequest.addCookie(cookie);
        String cookieActual = aemServletUtil.getCookieToken(mockSlingHttpServletRequest,COOKIE_NAME);
        assertEquals(COOKIE_VALUE, cookieActual);
    }

    @Test
    void getJsonMessageTest(){
        JsonObject object = aemServletUtil.getErrorJson("ErrorMessage");
        assertNotNull(object);
    }

    @Test
    void getNullUserTest() {
        UserInfo user = AEMServletUtil.getUser(null);
        assertNull(user);
    }

    @Test
    void getUserTest() {
        mockSlingHttpServletRequest = context.request();
        UserInfo user = new UserInfo();
        user.setFirstName("firstName");
        mockSlingHttpServletRequest.setAttribute("user", user);
        UserInfo actualUser = AEMServletUtil.getUser(mockSlingHttpServletRequest);
        assertNull(actualUser);
    }

    @Test
    void getValidRefererTest() {
        String referer = AEMServletUtil.getValidReferer("", new AuthServiceImpl());
        assertNotNull(referer);
    }

    @Test
    void removeUserTest(){
        mockSlingHttpServletRequest = context.request();
        mockSlingHttpServletRequest.addHeader("first_name","lexus");
        mockSlingHttpServletRequest.addHeader("last_name","drivers");
        AEMServletUtil.removeUser( mockSlingHttpServletRequest);
    }

    @Test
    void getHeaderInformationTest(){
        mockSlingHttpServletRequest = context.request();
        mockSlingHttpServletRequest.addHeader("first_name","lexus");
        mockSlingHttpServletRequest.addHeader("last_name","drivers");
        AEMServletUtil.getHeaderInformation( mockSlingHttpServletRequest);
    }

    @Test
    void getHostHeaderInformationTest() {
        mockSlingHttpServletRequest = context.request();
        mockSlingHttpServletRequest.addHeader("host","drivers.lexus.com");
        String host = AEMServletUtil.getHostHeaderInformation( mockSlingHttpServletRequest ,"drivers.lexus.com");
        assertEquals("https://drivers.lexus.com", host);
    }

    @Test
    void getHostHeaderInformationTestNullHost() {
        mockSlingHttpServletRequest = context.request();
        mockSlingHttpServletRequest.setServerName("drivers.lexus.com");
        String host = AEMServletUtil.getHostHeaderInformation( mockSlingHttpServletRequest,"drivers.lexus.com");
        assertEquals("https://drivers.lexus.com", host);
    }


}