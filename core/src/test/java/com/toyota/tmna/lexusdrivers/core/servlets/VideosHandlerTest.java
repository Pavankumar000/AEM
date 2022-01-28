package com.toyota.tmna.lexusdrivers.core.servlets;

import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.services.RewardsService;
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

import static org.mockito.Mockito.when;

@ExtendWith(AemContextExtension.class)
public class VideosHandlerTest {
    private final AemContext context = new AemContext();
    @InjectMocks
    VideosHandler servlet = new VideosHandler();
    MockSlingHttpServletRequest request;
    MockSlingHttpServletResponse response;
    @Mock
    VideosService videosService;

    @BeforeEach
    public void initialize(){
        MockitoAnnotations.initMocks(this);
        this.videosService = Mockito.mock(VideosService.class);
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("id","id");
        servlet.doGet(request, response);
    }

    @Test
    void doGetTestNoId() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        servlet.doGet(request, response);
    }

    @Test
    void doGetTestrelated() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("type","related");
        servlet.doGet(request, response);
    }

    @Test
    void doGetTestcategories() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("type","categories");
        servlet.doGet(request, response);
    }
}
