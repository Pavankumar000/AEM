package com.toyota.tmna.lexusdrivers.core.servlets;

import com.toyota.tmna.lexusdrivers.core.search.services.StoriesService;
import com.toyota.tmna.lexusdrivers.core.search.services.VideosService;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletException;
import java.io.IOException;

@ExtendWith(AemContextExtension.class)
public class StoriesHandlerTest {
    private final AemContext context = new AemContext();
    @InjectMocks
    StoriesHandler servlet = new StoriesHandler();
    MockSlingHttpServletRequest request;
    MockSlingHttpServletResponse response;
    @Mock
    StoriesService storiesService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        this.storiesService = Mockito.mock(StoriesService.class);
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        servlet.doGet(request, response);
    }

    @Test
    void doGetTestCategory() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("category", "category");
        servlet.doGet(request, response);
    }

    @Test
    void doGetTestId() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("id", "id");
        servlet.doGet(request, response);
    }

    @Test
    void doGetTestType() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("id", "id");
        request.addRequestParameter("type", "related");
        servlet.doGet(request, response);
    }


}
