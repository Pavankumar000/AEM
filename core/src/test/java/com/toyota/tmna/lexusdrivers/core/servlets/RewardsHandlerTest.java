package com.toyota.tmna.lexusdrivers.core.servlets;

import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.services.RewardsService;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(AemContextExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class RewardsHandlerTest {
    private final AemContext context = new AemContext();
    @InjectMocks
    RewardsHandler servlet = new RewardsHandler();
    MockSlingHttpServletRequest request;
    MockSlingHttpServletResponse response;
    @Mock
    RewardsService rewardsService;

    @BeforeEach
    public void initialize(){
        MockitoAnnotations.initMocks(this);
        this.rewardsService = Mockito.mock(RewardsService.class);
    }

    @Test
    void doGetTest() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("id","id");
        servlet.doGet(request, response);
    }

    @Test
    void doGetTestrelated() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("id","id");
        request.addRequestParameter("type","related");
        servlet.doGet(request, response);
    }

    @Test
    void doGetTestrewards() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("id","id");
        request.addRequestParameter("type","rewards");
        servlet.doGet(request, response);
    }

    @Test
    void doGetTeststates() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("id","id");
        request.addRequestParameter("type","states");
        servlet.doGet(request, response);
    }

    @Test
    void doGetTestcategories() throws ServletException, IOException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("id","id");
        request.addRequestParameter("type","categories");
        servlet.doGet(request, response);
    }


}
