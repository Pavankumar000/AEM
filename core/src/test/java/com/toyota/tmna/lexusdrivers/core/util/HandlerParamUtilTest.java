package com.toyota.tmna.lexusdrivers.core.util;

import io.wcm.testing.mock.aem.junit5.AemContext;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class HandlerParamUtilTest {

    HandlerParamUtil handlerParamUtil;
    MockSlingHttpServletResponse mockSlingHttpServletResponse;
    MockSlingHttpServletRequest mockSlingHttpServletRequest;
    private final AemContext context = new AemContext();

    @BeforeEach
    void setup() {
        handlerParamUtil = new HandlerParamUtil();
        mockSlingHttpServletRequest = context.request();
    }

    @Test
    void getId (){
        mockSlingHttpServletRequest.addRequestParameter("id", "id");
        String id = handlerParamUtil.getId(mockSlingHttpServletRequest);
        assertEquals("id", id);
    }

    @Test
    void getType (){
        mockSlingHttpServletRequest.addRequestParameter("type", "type");
        String id = handlerParamUtil.getType(mockSlingHttpServletRequest);
        assertEquals("type", id);
    }

    @Test
    void getState (){
        mockSlingHttpServletRequest.addRequestParameter("state", "state");
        String id = handlerParamUtil.getState(mockSlingHttpServletRequest);
        assertEquals("state", id);
    }

    @Test
    void getZip (){
        mockSlingHttpServletRequest.addRequestParameter("zip", "zip");
        String id = handlerParamUtil.getZip(mockSlingHttpServletRequest);
        assertEquals("zip", id);
    }

    @Test
    void getStartIndex (){
        mockSlingHttpServletRequest.addRequestParameter("start_index", "start_index");
        String id = handlerParamUtil.getStartIndex(mockSlingHttpServletRequest);
        assertEquals("start_index", id);
    }

    @Test
    void getCategory (){
        mockSlingHttpServletRequest.addRequestParameter("category", "category");
        String id = handlerParamUtil.getCategory(mockSlingHttpServletRequest);
        assertEquals("category", id);
    }

    @Test
    void getSize (){
        mockSlingHttpServletRequest.addRequestParameter("size", "size");
        String id = handlerParamUtil.getSize(mockSlingHttpServletRequest);
        assertEquals("size", id);
    }

}
