package com.toyota.tmna.lexusdrivers.core.servlets;


import com.toyota.tmna.lexusdrivers.core.bean.UserInfo;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.servlethelpers.MockSlingHttpServletResponse;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import java.io.IOException;

@ExtendWith({ AemContextExtension.class, MockitoExtension.class })
public class UserInfoServletTest {

    MockSlingHttpServletRequest request;
    MockSlingHttpServletResponse response;
    private final AemContext context = new AemContext();
    UserInfoServlet servlet = new UserInfoServlet();

    @BeforeEach
    void setUp() {
        context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/GlobalNavServletPage.json",
                "/content/lexusdrivers/us/en/lexusdrivers");
        context.load().json("/com/toyota/tmna/lexusdrivers/core/servlets/GlobalNavServletTemplate.json",
                "/conf/lexusdrivers/settings/wcm/templates/content-template");
        request = context.request();
        response = context.response();

    }

    @Test
    void dogetTest() throws ServletException, IOException {
        servlet.doGet(request, response);
    }

    @Test
    void dogetTestWithInfo() throws ServletException, IOException {
        Cookie cookie = new Cookie("id_token", "eyJ0eXAiOiJKV1QiLCJraWQiOiJ3VTNpZklJYUxPVUFSZVJCL0ZHNmVNMVAxUU09IiwiYWxnIjoiUlMyNTYifQ.eyJhdF9oYXNoIjoiMkx2d1VHWjdKSXNPQnhValZ2eFlpUSIsInNpZ25JblR5cGUiOiJMT0NBTCIsInN1YiI6ImFhY2E2YzYzLTNjNTktNGVlOS1iZTZmLTA5YWNmNTViNmJkOSIsImV4dGVuc2lvbl90bXNndWlkIjoiYWFjYTZjNjMzYzU5NGVlOWJlNmYwOWFjZjU1YjZiZDkiLCJhdWRpdFRyYWNraW5nSWQiOiJkN2UyOTU5NC1iODg4LTRhNmQtYjk0NC02MTE1ODllZTFlZTEtNTg0MSIsImlzcyI6Imh0dHBzOi8vdGVzdC5hY2NvdW50LmxleHVzLmNvbS9hcGkvb2F1dGgyL3JlYWxtcy9yb290L3JlYWxtcy9sZXh1cyIsInRva2VuTmFtZSI6ImlkX3Rva2VuIiwib2lkIjoiZDg4YTU1ZDUtYmRkMS00Y2MwLTg4YmQtMzE0ZjhjMTRlMDZkIiwiZW1haWxzIjpbImxkdGVzdHVzZXJiYjVAZ21haWwuY29tIl0sImFjciI6IjAiLCJhenAiOiJMZXh1c1dlYiIsImF1dGhfdGltZSI6MTYwNjMwMTgxNiwiZXh0ZW5zaW9uX0VtYWlsVmVyaWZpZWQiOiJmYWxzZSIsImV4cCI6MTYwNjMwNTUxOCwiaWF0IjoxNjA2MzAxOTE4LCJlbWFpbCI6ImxkdGVzdHVzZXJiYjVAZ21haWwuY29tIiwiZ2l2ZW5fbmFtZSI6IkJvYiIsImF1ZCI6IkxleHVzV2ViIiwiY19oYXNoIjoiYi1rbEpQT3JLeGFIc01QczRNOTlSZyIsIm9yZy5mb3JnZXJvY2sub3BlbmlkY29ubmVjdC5vcHMiOiJoemF3MmsxNU1HcHlxUkttX25CS0JSdEZleUkiLCJzX2hhc2giOiJ0aWZmQTVuMTZ1TktYRVJiOGpKLWFRIiwibmFtZSI6IkJvYiBTbWl0aCIsInJlYWxtIjoiL2xleHVzIiwidG9rZW5UeXBlIjoiSldUVG9rZW4iLCJmYW1pbHlfbmFtZSI6IlNtaXRoIn0.BBm0ADQQaRxeYgUQY46LohKqguoQtKuelJpyHD0cMzVE8mwxeEhhr6CiDjJwJo63M1a8sW1Lvs1grjHBR4SM7mfM-VCSFtnyHC0PJCg5WotsLSWL-5PdXqN7m99Qedm-X0EbeuiKYfA6i5DMK8ur6-_RzQAFcJgJ38WaSkwFme-GnZq6WcfDZVbMKYW-jrjnVXFciu2vV1uAWuOSX3KBbHvJpVJdI4nm3ps-OU-flEVuFZPgTbFNhlD2RqN21M7-whPugNMgyT2HCavymGBqZx_RLBm8OLjfcE3afniYiixaTCrmrU73C6ELnuR4WRK_rQrQQXFtTbCa0qd0n9f7vw");
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName("lexus");
        userInfo.setLastName("drivers");
        userInfo.setIdToken("token");
        userInfo.setSigninType("social");
        request.setAttribute("user", userInfo);
        request.getSession().setAttribute("user", userInfo);
        request.addCookie(cookie);
        servlet.doGet(request, response);
    }
}
