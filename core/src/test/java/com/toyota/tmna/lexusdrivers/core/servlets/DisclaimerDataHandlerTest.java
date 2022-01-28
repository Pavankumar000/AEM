package com.toyota.tmna.lexusdrivers.core.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toyota.tmna.lexusdrivers.core.search.domain.SearchResponse;
import com.toyota.tmna.lexusdrivers.core.search.services.DisclaimerService;
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
public class DisclaimerDataHandlerTest {
    private final AemContext context = new AemContext();
    @InjectMocks
    DisclaimerDataHandler servlet = new DisclaimerDataHandler();
    MockSlingHttpServletRequest request;
    MockSlingHttpServletResponse response;
    @Mock
    DisclaimerService disclaimerService;
    @Mock
    ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        this.disclaimerService = Mockito.mock(DisclaimerService.class);
        this.objectMapper = Mockito.mock(ObjectMapper.class);
    }

    @Test
    void doGetTest_emptycheck() throws IOException, ServletException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("id","");
        SearchResponse data = new SearchResponse();
        disclaimerService = Mockito.mock(DisclaimerService.class);
        when(disclaimerService.getDisclaimerById("1")).thenReturn(data);
        //when(data.getData()).thenReturn();
        servlet.doGet(request, response);
    }

    @Test
    void doGetTest_nullcheck() throws IOException, ServletException {
        request = context.request();
        response = context.response();
        //request.addRequestParameter("id","");
        SearchResponse data = new SearchResponse();
        disclaimerService = Mockito.mock(DisclaimerService.class);
        when(disclaimerService.getDisclaimerById("1")).thenReturn(data);
        //when(data.getData()).thenReturn();
        servlet.doGet(request, response);
    }

   /* @Test
    void doGetTest() throws IOException, ServletException {
        request = context.request();
        response = context.response();
        request.addRequestParameter("id","1");
        SearchResponse disclaimerResponse = new SearchResponse();
        List<String> stringList = new ArrayList<>();
        stringList.add("String");
        disclaimerResponse.setData(stringList);
        when(disclaimerService.getDisclaimerById("1")).thenReturn(disclaimerResponse);
        when(objectMapper.writeValueAsString(stringList)).thenReturn("String");
        servlet.doGet(request, response);
    }*/
}
